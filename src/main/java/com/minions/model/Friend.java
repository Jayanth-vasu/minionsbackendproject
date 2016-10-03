package com.minions.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Friend implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3435374295875883379L;

	@Id
	private int friend_id;
	
	@ManyToOne
	@JoinColumn(name="user_id",updatable=false,insertable=false)
	private UserDetails userDetails;
	
	private boolean request;

	
	
	public int getFriend_id() {
		return friend_id;
	}

	public void setFriend_id(int friend_id) {
		this.friend_id = friend_id;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public boolean isRequest() {
		return request;
	}

	public void setRequest(boolean request) {
		this.request = request;
	}
	
	
}
