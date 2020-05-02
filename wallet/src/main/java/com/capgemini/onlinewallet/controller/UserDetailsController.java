package com.capgemini.onlinewallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinewallet.Service.UserDetailsService;
import com.capgemini.onlinewallet.dto.UserDetails;

@RestController
public class UserDetailsController 
{
	private UserDetailsService userService;
	@Autowired
	public UserDetailsController(UserDetailsService userService)
	{
		super();
		this.userService = userService;
	}
	
	@GetMapping("/userdetails")
	public ResponseEntity<List<UserDetails>> showAllUsers()
	{
		return userService.showAllUsers();
	}
	
	@GetMapping("/userdetails/{id}")
	public ResponseEntity<UserDetails> getById(@PathVariable int id)
	{
		return userService.findById(id);
	}
	
	@PutMapping("/userdetails/{id}")
	public ResponseEntity<String> updateUser(@RequestBody UserDetails userDetails,@PathVariable int id)
	{
		return userService.updateUserDetails(userDetails,id);
	}
	
	@DeleteMapping("/userdetails/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id)
	{
		return userService.delete(id);
	}
}
