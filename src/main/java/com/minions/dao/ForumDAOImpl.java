package com.minions.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minions.model.Forum;

@Repository
@Transactional
public class ForumDAOImpl implements ForumDAO {

	@Autowired
	SessionFactory session; 
	
	@Override
	public Forum findById(int forum_id) {
		
		return (Forum) session.getCurrentSession().get(Forum.class, forum_id);
	}

	@Override
	public Forum findByName(String forum_name) {
		return (Forum) session.getCurrentSession().get(Forum.class, forum_name);
	}

	@Override
	public void saveForum(Forum forum) {
		session.getCurrentSession().save(forum);

	}

	@Override
	public void updateForum(Forum forum) {
		session.getCurrentSession().update(forum);

	}

	@Override
	public void deleteForumById(int forum_id) {
		session.getCurrentSession().delete(findById(forum_id));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Forum> findAllForums() {
		
		return (List<Forum>) session.getCurrentSession().createQuery("from Forum").list();
	}

	@Override
	public void deleteAllForums() {
		session.getCurrentSession().delete(findAllForums());

	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkForum(String forum_name) {
		
		boolean checkforum=false;
		Query q= session.getCurrentSession().createQuery("from Forum where forum_name='"+forum_name+"'");
		List<Forum> forum= q.list();
		int size=forum.size();
		if(size==1)
		{
			checkforum=true;
		}
		return checkforum;
	}

}
