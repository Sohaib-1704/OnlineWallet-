package com.capgemini.onlinewallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinewallet.entity.User;
import com.capgemini.onlinewallet.exception.UserException;
import com.capgemini.onlinewallet.service.UserService;
/************************************************************************************
*          @author          Sohaib Khan
*          Description      It is a controller class that process action for 
*          					signUp, login, logout and admin operations like 
*          					delete, getDetails and updateData etc.  
*          Version          1.0
*          Created Date     22-APR-2020
************************************************************************************/
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@CrossOrigin
	@PostMapping("/signUp")
	public ResponseEntity<User> signUp(@RequestBody User user) throws UserException {
		User use = userService.signUp(user);
		return new ResponseEntity<User>(use, HttpStatus.OK);
	}

	@GetMapping("/login/{email}/{password}")
	public ResponseEntity<User> login(@PathVariable("email") String email, @PathVariable("password") String password)
			throws UserException {
		if (userService.findByEmail(email)!=null) {
			User user = userService.loginUser(email, password);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/admin/{email}/{password}")
	public ResponseEntity<User> admin(@PathVariable("email") String email, @PathVariable("password") String password)
			throws UserException {
		if (userService.findByEmail(email)!=null) {
			User user = userService.loginAdmin(email, password);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getAllUserDetails")
	public ResponseEntity<List<User>> getAllUserDetails() {
		List<User> lstUser = userService.getAllUsers();
		return new ResponseEntity<List<User>>(lstUser, HttpStatus.OK);
	}

	@GetMapping("/getUserByEmail/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) throws UserException {
		if (userService.findByEmail(email)!=null) {
			User user = userService.findByEmail(email);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable("id") int id) throws UserException {
		userService.deleteUser(id);
		return new ResponseEntity<String>("User Deleted", HttpStatus.OK);
	}

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) throws UserException {
		User user = userService.findById(id);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateFullName/{id}")
	public ResponseEntity<User> updateFullName(@PathVariable("id") int id, @RequestBody User User)
			throws UserException {
		User user = userService.findById(id);
		if (user != null) {	
			userService.updateFullName(User, id);
			return new ResponseEntity<User>(User, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updatePassword/{id}")
	public ResponseEntity<User> updatePassword(@PathVariable("id") int id, @RequestBody User User)
			throws UserException {
		User user = userService.findById(id);
		if (user != null) {
			userService.updatePassword(User, id);
			return new ResponseEntity<User>(User, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updatePhoneNumber/{id}")
	public ResponseEntity<User> updatePhoneNumber(@PathVariable("id") int id, @RequestBody User User)
			throws UserException {
		User user = userService.findById(id);
		if (user != null) {
			userService.updatePhoneNumber(User, id);
			return new ResponseEntity<User>(User, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateUserToAdmin/{id}")
	public ResponseEntity<User> updateUserToAdmin(@PathVariable("id") int id, User User) throws UserException {
		User user = userService.findById(id);
		if (user != null) {
			userService.updateUserToAdmin(User, id);
			return new ResponseEntity<User>(User, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateToUser/{id}")
	public ResponseEntity<User> updateToUser(@PathVariable("id") int id, User User) throws UserException {
		User user = userService.findById(id);
		if (user != null) {
			userService.updateToUser(User, id);
			return new ResponseEntity<User>(User, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/logout/{id}")
	public ResponseEntity<String> logout(User user, @PathVariable("id") int id) throws UserException {
		User use = userService.findById(id);
		if (use != null) {
			userService.logout(user,id);
			return new ResponseEntity<String>("Logged Out Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);

	}
}
