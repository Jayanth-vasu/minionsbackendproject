package com.minions.dao;

import java.util.List;

import com.minions.model.UserDetails;

public interface UserDAO {

	public UserDetails findById(int user_id);

	public UserDetails findByName(String user_name);

	public void saveUser(UserDetails user);

	public void updateUser(UserDetails user);

	public void deleteUserById(int user_id);

	public List<UserDetails> findAllUsers();

	public void deleteAllUsers();

	/*public boolean isUserExist(UserDetails user);*/
}
