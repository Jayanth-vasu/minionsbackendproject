package com.minions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minions.dao.FriendDAO;
import com.minions.model.Friend;

@Service
@Transactional
public class FriendServiceImpl implements FriendService {

	@Autowired
	FriendDAO friendDAO;
	
	@Override
	public Friend findById(int friend_id) {
		
		return friendDAO.findById(friend_id);
	}

	@Override
	public Friend findByName(String friend_name) {
		
		return friendDAO.findByName(friend_name);
	}

	@Override
	public void saveFriend(Friend friend) {
		friendDAO.saveFriend(friend);

	}

	@Override
	public void updateFriend(Friend friend) {
		friendDAO.updateFriend(friend);

	}

	@Override
	public void deleteFriendById(int friend_id) {
		friendDAO.deleteFriendById(friend_id);

	}

	@Override
	public List<Friend> findAllFriends() {
		
		return friendDAO.findAllFriends();
	}

	

}
