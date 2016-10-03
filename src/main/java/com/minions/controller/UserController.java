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

import com.minions.model.UserDetails;
import com.minions.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	// -------------------Retrieve All Users--------------------------------------------------------
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<UserDetails>> listAllUsers() {
		List<UserDetails> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<UserDetails>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserDetails>>(users, HttpStatus.OK);
	}

	// -------------------Retrieve Single User--------------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDetails> getUser(@PathVariable("id") int id) {
		System.out.println("Fetching User with id " + id);
		UserDetails userDetails = userService.findById(id);
		if (userDetails == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
	}

	// -------------------Create a  User--------------------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<UserDetails> createBlog(@RequestBody UserDetails userDetails, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + userDetails.getMail_id());

		if (userService.UserExist(userDetails.getMail_id())) {
			System.out.println("A Blog with name " + userDetails.getMail_id() + " already exist");
			return new ResponseEntity<UserDetails>(HttpStatus.CONFLICT);
		}

		userService.saveUser(userDetails);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(userDetails.getUser_id()).toUri());
		return new ResponseEntity<UserDetails>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Blog--------------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserDetails> updateUser(@PathVariable("id") int id, @RequestBody UserDetails userDetails) {
		System.out.println("Updating user " + id);

		UserDetails currentUser = userService.findById(id);

		if (currentUser == null) {
			System.out.println("Blog with id " + id + " not found");
			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
		}

		currentUser.setUser_name(userDetails.getUser_name());
		currentUser.setUser_name(userDetails.getMail_id());
		
		

		userService.updateUser(currentUser);
		return new ResponseEntity<UserDetails>(currentUser, HttpStatus.OK);
	}

	// ------------------- Delete a User --------------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserDetails> deleteUser(@PathVariable("id") int id) {
		System.out.println("Fetching & Deleting Blog with id " + id);

		UserDetails user = userService.findById(id);
		if (user == null) {
			System.out.println("Unable to delete. User with id " + id + " not found");
			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
		}

		userService.deleteUserById(id);
		return new ResponseEntity<UserDetails>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Users --------------------------------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	public ResponseEntity<UserDetails> deleteAllBlogs() {
		System.out.println("Deleting All Blogs");

		userService.deleteAllUsers();;
		return new ResponseEntity<UserDetails>(HttpStatus.NO_CONTENT);
	}

}
