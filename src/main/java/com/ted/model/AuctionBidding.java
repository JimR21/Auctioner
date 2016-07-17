package com.ted.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the auction_bidding database table.
 * 
 */
@Entity
@Table(name="auction_bidding")
@NamedQuery(name="AuctionBidding.findAll", query="SELECT a FROM AuctionBidding a")
public class AuctionBidding implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AuctionBiddingPK id;

	@Column(nullable=false)
	private int amount;

	//bi-directional many-to-one association to Auction
	@ManyToOne
	@JoinColumn(name="auctionid", nullable=false, insertable=false, updatable=false)
	private Auction auction;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="bidder_userid", nullable=false, insertable=false, updatable=false)
	private User user;

	public AuctionBidding() {
	}

	public AuctionBiddingPK getId() {
		return this.id;
	}

	public void setId(AuctionBiddingPK id) {
		this.id = id;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Auction getAuction() {
		return this.auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}