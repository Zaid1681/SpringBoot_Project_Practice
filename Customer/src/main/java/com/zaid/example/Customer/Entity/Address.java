package com.zaid.example.Customer.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	private int addId;
	private String city;
	private String country;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Address(int addId, String city, String country) {
		super();
		this.addId = addId;
		this.city = city;
		this.country = country;
	}

	public int getAddId() {
		return addId;
	}

	public Address() {
		super();
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
