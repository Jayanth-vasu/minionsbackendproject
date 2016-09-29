package com.minions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minions.dao.UserDAO;
import com.minions.model.UserDetails;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Override
	public UserDetails findById(int user_id) {
		
		return userDAO.findById(user_id);
	}

	@Override
	public UserDetails findByName(String user_name) {
		
		return userDAO.findByName(user_name);
	}

	@Override
	public void saveUser(UserDetails user) {
		userDAO.saveUser(user);
		
	}

	@Override
	public void updateUser(UserDetails user) {
		userDAO.updateUser(user);
		
	}

	@Override
	public void deleteUserById(int user_id) {
		userDAO.deleteUserById(user_id);
		
	}

	@Override
	public List<UserDetails> findAllUsers() {
		
		return userDAO.findAllUsers();
	}

	@Override
	public void deleteAllUsers() {
		userDAO.deleteAllUsers();
		
	}

	/*@Override
	public boolean isUserExist(UserDetails user) {
		
		return false;
	}*/

}
