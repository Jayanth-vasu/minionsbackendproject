/*package com.minions.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minions.model.UserDetails;

@RestController
public class UserDetailsController {

	@RequestMapping(value="/userDetails",method=RequestMethod.GET)
	public ResponseEntity<List<UserDetails>> listUser(){
		List<UserDetails> userDetails=userDetailsService.list();
		if(userDetails.isEmpty()){
			return new ResponseEntity<List<UserDetails>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserDetails>>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/userDetails/{id}",method=RequestMethod.POST,produces=Media)
	public ResponseEntity<UserDetails> getUserDetails(@RequestParam("id") int id){
		UserDetails userDetails=userDetailsService.get(id);
		if(userDetails==null){
			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserDetails>(userDetails,HttpStatus.OK);
		
	}
}
*/