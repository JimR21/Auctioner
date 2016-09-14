package com.ted.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ted.model.Auction;
import com.ted.model.AuctionPicture;

public interface AuctionPictureService {
	
	List<AuctionPicture> saveMultipartList(MultipartFile[] files, Auction auction);

}
