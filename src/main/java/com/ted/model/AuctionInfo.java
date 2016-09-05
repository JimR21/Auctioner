package com.ted.model;

public class AuctionInfo {
	
	Integer numofBids;
	
	boolean bought;
	
	String latestBid;
	
	String buyPrice;
	
	Long ends; 

	public String getBuyPrice() {
		return buyPrice;
	}

	public Long getEnds() {
		return ends;
	}

	public String getLatestBid() {
		return latestBid;
	}

	public Integer getNumofBids() {
		return numofBids;
	}

	public boolean isBought() {
		return bought;
	}

	public void setBought(boolean bought) {
		this.bought = bought;
	}

	public void setBuyPrice(String buyPrice) {
		this.buyPrice = buyPrice;
	}

	public void setEnds(Long ends) {
		this.ends = ends;
	}

	public void setLatestBid(String latestBid) {
		this.latestBid = latestBid;
	}

	public void setNumofBids(Integer numofBids) {
		this.numofBids = numofBids;
	}
	
	

}
