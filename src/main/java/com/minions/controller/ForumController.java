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

import com.minions.model.Forum;
import com.minions.service.ForumService;

@RestController
public class ForumController {
	@Autowired
	ForumService forumService;

	// -------------------Retrieve All Forum--------------------------------------------------------
	@RequestMapping(value = "/forum/", method = RequestMethod.GET)
	public ResponseEntity<List<Forum>> listAllForum() {
		List<Forum> forums = forumService.findAllForums();
		if (forums.isEmpty()) {
			return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Forum>>(forums, HttpStatus.OK);
	}

	// -------------------Retrieve Single Forum--------------------------------------------------------

	@RequestMapping(value = "/forum/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Forum> getForum(@PathVariable("id") int id) {
		System.out.println("Fetching Blog with id " + id);
		Forum forum = forumService.findById(id);
		if (forum == null) {
			System.out.println("Blog with id " + id + " not found");
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Forum>(forum, HttpStatus.OK);
	}

	// -------------------Create a  Forum--------------------------------------------------------

	@RequestMapping(value = "/forum/", method = RequestMethod.POST)
	public ResponseEntity<Forum> createForum(@RequestBody Forum forum, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Forum " + forum.getForum_name());

		if (forumService.checkForum(forum.getForum_name())) {
			System.out.println("A Forum with name " + forum.getForum_name() + " already exist");
			return new ResponseEntity<Forum>(HttpStatus.CONFLICT);
		}

		forumService.saveForum(forum);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/forum/{id}").buildAndExpand(forum.getForum_id()).toUri());
		return new ResponseEntity<Forum>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Forum--------------------------------------------------------

	@RequestMapping(value = "/forum/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Forum> updateForum(@PathVariable("id") int id, @RequestBody Forum forum) {
		System.out.println("Updating forum " + id);

		Forum currentForum = forumService.findById(id);

		if (currentForum == null) {
			System.out.println("forum with id " + id + " not found");
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}

		currentForum.setForum_name(forum.getForum_name());
		

		forumService.updateForum(currentForum);
		return new ResponseEntity<Forum>(currentForum, HttpStatus.OK);
	}

	// ------------------- Delete a Forum --------------------------------------------------------

	@RequestMapping(value = "/forum/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Forum> deleteForum(@PathVariable("id") int id) {
		System.out.println("Fetching & Deleting Forum with id " + id);

		Forum forum =forumService.findById(id);
		if (forum == null) {
			System.out.println("Unable to delete. Forum with id " + id + " not found");
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}

		forumService.deleteForumById(id);
		return new ResponseEntity<Forum>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Forums --------------------------------------------------------

	@RequestMapping(value = "/forum/", method = RequestMethod.DELETE)
	public ResponseEntity<Forum> deleteAllForums() {
		System.out.println("Deleting All Blogs");

		forumService.deleteAllForums();
		return new ResponseEntity<Forum>(HttpStatus.NO_CONTENT);
	}

}
