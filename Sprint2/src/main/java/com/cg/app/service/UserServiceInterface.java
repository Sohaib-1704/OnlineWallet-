package com.cg.app.service;

import java.util.List;

import com.cg.app.entity.User;
import com.cg.app.exception.UserException;

public interface UserServiceInterface {

	User signUp(User user);

	public List<User> login();

	Boolean delete(int id);

	User findById(int id);

	boolean existsById(int id);

	void updateData(User user);

	User findByEmail(String email);

	boolean existsByEmail(String email);

	Integer loginUser(String email, String password) throws UserException;


}
