package com.ted.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ted.model.AuctionPicture;

@Repository("auctionPictureRepository")
public interface AuctionPictureRepository extends JpaRepository<AuctionPicture, Long> {

}
