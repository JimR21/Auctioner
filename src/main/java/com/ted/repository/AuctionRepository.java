package com.ted.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ted.model.Auction;

@Repository("auctionRepository")
public interface AuctionRepository extends JpaRepository<Auction, Long> {
	
	Auction findByAuctionid(int id);

}
