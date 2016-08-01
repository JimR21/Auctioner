package com.ted.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Customer {
	String name;
	int age;
	int id;

	public int getAge() {
		return age;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@XmlTransient
	public void setAge(int age) {
		this.age = age;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
}