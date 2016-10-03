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

import com.minions.model.Friend;
import com.minions.service.FriendService;

@RestController
public class FriendController {

	@Autowired
	FriendService friendService;

	// -------------------Retrieve All Friends--------------------------------------------------------
	@RequestMapping(value = "/friend/", method = RequestMethod.GET)
	public ResponseEntity<List<Friend>> listAllFriends() {
		List<Friend> friends = friendService.findAllFriends();
		if (friends.isEmpty()) {
			return new ResponseEntity<List<Friend>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Friend>>(friends, HttpStatus.OK);
	}

	// -------------------Retrieve Single Friend--------------------------------------------------------

	@RequestMapping(value = "/friend/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Friend> getUser(@PathVariable("id") int id) {
		System.out.println("Fetching Blog with id " + id);
		Friend friend = friendService.findById(id);
		if (friend == null) {
			System.out.println("Friend with id " + id + " not found");
			return new ResponseEntity<Friend>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);
	}

	// -------------------Create a  Friend--------------------------------------------------------

	@RequestMapping(value = "/friend/", method = RequestMethod.POST)
	public ResponseEntity<Friend> createFriend(@RequestBody Friend friend, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Friend " + friend.getUserDetails());
		
		
		friendService.saveFriend(friend);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/friend/{id}").buildAndExpand(friend.getFriend_id()).toUri());
		return new ResponseEntity<Friend>(headers, HttpStatus.CREATED);
	}

	
	// ------------------- Delete a Friend --------------------------------------------------------

	@RequestMapping(value = "/friend/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Friend> deleteFriend(@PathVariable("id") int id) {
		System.out.println("Fetching & Deleting Friend with id " + id);

		Friend friend = friendService.findById(id);
		if (friend == null) {
			System.out.println("Unable to delete. Friend with id " + id + " not found");
			return new ResponseEntity<Friend>(HttpStatus.NOT_FOUND);
		}

		friendService.deleteFriendById(id);
		return new ResponseEntity<Friend>(HttpStatus.NO_CONTENT);
	}

	

}
