package com.ted.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int userid;

	@Column(nullable=false, length=45)
	@NotEmpty(message = "{NotEmpty.user.address}")
	private String address;

	@Column(nullable=false, length=45)
	private String afm;

	@Column(nullable=false)
	private byte approved;

	@Column(nullable=false, length=45)
	@NotEmpty(message = "{NotEmpty.user.city}")
	private String city;

	@Column(nullable=false, length=55)
	@NotEmpty(message = "{NotEmpty.user.email}")
	private String email;

	@Column(nullable=false)
	private byte enabled;

	@Column(name="first_name", nullable=false, length=45)
	@NotEmpty(message = "{NotEmpty.user.first_name}")
	private String firstName;

	@Column(name="last_name", nullable=false, length=45)
	@NotEmpty(message = "{NotEmpty.user.last_name}")
	private String lastName;

	@Column(nullable=false, length=60)
	@NotEmpty(message = "{NotEmpty.user.password}")
	private String password;

	@Column(nullable=false, length=45)
	@NotEmpty(message = "{NotEmpty.user.phone}")
	private String phone;

	@Column(name="postal_code", nullable=false, length=45)
	@NotEmpty(message = "{NotEmpty.user.postalCode}")
	private String postalCode;

	@Column(nullable=false, length=45)
	@NotEmpty(message = "{NotEmpty.user.state}")
	private String state;

	@Column(nullable=false, length=45)
	@NotEmpty(message = "{NotEmpty.user.username}")
	private String username;
	
	//bi-directional many-to-one association to AuctionBidding
	@OneToMany(mappedBy="user")
	private List<AuctionBidding> auctionBiddings;

	//bi-directional many-to-one association to Auction
	@OneToMany(mappedBy="user")
	private List<Auction> auctions;

	//bi-directional many-to-one association to Authority
	@OneToMany(mappedBy="user")
	private List<Authority> authorities;

	public User() {
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAfm() {
		return this.afm;
	}

	public void setAfm(String afm) {
		this.afm = afm;
	}

	public byte getApproved() {
		return this.approved;
	}

	public void setApproved(byte approved) {
		this.approved = approved;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<AuctionBidding> getAuctionBiddings() {
		return this.auctionBiddings;
	}

	public void setAuctionBiddings(List<AuctionBidding> auctionBiddings) {
		this.auctionBiddings = auctionBiddings;
	}

	public AuctionBidding addAuctionBidding(AuctionBidding auctionBidding) {
		getAuctionBiddings().add(auctionBidding);
		auctionBidding.setUser(this);

		return auctionBidding;
	}

	public AuctionBidding removeAuctionBidding(AuctionBidding auctionBidding) {
		getAuctionBiddings().remove(auctionBidding);
		auctionBidding.setUser(null);

		return auctionBidding;
	}

	public List<Auction> getAuctions() {
		return this.auctions;
	}

	public void setAuctions(List<Auction> auctions) {
		this.auctions = auctions;
	}

	public Auction addAuction(Auction auction) {
		getAuctions().add(auction);
		auction.setUser(this);

		return auction;
	}

	public Auction removeAuction(Auction auction) {
		getAuctions().remove(auction);
		auction.setUser(null);

		return auction;
	}

	public List<Authority> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public Authority addAuthority(Authority authority) {
		getAuthorities().add(authority);
		authority.setUser(this);

		return authority;
	}

	public Authority removeAuthority(Authority authority) {
		getAuthorities().remove(authority);
		authority.setUser(null);

		return authority;
	}

}