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
	
	Page<Auction> findByIsBought(Boolean isBought, Pageable page);
	
	@Query(value = "SELECT a FROM Auction a WHERE :cat MEMBER OF a.categories AND a.isBought = false")
	Page<Auction> findByCategory(@Param("cat") Category cat, Pageable page);
	
	Page<Auction> findByNameContainingAndIsBought(String searchString, Boolean isBought, Pageable page);
	
	@Query(value = "SELECT * FROM auctions WHERE auctionid IN (SELECT a.auctionid "
			+ "FROM auction_bidding as a WHERE a.bidder_userid IN "
			+ "(SELECT user2_id FROM similar WHERE user1_id = :userid) AND a.bidder_userid != :userid)", nativeQuery = true)
	List<Auction> findBySimilarUsers(@Param("userid") int userid);
	
	List<Auction> findByAuctionidIn(List<Integer> ids);
	
	@Query(value = "SELECT auctionid FROM auction_bidding GROUP BY auctionid ORDER BY COUNT(*) DESC LIMIT :limit", nativeQuery = true)
	List<Integer> getTopAuctionsIds(@Param("limit") int limit);
	
	/* Dashboard Info */
	@Query(value = "SELECT COUNT(*) FROM auctions WHERE started >= ( CURDATE() - INTERVAL 3 DAY )", nativeQuery = true)
	Long countLast3Days();
	
	List<Auction> findTop5ByOrderByStarted();

}
