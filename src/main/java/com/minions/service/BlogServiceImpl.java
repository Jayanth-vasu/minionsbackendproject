package com.minions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minions.dao.BlogDAO;
import com.minions.model.Blog;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

	@Autowired
	BlogDAO blogDAO;
	
	@Override
	public Blog findById(int blog_id) {
		
		return blogDAO.findById(blog_id);
	}

	@Override
	public Blog findByName(String blog_name) {
		
		return blogDAO.findByName(blog_name);
	}

	@Override
	public void saveBlog(Blog blog) {
		blogDAO.saveBlog(blog);

	}

	@Override
	public void updateBlog(Blog blog) {
		blogDAO.updateBlog(blog);

	}

	@Override
	public void deleteBlogById(int blog_id) {
		blogDAO.deleteBlogById(blog_id);

	}

	@Override
	public List<Blog> findAllBlogs() {
		
		return blogDAO.findAllBlogs();
	}

	@Override
	public void deleteAllBlogs() {
		blogDAO.deleteAllBlogs();

	}
	@Override
	public boolean checkBlog(String blog_name) {
		boolean checkblog=false;
		
		checkblog=blogDAO.checkBlog(blog_name);
		if(checkblog==true){
			checkblog=true;
		}
		
		return checkblog;
	}

}
