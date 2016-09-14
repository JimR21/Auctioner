package com.ted.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ted.model.Auction;
import com.ted.model.AuctionPicture;
import com.ted.repository.AuctionPictureRepository;

@Service("auctionPictureService")
public class AuctionPictureServiceImpl implements AuctionPictureService {
	
	@Autowired
	AuctionPictureRepository auctionPictureRepository;

	public List<AuctionPicture> saveMultipartList(MultipartFile[] images, Auction auction) {
		
		List<AuctionPicture> auctionPictures = null;
		
		if (images.length > 0) {
			for(MultipartFile image : images) {
				try {
					AuctionPicture auctionPicture = new AuctionPicture();
					auctionPicture.setAuctionPicturescol(image.getBytes());
					auctionPicture.setAuction(auction);
					auctionPictures.add(auctionPictureRepository.saveAndFlush(auctionPicture));
	
					System.out.println("You successfully saved picture!");
				} catch (Exception e) {
					System.out.println("You failed to save picture  => " + e.getMessage());
				}
			}
		}
		
		return auctionPictures;
		
	}

}
