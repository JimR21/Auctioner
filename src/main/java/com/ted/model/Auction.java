package com.ted.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the auctions database table.
 * 
 */
@Entity
@Table(name="auctions")
@NamedQuery(name="Auction.findAll", query="SELECT a FROM Auction a")
public class Auction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int auctionid;

	@Column(nullable=false, length=45)
	private String name;

	@Column(nullable=false)
	private int price;

	@Column(nullable=false, length=45)
	private String summary;

	//bi-directional many-to-one association to AuctionBidding
	@OneToMany(mappedBy="auction")
	private List<AuctionBidding> auctionBiddings;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="seller_userid", nullable=false)
	private User user;

	public Auction() {
	}

	public int getAuctionid() {
		return this.auctionid;
	}

	public void setAuctionid(int auctionid) {
		this.auctionid = auctionid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<AuctionBidding> getAuctionBiddings() {
		return this.auctionBiddings;
	}

	public void setAuctionBiddings(List<AuctionBidding> auctionBiddings) {
		this.auctionBiddings = auctionBiddings;
	}

	public AuctionBidding addAuctionBidding(AuctionBidding auctionBidding) {
		getAuctionBiddings().add(auctionBidding);
		auctionBidding.setAuction(this);

		return auctionBidding;
	}

	public AuctionBidding removeAuctionBidding(AuctionBidding auctionBidding) {
		getAuctionBiddings().remove(auctionBidding);
		auctionBidding.setAuction(null);

		return auctionBidding;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}