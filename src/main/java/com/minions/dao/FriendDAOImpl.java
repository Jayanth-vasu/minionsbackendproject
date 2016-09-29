package com.minions.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minions.model.Friend;

@Repository
@Transactional
public class FriendDAOImpl implements FriendDAO {

	@Autowired
	SessionFactory session;
	
	
	@Override
	public Friend findById(int friend_id) {
		
		return (Friend)session.getCurrentSession().get(Friend.class, friend_id);
	}

	@Override
	public Friend findByName(String friend_name) {
		
		return (Friend)session.getCurrentSession().get(Friend.class, friend_name);
	}

	@Override
	public void saveFriend(Friend friend) {
		session.getCurrentSession().save(friend);

	}

	@Override
	public void updateFriend(Friend friend) {
		session.getCurrentSession().update(friend);

	}

	@Override
	public void deleteFriendById(int friend_id) {
		session.getCurrentSession().delete(findById(friend_id));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Friend> findAllFriends() {
		
		return (List<Friend>) session.getCurrentSession().createQuery("from Friend").list();
	}

}
