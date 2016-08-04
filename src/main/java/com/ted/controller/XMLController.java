package com.ted.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ted.model.Auction;
import com.ted.model.AuctionBidding;
import com.ted.model.Category;
import com.ted.model.Location;
import com.ted.model.XmlAuctionWrapper;
import com.ted.model.XmlSeller;
import com.ted.service.AuctionService;
import com.ted.service.UserService;
import com.ted.service.XmlService;

@Controller
@RequestMapping(value = "/api")
public class XMLController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AuctionService auctionService;
	
	@Autowired
	XmlService xmlService;

	
	@RequestMapping(value="auction/get", method = RequestMethod.GET)
	public @ResponseBody XmlAuctionWrapper getAuctionInXML() {

		Auction auction = new Auction();
		
		auction.setAuctionid(1);
		auction.setCountry("USA");
		auction.setCurrently("$ 5.00");
		auction.setDescription("Gaming Headset for PC, PS4 & XBOX");
		auction.setFirstBid("$ 5.00");
		auction.setName("Razer Headset");
		auction.setStarted(new Date());
		auction.setEnds(new Date());
		auction.setBuyPrice("$ 100.00");
		auction.setNumberOfBids(0);
		auction.setUser(userService.getUserByUsername("geo21"));
		
		XmlSeller seller = new XmlSeller();
		seller.setRating("100");
		seller.setUsername("Auctioner");
		
		auction.setXmlSeller(seller);
		
		
		AuctionBidding bidding = new AuctionBidding();
		
		bidding.setAmount("$ 10.00");
		bidding.setId(null);
		bidding.setUser(userService.getUserByUsername("geo21"));
		bidding.setTime(new Date());
		bidding.setAuction(auction);
		
		AuctionBidding bidding2 = new AuctionBidding();
		
		bidding2.setAmount("$ 12.00");
		bidding2.setId(null);
		bidding2.setUser(userService.getUserByUsername("geo21"));
		bidding2.setTime(new Date());
		bidding2.setAuction(auction);
		
		List<AuctionBidding> bidList = new ArrayList<AuctionBidding>();
		bidList.add(bidding);
		bidList.add(bidding2);
		
		auction.setAuctionBiddings(bidList);
		
		
		Category category1 = new Category();
		category1.setCategoryId(1);
		category1.setName("PC");
		category1.setAuctions(null);
		
		Category category2 = new Category();
		category2.setCategoryId(2);
		category2.setName("Headsets");
		category2.setAuctions(null);
		
		List<Category> categories = new ArrayList<Category>();
		categories.add(category1);
		categories.add(category2);
		
		auction.setCategories(categories);
		
		
		Location location = new Location();
		location.setName("Athens");
		auction.setLocation(location);
		
		XmlAuctionWrapper wrapper = new XmlAuctionWrapper();
		List<Auction> auctions = new ArrayList<Auction>();
		auctions.add(auction);
		wrapper.setAuctions(auctions);
		
		System.out.println(auction.getCountry());
		
		return wrapper;

	}
	
	@RequestMapping(value = "auction/put", method = RequestMethod.PUT) 
	public @ResponseBody String newAuction(@RequestBody XmlAuctionWrapper wrapper, Model model) {
		
		xmlService.saveXmlAuction(wrapper.getAuctions());
			
		return "200 OK";

	} 

}


