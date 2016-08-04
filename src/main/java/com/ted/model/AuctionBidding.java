package com.ted.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * The persistent class for the auction_bidding database table.
 * 
 */
@Entity
@Table(name = "auction_bidding")
@NamedQuery(name = "AuctionBidding.findAll", query = "SELECT a FROM AuctionBidding a")
@XmlType(propOrder = {"user", "xmlTime", "amount"})
@XmlRootElement(name = "bid")
public class AuctionBidding implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AuctionBiddingPK id;

	@Column(nullable = false)
	private String amount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date time;

	// bi-directional many-to-one association to Auction
	@ManyToOne
	@JoinColumn(name = "auctionid", nullable = false, insertable = false, updatable = false)
	private Auction auction;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "bidder_userid", nullable = false, insertable = false, updatable = false)
	private User user;
	
	@Transient
	private String xmlTime;

	public AuctionBidding() {
	}

	@XmlElement(name = "Amount")
	public String getAmount() {
		return this.amount;
	}

	@XmlTransient
	public Auction getAuction() {
		return this.auction;
	}

	@XmlTransient
	public AuctionBiddingPK getId() {
		return this.id;
	}

	@XmlTransient
	public Date getTime() {
		return time;
	}

	@XmlElement(name = "Bidder")
	public User getUser() {
		return this.user;
	}

	@XmlElement(name = "Time")
	public String getXmlTime() {
		return xmlTime;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	public void setId(AuctionBiddingPK id) {
		this.id = id;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setXmlTime(String xmlTime) {
		this.xmlTime = xmlTime;
	}

}