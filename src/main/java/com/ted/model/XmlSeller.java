package com.ted.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "seller")
public class XmlSeller {
	
	private String username;
	
	private String rating;

	@XmlAttribute(name = "Rating")
	public String getRating() {
		return rating;
	}

	@XmlAttribute(name = "UserID")
	public String getUsername() {
		return username;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
