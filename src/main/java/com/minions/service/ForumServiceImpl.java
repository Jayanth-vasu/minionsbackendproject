package com.minions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minions.dao.ForumDAO;
import com.minions.model.Forum;

@Service
@Transactional
public class ForumServiceImpl implements ForumService {

	
	@Autowired
	ForumDAO forumDAO;
	
	@Override
	public Forum findById(int forum_id) {
		
		return forumDAO.findById(forum_id);
	}
	
	@Override
	public Forum findByName(String forum_name) {
		
		return forumDAO.findByName(forum_name);
	}

	@Override
	public void saveForum(Forum forum) {
	forumDAO.saveForum(forum);
	}

	@Override
	public void updateForum(Forum forum) {
		forumDAO.updateForum(forum);

	}

	@Override
	public void deleteForumById(int forum_id) {
		forumDAO.deleteForumById(forum_id);

	}

	@Override
	public List<Forum> findAllForums() {
		
		return forumDAO.findAllForums();
	}

	@Override
	public void deleteAllForums() {
		forumDAO.deleteAllForums();

	}

	

}
