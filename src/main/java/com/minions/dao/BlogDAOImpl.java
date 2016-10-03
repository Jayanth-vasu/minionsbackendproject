package com.minions.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minions.model.Blog;

@Repository
@Transactional
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	SessionFactory session;
	
	@Override
	public Blog findById(int blog_id) {
		return (Blog) session.getCurrentSession().get(Blog.class, blog_id);
	}

	@Override
	public Blog findByName(String blog_name) {
		return (Blog) session.getCurrentSession().get(Blog.class, blog_name);
	}

	@Override
	public void saveBlog(Blog blog) {
		session.getCurrentSession().save(blog);

	}

	@Override
	public void updateBlog(Blog blog) {
		session.getCurrentSession().update(blog);

	}

	@Override
	public void deleteBlogById(int blog_id) {
		session.getCurrentSession().delete(findById(blog_id));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> findAllBlogs() {
		return (List<Blog>) session.getCurrentSession().createQuery("from Blog").list();
	}

	@Override
	public void deleteAllBlogs() {
		session.getCurrentSession().delete(findAllBlogs());

	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkBlog(String blog_name) {
		boolean checkblog=false;
		Query q= session.getCurrentSession().createQuery("from Blog where blog_name='"+blog_name+"'");
		List<Blog> blog= q.list();
		int size=blog.size();
		if(size==1)
		{
			checkblog=true;
		}
		return checkblog;
	}

}
