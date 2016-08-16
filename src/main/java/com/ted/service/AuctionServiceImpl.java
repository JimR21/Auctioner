package com.ted.service;

import java.util.List;

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
	
	public List<Auction> getAllAuctions() {
		
		return auctionRepository.findAll();
		
	}

	public Auction getAuctionById(Integer id) {
		
		return auctionRepository.findByAuctionid(id);
		
	}

}
