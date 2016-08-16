package com.ted.service;

import java.util.Date;
import java.util.List;

import com.ted.model.Auction;
import com.ted.model.Category;
import com.ted.model.Location;
import com.ted.model.User;
import com.ted.model.XmlSeller;

public interface XmlService {
	
	void saveXmlAuction(List<Auction> auctions, Integer j);

	User saveBidderUser(User user, Integer file_no, Integer auction_no, Integer bid_no);
	
	User saveSellerUser(XmlSeller seller, Integer file_no, Integer auction_no);
	
	Location saveLocation(Location location);
	
	List<Category> saveCategories(List<Category> categories);
	
	Date formatString(String dateString);
	
	void xmlUnmarshalling();

}
