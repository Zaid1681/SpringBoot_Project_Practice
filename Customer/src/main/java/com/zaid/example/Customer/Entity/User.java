package com.zaid.example.Customer.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	private int id;
	private String userName;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Profile profile;

	@OneToMany(mappedBy = "user" , cascade=CascadeType.ALL) // it mapped the user obj defined in address i.e address owns the ownership of creating foreign key 
	private List<Address> address ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}

}
