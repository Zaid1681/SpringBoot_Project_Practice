package com.zaid.example.Customer.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "profiles")
public class Profile {

	@Id
	private int id;
	private String profileName;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	

	public Profile(int id, String profileName) {
		super();
		this.id = id;
		this.profileName = profileName;
	}

	public Profile() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

}
