package com.minions.dao;

import java.util.List;

import com.minions.model.Blog;

public interface BlogDAO {
    
	public Blog findById(int blog_id);
    
    public Blog findByName(String blog_name);
     
    public void saveBlog(Blog blog);
     
    public void updateBlog(Blog blog);
     
    public void deleteBlogById(int blog_id);
 
    public List<Blog> findAllBlogs(); 
     
    public void deleteAllBlogs();
	
}
