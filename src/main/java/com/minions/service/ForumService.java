package com.minions.service;

import java.util.List;

import com.minions.model.Forum;

public interface ForumService {

		public Forum findById(int forum_id);
	 	
	 	public Forum findByName(String forum_name);
     
	    public void saveForum(Forum forum);
	     
	    public void updateForum(Forum forum);
	     
	    public void deleteForumById(int forum_id);
	 
	    public List<Forum> findAllForums(); 
	     
	    public void deleteAllForums();
	    
	    public boolean checkForum(String forum_name);
}
