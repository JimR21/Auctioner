package com.ted.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ted.model.Auction;
import com.ted.model.AuctionBidding;
import com.ted.model.AuctionBiddingPK;
import com.ted.model.AuctionInfo;
import com.ted.model.AuctionMapper;
import com.ted.model.Bid;
import com.ted.model.BidResponse;
import com.ted.model.Filter;
import com.ted.repository.AuctionBiddingRepository;
import com.ted.repository.AuctionRepository;
import com.ted.repository.CategoryRepository;

@Service("auctionService")
public class AuctionServiceImpl implements AuctionService {
	
	@Autowired
	AuctionRepository auctionRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	AuctionBiddingRepository auctionBiddingRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	Filter filter;
	
	@Autowired
	AuctionMapper auctionMapper;

	@Transactional
	public void saveAuction(Auction auction) {
		
		auctionRepository.save(auction);
		
	}
	
	public List<Auction> getAllAuctions() {
		
		return auctionRepository.findAllByOrderByStarted();
		
	}

	public Auction getAuctionById(Integer id) {
		
		return auctionRepository.findByAuctionid(id);
		
	}

	/* Paging and filtering results */
	public Page<Auction> pageAuctions(HttpServletRequest request) {
		
		String pageString = request.getParameter("page");
		Integer pageNumber = 1;
		
		Page<Auction> auctions = null;
		
		Sort sort = null;
		Pageable page = null;

		sort = new Sort(Sort.Direction.ASC, filter.getSortBy());
		
		if(pageString != null) {
			pageNumber = Integer.parseInt(pageString);
			page = new PageRequest(pageNumber - 1, 15, sort);
		}
		else {
			page = new PageRequest(0, 15, sort);
		}
		
		if(filter.getCategory() != null) {
			auctions = auctionRepository.findByCategory(filter.getCategory(), page);
			//auctions = auctionRepository.findAll(page);
		}
		else {
			auctions = auctionRepository.findAll(page);
		}
		
		filter.setNumberofPages(auctions.getTotalPages());
		filter.setNumberofItems(auctions.getTotalElements());
		filter.setPageNum(pageNumber);
		
		/* Paging order */
		ArrayList<Integer> pageList = new ArrayList<Integer>();
		
		for(int i = 3; i > 0; i--) {
			if(pageNumber - i > 0)
				pageList.add(pageNumber - i);
		}
		pageList.add(pageNumber);
		for(int j = 1; j < 4; j++) {
			if(pageNumber + j < filter.getNumberofPages())
				pageList.add(pageNumber + j);
		}
		
		filter.setPages(pageList);
		
		return auctions;

	}

	/* Update filter session bean */
	public void updateFilter(HttpServletRequest request) {
		
		String categoryId = request.getParameter("categoryId");
		String price = request.getParameter("price");
		String sortBy = request.getParameter("sortBy");
		
		if(categoryId != null) {
			if(categoryId.equals("all"))
				filter.setCategory(null);
			else
				filter.setCategory(categoryRepository.findByCategoryId(Integer.parseInt(categoryId)));
		}
		
		if(price != null) {
			filter.setPrice(price);
		}
		
		if(sortBy != null) {
			filter.setSortBy(sortBy);
			
			if(sortBy.equals("ends"))
				filter.setSortByOutput("Ending Date");
			else if(sortBy.equals("firstBid")) {
				filter.setSortByOutput("Starting Price");
			}
		}
	}
	
	/* Response preparation for ajax request checkBids */
	public BidResponse checkBids(Integer numofBids, Integer auctionId) {
		
		Auction auction = null;
		BidResponse bidResponse = new BidResponse();
		List<Bid> bids = new ArrayList<Bid>(); 
		
		/* Loop for 30 seconds */
		for(int i = 0; i < 300; i++) {
			
//			auction = getAuctionById(id);
//			
//			List<AuctionBidding> biddings = auction.getAuctionBiddings();
			
			initializeMapper(auctionId);	// Initializes if mapping doesn't exist
			
			AuctionInfo info = auctionMapper.getAuctionInfo(auctionId);	// Gets the current number of bids for the auction
			
			/* If there are new bids the response is prepared */
			if(info.getNumofBids() > numofBids) {
				
				System.out.println("Preparing response with " + (info.getNumofBids() - numofBids) + "bids");
				
				auction = getAuctionById(auctionId);
				List<AuctionBidding> biddings = auction.getAuctionBiddings();
				
				/* Sort bids */
				Collections.sort(biddings, new BidTimeComparator());
				
				for(int j = info.getNumofBids() - 1; j > numofBids - 1; j--) {
					
					AuctionBidding abid = biddings.get(j);
					
					Bid bid = new Bid();
					bid.setAmount(abid.getAmount());
					bid.setTime(abid.getTime().getTime());
					bid.setUsername(abid.getUser().getUsername());
					
					bids.add(bid);
				}
				
				bidResponse.setBids(bids);
				bidResponse.setInfo(info);
				
				return bidResponse;
			}
		
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Loop end");
		
		AuctionInfo info = new AuctionInfo();
		info.setNumofBids(numofBids);
		
		bidResponse.setInfo(info);
		
		return bidResponse;
	}

	/* Synchronized method to avoid race condition on persisting bid and updating AuctionMapper singleton bean */
	public synchronized String bidSave(Integer auctionId, String bidAmount) {
		
		System.out.println("Persisting amount: " + bidAmount);
		
		/* Check if auction id bought or bidAmount > latest bid amount */
		AuctionInfo info = auctionMapper.getAuctionInfo(auctionId);
		
		if(info.isBought()) {
			String msg = "The auction is already bought.";
			return msg;
		}
//		if(info.getLatestBid() > bidAmount) {
//			String msg = "Your bid must be bigger than the current price.";
//			return msg;
//		}
//		if(info.getEnds() < new Date().getTime()) {
//			String msg = "Sorry, the time has ended.";
//			return msg;
//		}
		
		/* Persist Bid */
		AuctionBidding auctionBidding = new AuctionBidding();
		auctionBidding.setAmount(bidAmount);
		auctionBidding.setTime(new Date());
		
		AuctionBiddingPK auctionBiddingPK = new AuctionBiddingPK();
		auctionBiddingPK.setAuctionid(auctionId);
		auctionBiddingPK.setBidderUserid(userService.getLoggedInUser().getUserid());
		
		auctionBidding.setId(auctionBiddingPK);
		
		auctionBiddingRepository.saveAndFlush(auctionBidding);
		
		System.out.println("Updating auctionMapper: " + bidAmount);
		
		/* Update auctionMapper */
		if(info.getBuyPrice() != null) {
			// TODO: Compare buyPrice
		}
		info.setBought(false);
		info.setLatestBid(bidAmount);
		info.setNumofBids(info.getNumofBids()+1);
		info.setEnds(auctionBidding.getTime().getTime());
		auctionMapper.setAuctionInfo(auctionId, info);
		
		System.out.println("Persisted amount: " + bidAmount);
		
		return null;
		
	}

	public void initializeMapper(Integer auctionId) {

		/* Initialize Auction Mapping if it doesn't exist */
		if(!auctionMapper.getMapper().containsKey(auctionId)) {
			
			Auction auction = getAuctionById(auctionId);
			List<AuctionBidding> biddings = auction.getAuctionBiddings();
			Integer numofBids = biddings.size();
			Collections.sort(biddings, new BidTimeComparator()); 	// Sort bids
			
			AuctionInfo info = new AuctionInfo();
			info.setEnds(auction.getEnds().getTime());
			info.setBuyPrice(auction.getBuyPrice());
			info.setNumofBids(numofBids);
			if(numofBids > 0)
				info.setLatestBid(biddings.get(numofBids-1).getAmount());
			
			auctionMapper.setAuctionInfo(auctionId, info);
			
		}

	}
}

class BidTimeComparator implements Comparator<AuctionBidding> {
    
    public int compare(AuctionBidding a, AuctionBidding b) {
        return a.getTime().getTime() < b.getTime().getTime() ? -1 : a.getTime().getTime() == b.getTime().getTime() ? 0 : 1;
    }
    
}
