package com.ted.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;

import com.ted.model.Auction;
import com.ted.model.BidResponse;
import com.ted.model.FormAuction;

public interface AuctionService {

	void saveAuction(Auction auction);
	
	List<Auction> getAllAuctions();
	
	Page<Auction> pageAuctions(HttpServletRequest request);
	
	Auction getAuctionById(Integer id);

	void updateFilter(HttpServletRequest request);
	
	BidResponse checkBids(Integer numofBids, Integer id);
	
	String bidSave(Integer auctionId, String bidAmount);
	
	void initializeMapper(Integer auctionId);
	
	String saveFormAuction(FormAuction formAuction);

}
