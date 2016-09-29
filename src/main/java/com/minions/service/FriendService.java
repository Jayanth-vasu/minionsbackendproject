package com.minions.service;

import java.util.List;

import com.minions.model.Friend;

public interface FriendService {

	public Friend findById(int friend_id);
    
    public Friend findByName(String friend_name);
     
    public void saveFriend(Friend friend);
     
    public void updateFriend(Friend friend);
     
    public void deleteFriendById(int friend_id);
 
    public List<Friend> findAllFriends(); 

}
