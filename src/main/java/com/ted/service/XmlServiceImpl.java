package com.ted.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ted.model.Auction;
import com.ted.model.AuctionBidding;
import com.ted.model.AuctionBiddingPK;
import com.ted.model.Authority;
import com.ted.model.AuthorityPK;
import com.ted.model.Category;
import com.ted.model.Location;
import com.ted.model.User;
import com.ted.model.XmlAuctionWrapper;
import com.ted.model.XmlSeller;
import com.ted.repository.AuctionBiddingRepository;
import com.ted.repository.AuctionRepository;
import com.ted.repository.AuthorityRepository;
import com.ted.repository.CategoryRepository;
import com.ted.repository.LocationRepository;
import com.ted.repository.UserRepository;

@Service("xmlService")
public class XmlServiceImpl implements XmlService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	AuctionBiddingRepository auctionBiddingRepository;
	
	@Autowired
	AuctionService auctionService;
	
	@Autowired
	AuthorityRepository authorityRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	AuctionRepository auctionRepository;
	
	@Transactional
	public void saveXmlAuction(List<Auction> auctions) {
		
		for(Auction auction : auctions) {
			
			/* Seller */
			auction.setUser(saveSellerUser(auction.getXmlSeller()));
			
			/* Location */
			auction.setLocation(saveLocation(auction.getLocation()));
			
			/*Categories */
			auction.setCategories(saveCategories(auction.getCategories()));
			
			/* Date Format */
			auction.setEnds(formatString(auction.getXmlEnds()));
			auction.setStarted(formatString(auction.getXmlStarted()));
			
			/* Format Auction Money */
			auction.setBuyPrice(formatMoney(auction.getBuyPriceString()));
			auction.setCurrently(formatMoney(auction.getCurrentlyString()));
			auction.setFirstBid(formatMoney(auction.getFirstBidString()));
			
			/* IsBought */
			auction.setBought(true);
			
			/*Persist Auction */
			Auction dbauction = auctionRepository.saveAndFlush(auction);
			
			/* Auction Biddings */
			List<AuctionBidding> xmlbiddings = auction.getAuctionBiddings();
			
			for(AuctionBidding bid : xmlbiddings) {
				
				bid.setUser(saveBidderUser(bid.getUser()));	// save and return bidder
				
				bid.setAuction(dbauction);	//setAuction
				
				bid.setTime(formatString(bid.getXmlTime()));
				
				AuctionBiddingPK auctionBiddingPK = new AuctionBiddingPK();
				auctionBiddingPK.setAuctionid(dbauction.getAuctionid());
				auctionBiddingPK.setBidderUserid(bid.getUser().getUserid());
				
				bid.setId(auctionBiddingPK);
				
				/* Format Amount Money */
				bid.setAmount(formatMoney(bid.getAmountString()));
				
				auctionBiddingRepository.save(bid);
				
			}
		}
	}

	@Transactional
	public User saveBidderUser(User user) {
		
		/* Random data */
		String[] firstnames = {"John", "George", "Eve", "Anna", "Alan", "Frank", "Jessie"};
		String[] lastnames = {"Smith", "Jones", "Gerard", "Murphy", "Jackson"};
		String[] phones = {"6975552224", "6995554446", "6987775552", "6985556661"};
		String[] addresses = {"Portland 23", "Cleanwater 55", "Mainland 4", "Cleverlane 78"};
		String[] postalCodes = {"45868", "11541", "88746", "44866", "48684", "88742"};
		String[] cities = {"Atalanta", "Chicago", "New York"};
		
		/* Check if user exists */
		User dbuser = userRepository.findByUsername(user.getUsername());
		if(dbuser != null)
			return dbuser;
		
		user.setFirstName(getRandom(firstnames));
		user.setLastName(getRandom(lastnames));
		user.setPhone(getRandom(phones));
		user.setAddress(getRandom(addresses));
		user.setPostalCode(getRandom(postalCodes));	
		
		/* Password "secret" */
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		String hashedPass = passEncoder.encode("secret");
		user.setPassword(hashedPass);
		
		/* Check location and country */
		if(user.getCountry() == null) {
			user.setCountry("USA");
		}
		if(user.getCity() == null) {
			user.setCity(getRandom(cities));
		}
		
		/* Email & afm */
		user.setEmail(user.getUsername() + "@gmail.com");
		user.setAfm("111122223333");
		
		/* Enabled & Approved */
		user.setEnabled((byte)1);
		user.setApproved((byte)0);
		
		/* Persist User */
		userRepository.save(user);
		
		/* Authority Role */
		AuthorityPK authorityPK = new AuthorityPK();
		authorityPK.setUserid(user.getUserid());
		authorityPK.setRole("ROLE_BIDDER");
		
		Authority authority = new Authority();
		authority.setId(authorityPK);
		authority.setUser(user);
		
		/* Persist authority */
		authorityRepository.saveAndFlush(authority);
		
		return userRepository.findByUsername(user.getUsername());
	}
	
	@Transactional
	public User saveSellerUser(XmlSeller seller) {
		
		/* Random data */
		String[] firstnames = {"John", "George", "Eve", "Anna", "Alan", "Frank", "Jessie"};
		String[] lastnames = {"Smith", "Jones", "Gerard", "Murphy", "Jackson"};
		String[] phones = {"6975552224", "6995554446", "6987775552", "6985556661"};
		String[] addresses = {"Portland 23", "Cleanwater 55", "Mainland 4", "Cleverlane 78"};
		String[] postalCodes = {"45868", "11541", "88746", "44866", "48684", "88742"};
		String[] cities = {"Atalanta", "Chicago", "New York"};
		
		/* Check if user exists */
		User dbuser = userRepository.findByUsername(seller.getUsername());
		if(dbuser != null) {
		
			/* Add ROLE_SELLER */
			if(!userService.hasAuthority(dbuser.getUsername(), "ROLE_SELLER")) {
				
				AuthorityPK authorityPK = new AuthorityPK();
				authorityPK.setUserid(dbuser.getUserid());
				authorityPK.setRole("ROLE_SELLER");
				
				Authority authority = new Authority();
				authority.setId(authorityPK);
				authority.setUser(dbuser);
				
				/* Persist authority */
				authorityRepository.save(authority);
			}
			
			return dbuser;
		}
		
		User user = new User();
		user.setUsername(seller.getUsername());
		user.setSellerRating(seller.getRating());
		
		user.setFirstName(getRandom(firstnames));
		user.setLastName(getRandom(lastnames));
		user.setPhone(getRandom(phones));
		user.setAddress(getRandom(addresses));
		user.setPostalCode(getRandom(postalCodes));	
		
		/* Password "secret" */
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		String hashedPass = passEncoder.encode("secret");
		user.setPassword(hashedPass);
		
		/* Check location and country */
		if(user.getCountry() == null) {
			user.setCountry("USA");
		}
		if(user.getCity() == null) {
			user.setCity(getRandom(cities));
		}
		
		/* Email & afm */
		user.setEmail(user.getUsername() + "@gmail.com");
		user.setAfm("111122223333");
		
		/* Enabled & Approved */
		user.setEnabled((byte)1);
		user.setApproved((byte)0);
		
		/* Persist User */
		userRepository.save(user);
		
		/* Authorities Role */
		AuthorityPK authorityPK = new AuthorityPK();
		authorityPK.setUserid(user.getUserid());
		authorityPK.setRole("ROLE_BIDDER");
		
		Authority authority = new Authority();
		authority.setId(authorityPK);
		authority.setUser(user);
		
		AuthorityPK authorityPK2 = new AuthorityPK();
		authorityPK2.setUserid(user.getUserid());
		authorityPK2.setRole("ROLE_SELLER");
		
		Authority authority2 = new Authority();
		authority2.setId(authorityPK2);
		authority2.setUser(user);
		
		/* Persist authorities */
		authorityRepository.save(authority);
		authorityRepository.save(authority2);
		
		return userRepository.findByUsername(user.getUsername());
	}
	
	
	public static String getRandom(String[] array) {
	    int rnd = new Random().nextInt(array.length);
	    return array[rnd];
	}

	@Transactional
	public Location saveLocation(Location location) {
		
		Location loc = locationRepository.findByName(location.getName());
		
		if(loc == null)
			locationRepository.save(location);
		else if(location.getLatitude() != null || location.getLongitude() != null) {
			loc.setLatitude(location.getLatitude());
			loc.setLongitude(location.getLongitude());
			locationRepository.save(loc);
		}
		return locationRepository.findByName(location.getName());
	}
	
	@Transactional
	public List<Category> saveCategories(List<Category> categories) {
		
		List<Category> returnList = new ArrayList<Category>();
		
		Category cat;
		Category parent = null;
		
		for(Category category : categories) {
			category.setCategory(parent);
			cat = categoryRepository.findByName(category.getName());
			if(cat == null) {
				categoryRepository.save(category);
				parent = category;
			}
			else {
				if(category.getCategory() != null) {
					cat.setCategory(category.getCategory());
					categoryRepository.save(cat);
				}
				parent = cat;
			}
			returnList.add(categoryRepository.findByName(category.getName()));
		}
		
		return returnList;
		
	}

	public Date formatString(String dateString) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("MMM-dd-yy HH:mm:ss", Locale.ENGLISH);

		try {
			
			Date date = formatter.parse(dateString);
			return date;
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
			
	}
	
	BigDecimal formatMoney(String moneyString) {
		
		if(moneyString != null) {
			moneyString = moneyString.replaceAll("\\$", "");
			moneyString = moneyString.replaceAll(",", "");
			System.out.println("Money: " + moneyString);
			return new BigDecimal(moneyString);
		}
		
		return null;
	}

	public void xmlUnmarshalling() {
		
		try {
			JAXBContext context = JAXBContext.newInstance(XmlAuctionWrapper.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			for(int j = 0; j < 2; j++) {
				
				XmlAuctionWrapper wrapper = (XmlAuctionWrapper)unmarshaller.unmarshal(new FileReader("D:\\ebay-data\\items-" + j + ".xml"));
				
				saveXmlAuction(wrapper.getAuctions());
				
				int i = 0;
				for(Auction auction : wrapper.getAuctions()) {
					System.out.println("File" + j + ": Auction" + i + ": " + auction.getName());
					i++;
				}
			}
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
	
	public File xmlFileProduce(List<Integer> auctionids) {

		XmlAuctionWrapper wrapper = new XmlAuctionWrapper();
		List<Auction> auctions = auctionRepository.findByAuctionidIn(auctionids);
		wrapper.setAuctions(auctions);
		
		File file = new File("auctions.xml");
		
		String xmlString = marshal(wrapper);
		
		try {
			PrintWriter out = new PrintWriter(file);
			out.print(xmlString);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return file;

	}
	
	public String marshal(XmlAuctionWrapper wrapper) {
		try {
			JAXBContext context = JAXBContext.newInstance(XmlAuctionWrapper.class);
			Marshaller marshaller = context.createMarshaller();
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(wrapper, stringWriter);
			return stringWriter.toString();
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

}
