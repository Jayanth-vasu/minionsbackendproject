package com.minions.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {

	
	@Id
	private int user_role;
	
	@ManyToOne
	@JoinColumn(name="user_id",updatable=false,insertable=false)
	private UserDetails userDetails;
	
	@ManyToOne
	@JoinColumn(name="role_id",updatable=false,insertable=false)
	private Role role;

	public int getUser_role() {
		return user_role;
	}

	public void setUser_role(int user_role) {
		this.user_role = user_role;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	
	
	
	
}
