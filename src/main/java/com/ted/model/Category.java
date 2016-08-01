package com.ted.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;

/**
 * The persistent class for the categories database table.
 * 
 */
@Entity
@Table(name = "categories")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
@XmlRootElement
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id", unique = true, nullable = false)
	private int categoryId;

	@Column(nullable = false, length = 45)
	private String name;

	@Column(name = "parent_id")
	private int parentId;

	// bi-directional many-to-many association to Auction
	@ManyToMany
	@JoinTable(name = "auciton_categories", joinColumns = {
			@JoinColumn(name = "category_id", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "auction_id", nullable = false) })
	private List<Auction> auctions;

	public Category() {
	}

	@XmlTransient
	public List<Auction> getAuctions() {
		return this.auctions;
	}

	@XmlTransient
	public int getCategoryId() {
		return this.categoryId;
	}

	@XmlValue
	public String getName() {
		return this.name;
	}

	@XmlTransient
	public int getParentId() {
		return this.parentId;
	}

	public void setAuctions(List<Auction> auctions) {
		this.auctions = auctions;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

}