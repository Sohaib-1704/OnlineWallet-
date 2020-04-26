package com.cg.app.service;

import com.cg.app.entity.User;
import com.cg.app.exception.UserException;

public interface UserServiceInterface {

	User signUp(User user) throws UserException;

	Boolean delete(int id);

	User findById(int id);

	boolean existsById(int id);

	void updateData(User user);

	User findByEmail(String email);

	boolean existsByEmail(String email);

	Integer loginUser(String email, String password) throws UserException;

	void logout(Integer userId);


}
