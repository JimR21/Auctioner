package com.ted.service;

import java.util.List;

import com.ted.model.Auction;

public interface AuctionService {

	void saveAuction(Auction auction);
	
	List<Auction> getAllAuctions();
	
	Auction getAuctionById(Integer id);
	
}
