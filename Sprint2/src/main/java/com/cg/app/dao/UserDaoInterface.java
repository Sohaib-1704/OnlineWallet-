package com.cg.app.dao;

import java.util.List;

import com.cg.app.entity.User;

public interface UserDaoInterface {
	
	public User signUp(User user);
	
	List<User> login();

	Boolean delete(int id);

	 boolean findId(int id);

	User findById(int id);

	void update(User user);

	User findByEmail(String email);

	boolean findEmail(String email);

}
