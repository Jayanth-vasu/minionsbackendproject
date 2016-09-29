package com.minions.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {

	@Id
	private int role_id;
	
	private String role;

	@OneToMany(mappedBy="role",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Role> user_role;
	
	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Role> getUser_role() {
		return user_role;
	}

	public void setUser_role(Set<Role> user_role) {
		this.user_role = user_role;
	}
	
	
}
