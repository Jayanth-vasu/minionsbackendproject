package com.minions.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minions.model.UserDetails;



@Repository
@Transactional
public class UserDAOImpl implements UserDAO{

	
	@Autowired
	SessionFactory session;
	
	@Override
	public UserDetails findById(int user_id) {
		return (UserDetails) session.getCurrentSession().get(UserDetails.class, user_id);
	}

	@Override
	public UserDetails findByName(String user_name) {
		
		return (UserDetails) session.getCurrentSession().get(UserDetails.class, user_name);
	}

	@Override
	public void saveUser(UserDetails user) {
		session.getCurrentSession().save(user);
		
	}

	@Override
	public void updateUser(UserDetails user) {
		session.getCurrentSession().update(user);
		
	}

	@Override
	public void deleteUserById(int user_id) {
		session.getCurrentSession().delete(findById(user_id));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetails> findAllUsers() {
		
		return (List<UserDetails>) session.getCurrentSession().createQuery("from UserDetails").list();
	}

	@Override
	public void deleteAllUsers() {
		session.getCurrentSession().delete(findAllUsers());
		
	}

	/*@Override
	public boolean isUserExist(UserDetails user) {
		
		return false;
	}*/

}
