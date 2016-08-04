package com.ted.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ted.model.Auction;
import com.ted.repository.AuctionRepository;

@Service("auctionService")
public class AuctionServiceImpl implements AuctionService {
	
	@Autowired
	AuctionRepository auctionRepository;

	@Transactional
	public void saveAuction(Auction auction) {
		
		auctionRepository.save(auction);
		
	}

}
