package com.ted.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ted.model.Auction;
import com.ted.model.Category;

@Repository("auctionRepository")
public interface AuctionRepository extends JpaRepository<Auction, Long> {
	
	Auction findByAuctionid(int id);
	
	List<Auction> findAllByOrderByStarted();
	
	Page<Auction> findAll(Pageable page);
	
	@Query(value = "SELECT a FROM Auction a WHERE :cat MEMBER OF a.categories")
	Page<Auction> findByCategory(@Param("cat") Category cat, Pageable page);
	
	Page<Auction> findByNameContaining(String searchString, Pageable page);

}
