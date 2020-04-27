package com.cg.app.dao;

import java.util.List;

import com.cg.app.entity.User;

public interface UserDaoInterface {
	
	public User signUp(User user);
	
	Boolean delete(int id);

	 boolean findId(int id);

	User findById(int id);

	boolean findUserByEmail(String email);

	User getUserByEmail(String email);

	User getUser(Integer userId);

	public List<User> reterive();

	boolean update(User user, int id);


}
