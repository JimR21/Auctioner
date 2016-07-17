package com.ted.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the auction_bidding database table.
 * 
 */
@Embeddable
public class AuctionBiddingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private int auctionid;

	@Column(name="bidder_userid", insertable=false, updatable=false, unique=true, nullable=false)
	private int bidderUserid;

	public AuctionBiddingPK() {
	}
	public int getAuctionid() {
		return this.auctionid;
	}
	public void setAuctionid(int auctionid) {
		this.auctionid = auctionid;
	}
	public int getBidderUserid() {
		return this.bidderUserid;
	}
	public void setBidderUserid(int bidderUserid) {
		this.bidderUserid = bidderUserid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AuctionBiddingPK)) {
			return false;
		}
		AuctionBiddingPK castOther = (AuctionBiddingPK)other;
		return 
			(this.auctionid == castOther.auctionid)
			&& (this.bidderUserid == castOther.bidderUserid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.auctionid;
		hash = hash * prime + this.bidderUserid;
		
		return hash;
	}
}