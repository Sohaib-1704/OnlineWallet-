package com.cg.app.dao;

import com.cg.app.entity.User;

public interface UserDaoInterface {
	
	public User signUp(User user);
	
	Boolean delete(int id);

	 boolean findId(int id);

	User findById(int id);

	void update(User user);

	User findByEmail(String email);

	boolean findEmail(String email);

	boolean findUserByEmail(String email);

	User getUserByEmail(String email);

	User getUser(Integer userId);

}
