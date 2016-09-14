package com.ted.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.ted.model.Auction;
import com.ted.model.BidResponse;
import com.ted.model.Category;
import com.ted.model.Filter;
import com.ted.model.FormAuction;
import com.ted.model.Location;
import com.ted.service.AuctionService;
import com.ted.service.CategoryService;

@Controller
@SessionAttributes("filter")
public class AuctionController {
	
	@Autowired
	AuctionService auctionService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	Filter filter;
	
	@RequestMapping(value = "auction/{id}", method = RequestMethod.GET)
	public String getAuction(Model model, @PathVariable Integer id) {
		
		Auction auction = auctionService.getAuctionById(id);
		model.addAttribute("auction", auction);
		
		/* End time in milliseconds */
		Long ends = auction.getEnds().getTime();
		model.addAttribute("ends", ends);
		
		return "auction";
	}
	
	@RequestMapping(value = "auction-list", method = RequestMethod.GET)
	public String getAuctionList(Model model) {
		
		return "auction-list";
	}
	
	@RequestMapping(value = "auctions", method = RequestMethod.GET)
	public String getAuctions(Model model, HttpServletRequest request) {		
		
		auctionService.updateFilter(request);
		
		Page<Auction> auctions = auctionService.pageAuctions(request);
		model.addAttribute("auctions", auctions.getContent());
		
		System.out.println(filter.getSortBy());
		
		model.addAttribute("filter", filter);
		
		return "auctions";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String searchAuctions(Model model, HttpServletRequest request) {
		
		request.setAttribute("categoryId", "all");
		
		auctionService.updateFilter(request);
		
		Page<Auction> auctions = auctionService.pageAuctions(request);
		model.addAttribute("auctions", auctions.getContent());
		
		System.out.println(filter.getSortBy());
		
		model.addAttribute("filter", filter);
		
		return "auctions";
	}

	@RequestMapping(value = "checkBids/{id}", method = RequestMethod.GET)
	public @ResponseBody BidResponse checkBids(@RequestParam(value="numofBids") Integer numofBids, @PathVariable Integer id) {

		System.out.println("NumofBids: " + numofBids);
		
		BidResponse bidResponse = auctionService.checkBids(numofBids, id);

		return bidResponse;
	}
	
//	@PreAuthorize("hasRole('ROLE_BIDDER')")
	@RequestMapping(value = "auction/bid/{id}", method = RequestMethod.POST)
	public @ResponseBody String auctionBidPost(Model model, @PathVariable Integer id, @RequestParam(value="bidAmount") String bidAmount) {
		
		System.out.println("BidPost controller");
		
		String msg = auctionService.bidSave(id, bidAmount);
		
		if(msg != null)
			return msg;
		
		return "OK";
	}
	
	@RequestMapping(value = "new-auction", method = RequestMethod.GET)
	public String newAuctionGet(Model model) {
		
		FormAuction formAuction = new FormAuction();
		Auction auction = new Auction();
		Location location = new Location();
		List<Category> categories = categoryService.getAllCategories();
		
		auction.setLocation(location);
		formAuction.setAuction(auction);
		formAuction.setCategoryName(null);
		
		model.addAttribute("formAuction", formAuction);
		model.addAttribute("categories", categories);
		
		return "new-auction";
	}
	
	@RequestMapping(value = "new-auction",  method = RequestMethod.POST)
	public String newAuctionPost(@Valid @ModelAttribute("formAuction") FormAuction formAuction, BindingResult result, Model model,
			@RequestParam("input1") MultipartFile[] images) {
		
		if(result.hasErrors()) {
			return "new-auction";
		}
		
		formAuction.setFiles(images);
		
		String error = auctionService.saveFormAuction(formAuction);
		
		if(error != null) {
			model.addAttribute("error", error);
			return "new-auction";
		}
		
		System.out.println("Auction Saved! " + formAuction.getAuction().getName());
		
		return "new-auction";
	}

}
