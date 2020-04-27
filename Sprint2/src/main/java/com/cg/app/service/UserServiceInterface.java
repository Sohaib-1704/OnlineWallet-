package com.cg.app.service;

import java.util.List;

import com.cg.app.entity.User;
import com.cg.app.exception.UserException;

public interface UserServiceInterface {

	User signUp(User user) throws UserException;

	Boolean delete(int id);

	User findById(int id);

	boolean existsById(int id);

	User loginUser(String email, String password) throws UserException;

	void logout(Integer userId);

	Integer loginAdmin(String email, String password) throws UserException;

	List<User> findAll();

	boolean existsByEmail(String email);

	User findByEmail(String email);

	String updateData(User user, int id) throws UserException;


}
