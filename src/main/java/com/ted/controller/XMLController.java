package com.ted.controller;


import java.io.File;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ted.model.Auction;
import com.ted.model.XmlAuctionWrapper;
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

	
	
	@RequestMapping(value = "auction/put", method = RequestMethod.POST) 
	public @ResponseBody String putAuction(@RequestBody XmlAuctionWrapper wrapper, Model model) {
		
		try {
			xmlService.saveXmlAuction(wrapper.getAuctions());
		} catch (Exception ex) {
			System.out.println(ex);
			return "Error while passing data in database.";
		}
			
		return "200 OK";
	} 
	
	@RequestMapping(value = "auction/upload", method = RequestMethod.POST) 
	public @ResponseBody String uploadAuction(@RequestParam("input1") MultipartFile multipart, Model model) {
		
		try {
			JAXBContext context = JAXBContext.newInstance(XmlAuctionWrapper.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			File convFile = new File( multipart.getOriginalFilename());
	        multipart.transferTo(convFile);
				
			XmlAuctionWrapper wrapper = (XmlAuctionWrapper)unmarshaller.unmarshal(convFile);
			
			xmlService.saveXmlAuction(wrapper.getAuctions());
			
			int i = 0;
			for(Auction auction : wrapper.getAuctions()) {
				System.out.println(convFile.getName() + ": Auction" + i + ": " + auction.getName());
				i++;
			}
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
			
		return "{}";
	} 
	
	@RequestMapping(value = "xmlAuctions", method = RequestMethod.GET)
	public @ResponseBody String saveAuctions() {
		
		xmlService.xmlUnmarshalling();
		
		return "200 OK";
	}
	
	@RequestMapping(value = "auctions/{id}", method = RequestMethod.GET)
	public @ResponseBody Auction getAuction(@PathVariable Integer id) {
		
		Auction auction = auctionService.getAuctionById(id);
		
		Hibernate.initialize(auction);
		
		return auction;
		
	}

}


