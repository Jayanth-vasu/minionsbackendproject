package com.minions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.minions.model.Blog;
import com.minions.service.BlogService;

@RestController
public class BlogController {

	@Autowired
	BlogService blogService;

	// -------------------Retrieve All Users--------------------------------------------------------
	@RequestMapping(value = "/blog/", method = RequestMethod.GET)
	public ResponseEntity<List<Blog>> listAllUsers() {
		List<Blog> blogs = blogService.findAllBlogs();
		if (blogs.isEmpty()) {
			return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
	}

	// -------------------Retrieve Single Blog--------------------------------------------------------

	@RequestMapping(value = "/blog/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Blog> getUser(@PathVariable("id") int id) {
		System.out.println("Fetching Blog with id " + id);
		Blog blog = blogService.findById(id);
		if (blog == null) {
			System.out.println("Blog with id " + id + " not found");
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}

	// -------------------Create a  Blog--------------------------------------------------------

	@RequestMapping(value = "/blog/", method = RequestMethod.POST)
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Blog " + blog.getBlog_name());

		if (blogService.checkBlog(blog.getBlog_name())) {
			System.out.println("A Blog with name " + blog.getBlog_name() + " already exist");
			return new ResponseEntity<Blog>(HttpStatus.CONFLICT);
		}

		blogService.saveBlog(blog);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/blog/{id}").buildAndExpand(blog.getBlog_id()).toUri());
		return new ResponseEntity<Blog>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Blog--------------------------------------------------------

	@RequestMapping(value = "/blog/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Blog> updateUser(@PathVariable("id") int id, @RequestBody Blog blog) {
		System.out.println("Updating Blog " + id);

		Blog currentBlog = blogService.findById(id);

		if (currentBlog == null) {
			System.out.println("Blog with id " + id + " not found");
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}

		currentBlog.setBlog_name(blog.getBlog_name());
		

		blogService.updateBlog(currentBlog);
		return new ResponseEntity<Blog>(currentBlog, HttpStatus.OK);
	}

	// ------------------- Delete a User --------------------------------------------------------

	@RequestMapping(value = "/blog/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Blog> deleteBlog(@PathVariable("id") int id) {
		System.out.println("Fetching & Deleting Blog with id " + id);

		Blog blog = blogService.findById(id);
		if (blog == null) {
			System.out.println("Unable to delete. User with id " + id + " not found");
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}

		blogService.deleteBlogById(id);
		return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Users --------------------------------------------------------

	@RequestMapping(value = "/blog/", method = RequestMethod.DELETE)
	public ResponseEntity<Blog> deleteAllBlogs() {
		System.out.println("Deleting All Blogs");

		blogService.deleteAllBlogs();
		return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
	}

}
