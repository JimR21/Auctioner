package com.ted.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * The persistent class for the auctions database table.
 * 
 */
@Entity
@Table(name = "auctions")
@NamedQuery(name = "Auction.findAll", query = "SELECT a FROM Auction a")
@XmlType(propOrder = {"name", "categories", "currently", "buyPrice", "firstBid", "numberOfBids", 
		"auctionBiddings", "location", "country", "started", "ends", "xmlSeller", "description"})
@XmlRootElement(name = "item")
public class Auction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int auctionid;

	@Column(name = "buy_price", length = 45)
	private String buyPrice;

	@Column(nullable = false, length = 45)
	private String country;

	@Column(nullable = false, length = 45)
	private String currently;

	@Column(nullable = false, length = 45)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date ends;

	@Column(name = "first_bid", nullable = false, length = 45)
	private String firstBid;

	@Column(nullable = false, length = 45)
	private String name;

	@Column(name = "number_of_bids", nullable = false)
	private int numberOfBids;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date started;

	// bi-directional many-to-one association to AuctionBidding
	@OneToMany(mappedBy = "auction")
	private List<AuctionBidding> auctionBiddings;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "seller_userid", nullable = false)
	private User user;

	// bi-directional many-to-many association to Category
	@ManyToMany(mappedBy = "auctions")
	private List<Category> categories;

	// bi-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name = "location_id", nullable = false)
	private Location location;
	
	@Transient
	private XmlSeller xmlSeller;

	public Auction() {
	}

	public AuctionBidding addAuctionBidding(AuctionBidding auctionBidding) {
		getAuctionBiddings().add(auctionBidding);
		auctionBidding.setAuction(this);

		return auctionBidding;
	}

	@XmlElementWrapper(name = "bids")
	@XmlElement(name = "Bid")
	public List<AuctionBidding> getAuctionBiddings() {
		return this.auctionBiddings;
	}

	@XmlAttribute(name = "ItemID")
	public int getAuctionid() {
		return this.auctionid;
	}

	@XmlElement(name = "Buy_Price")
	public String getBuyPrice() {
		return this.buyPrice;
	}

	@XmlElement(name = "Category")
	public List<Category> getCategories() {
		return this.categories;
	}

	@XmlElement(name = "Country")
	public String getCountry() {
		return this.country;
	}

	@XmlElement(name = "Currently")
	public String getCurrently() {
		return this.currently;
	}

	@XmlElement(name = "Description")
	public String getDescription() {
		return this.description;
	}

	@XmlElement(name = "Ends")
	public Date getEnds() {
		return this.ends;
	}

	@XmlElement(name = "First_Bid")
	public String getFirstBid() {
		return this.firstBid;
	}

	@XmlElement(name = "Location")
	public Location getLocation() {
		return this.location;
	}

	@XmlElement(name = "Name")
	public String getName() {
		return this.name;
	}

	@XmlElement(name = "Number_of_Bids")
	public int getNumberOfBids() {
		return this.numberOfBids;
	}

	@XmlElement(name = "Started")
	public Date getStarted() {
		return this.started;
	}

	@XmlTransient
	public User getUser() {
		return this.user;
	}

	@XmlElement(name = "Seller")
	public XmlSeller getXmlSeller() {
		return xmlSeller;
	}

	public AuctionBidding removeAuctionBidding(AuctionBidding auctionBidding) {
		getAuctionBiddings().remove(auctionBidding);
		auctionBidding.setAuction(null);

		return auctionBidding;
	}

	public void setAuctionBiddings(List<AuctionBidding> auctionBiddings) {
		this.auctionBiddings = auctionBiddings;
	}

	public void setAuctionid(int auctionid) {
		this.auctionid = auctionid;
	}

	public void setBuyPrice(String buyPrice) {
		this.buyPrice = buyPrice;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCurrently(String currently) {
		this.currently = currently;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEnds(Date ends) {
		this.ends = ends;
	}

	public void setFirstBid(String firstBid) {
		this.firstBid = firstBid;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumberOfBids(int numberOfBids) {
		this.numberOfBids = numberOfBids;
	}

	public void setStarted(Date started) {
		this.started = started;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setXmlSeller(XmlSeller xmlSeller) {
		this.xmlSeller = xmlSeller;
	}

}