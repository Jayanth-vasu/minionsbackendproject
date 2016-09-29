package com.minions.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserDetails {

	@Id
	private int user_id;
	
	private String user_name;
	
		
	private String email;
	
	private String password;
	
	
	private String role_name;
	
	@OneToMany(mappedBy="userDetails",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<UserDetails> userDetails;
	
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserDetails> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(Set<UserDetails> userDetails) {
		this.userDetails = userDetails;
	}

	
	
	
}
