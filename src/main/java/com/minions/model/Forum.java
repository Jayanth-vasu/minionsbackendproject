package com.minions.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Forum implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1139814387700753786L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int forum_id;
	private String forum_name;
	private Date posted_time;
	private Date posted_date;
	private int comment_id;
	private boolean forum_approved;
	private int rating_id;
	public int getForum_id() {
		return forum_id;
	}
	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}
	public String getForum_name() {
		return forum_name;
	}
	public void setForum_name(String forum_name) {
		this.forum_name = forum_name;
	}
	public Date getPosted_time() {
		return posted_time;
	}
	public void setPosted_time(Date posted_time) {
		this.posted_time = posted_time;
	}
	public Date getPosted_date() {
		return posted_date;
	}
	public void setPosted_date(Date posted_date) {
		this.posted_date = posted_date;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public boolean isForum_approved() {
		return forum_approved;
	}
	public void setForum_approved(boolean forum_approved) {
		this.forum_approved = forum_approved;
	}
	public int getRating_id() {
		return rating_id;
	}
	public void setRating_id(int rating_id) {
		this.rating_id = rating_id;
	}
	
	
}
