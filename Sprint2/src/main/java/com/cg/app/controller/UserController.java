package com.cg.app.controller;

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

import com.cg.app.entity.User;
import com.cg.app.exception.UserException;
import com.cg.app.service.UserServiceInterface;

@RestController
public class UserController {

	@Autowired
	private UserServiceInterface userServiceInterface;
	
	@CrossOrigin
	@PostMapping("/signUp")
	public ResponseEntity<User> signUp(@RequestBody User user) throws UserException {
		User use= userServiceInterface.signUp(user);
		return new ResponseEntity<User>(use, HttpStatus.OK);		
	}
	@GetMapping("/login/{email}/{password}")
	public ResponseEntity<User> login(@PathVariable("email") String email,@PathVariable("password") String password) throws UserException{
		User user=userServiceInterface.loginUser(email, password);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	@GetMapping("/admin/{email}/{password}")
	public ResponseEntity<Integer> admin(@PathVariable("email") String email,@PathVariable("password") String password) throws UserException{
		Integer userId=userServiceInterface.loginAdmin(email, password);
		return new ResponseEntity<Integer>(userId,HttpStatus.OK);
	}
	@GetMapping("/getUserDetails")
    public ResponseEntity<List<User>> getAllUserDetails() {
			List<User> lstUser = userServiceInterface.findAll();
			return new ResponseEntity<List<User>>(lstUser,HttpStatus.OK);
	}
	
	@GetMapping("/delUser/{id}")
	public ResponseEntity<Boolean> delUser(@PathVariable("id") int id) throws UserException {
		Boolean status = userServiceInterface.delete(id);
		if(!status)throw new UserException("User not found.");
		
		return new ResponseEntity<Boolean>(status, HttpStatus.OK);
	}
	@GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUser (@PathVariable("id") int id) {
		if(userServiceInterface.existsById(id)){
			User user = userServiceInterface.findById(id);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") int id,@RequestBody User User) throws UserException{
	    if (userServiceInterface.existsById(id)){
		    userServiceInterface.updateData(User,id);
		    return new ResponseEntity<User>(User,HttpStatus.OK);
		}
   	 return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	@GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<User> getUserByEmail (@PathVariable("email") String email) {
		if(userServiceInterface.existsByEmail(email)){
			User user = userServiceInterface.findByEmail(email);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	@PutMapping("/logout/{id}")
	public ResponseEntity<String> logout(@PathVariable("id") int id){
		userServiceInterface.logout(id);
		return new ResponseEntity<String>("Logged Out Successfully",HttpStatus.OK);
	}
}
