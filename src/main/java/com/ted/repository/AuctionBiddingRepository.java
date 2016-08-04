package com.ted.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ted.model.AuctionBidding;
import com.ted.model.AuctionBiddingPK;

@Repository("auctionBiddingRepository")
public interface AuctionBiddingRepository extends JpaRepository<AuctionBidding, AuctionBiddingPK> {

}
