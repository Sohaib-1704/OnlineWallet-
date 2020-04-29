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
import com.capgemini.onlinewallet.service.UserServiceInterface;

@RestController
public class UserController {

	@Autowired
	private UserServiceInterface userServiceInterface;

	@CrossOrigin
	@PostMapping("/signUp")
	public ResponseEntity<User> signUp(@RequestBody User user) throws UserException {
		User use = userServiceInterface.signUp(user);
		return new ResponseEntity<User>(use, HttpStatus.OK);
	}

	@GetMapping("/login/{email}/{password}")
	public ResponseEntity<User> login(@PathVariable("email") String email, @PathVariable("password") String password)
			throws UserException {
		if (userServiceInterface.existsByEmail(email)) {
			User user = userServiceInterface.loginUser(email, password);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/admin/{email}/{password}")
	public ResponseEntity<User> admin(@PathVariable("email") String email, @PathVariable("password") String password)
			throws UserException {
		if (userServiceInterface.existsByEmail(email)) {
			User user = userServiceInterface.loginAdmin(email, password);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getUserDetails")
	public ResponseEntity<List<User>> getAllUserDetails() {
		List<User> lstUser = userServiceInterface.getAllUsers();
		return new ResponseEntity<List<User>>(lstUser, HttpStatus.OK);
	}

	@GetMapping("/getUserByEmail/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) throws UserException {
		if (userServiceInterface.existsByEmail(email)) {
			User user = userServiceInterface.findByEmail(email);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/delUser/{id}")
	public ResponseEntity<String> delUserById(@PathVariable("id") int id) throws UserException {
		userServiceInterface.delete(id);
		return new ResponseEntity<String>("User Deleted", HttpStatus.OK);
	}

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) throws UserException {
		if (userServiceInterface.existsById(id)) {
			User user = userServiceInterface.findById(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateFullName/{id}")
	public ResponseEntity<User> updateFullName(@PathVariable("id") int id, @RequestBody User User)
			throws UserException {
		if (userServiceInterface.existsById(id)) {
			userServiceInterface.updateFullName(User, id);
			return new ResponseEntity<User>(User, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updatePassword/{id}")
	public ResponseEntity<User> updatePassword(@PathVariable("id") int id, @RequestBody User User)
			throws UserException {
		if (userServiceInterface.existsById(id)) {
			userServiceInterface.updatePassword(User, id);
			return new ResponseEntity<User>(User, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updatePhoneNumber/{id}")
	public ResponseEntity<User> updatePhoneNumber(@PathVariable("id") int id, @RequestBody User User)
			throws UserException {
		if (userServiceInterface.existsById(id)) {
			userServiceInterface.updatePhoneNumber(User, id);
			return new ResponseEntity<User>(User, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateUserToAdmin/{id}")
	public ResponseEntity<User> updateUserToAdmin(@PathVariable("id") int id, User User) throws UserException {
		if (userServiceInterface.existsById(id)) {
			userServiceInterface.updateUserToAdmin(User, id);
			return new ResponseEntity<User>(User, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateToUser/{id}")
	public ResponseEntity<User> updateToUser(@PathVariable("id") int id, User User) throws UserException {
		if (userServiceInterface.existsById(id)) {
			userServiceInterface.updateToUser(User, id);
			return new ResponseEntity<User>(User, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/logout/{id}")
	public ResponseEntity<String> logout(User user, @PathVariable("id") int id) throws UserException {
		if (userServiceInterface.existsById(id)) {
			userServiceInterface.logout(user, id);
			return new ResponseEntity<String>("Logged Out Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);

	}
}
