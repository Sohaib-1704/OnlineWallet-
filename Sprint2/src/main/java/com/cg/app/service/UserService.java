package com.cg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.cg.app.dao.UserDaoInterface;
import com.cg.app.entity.User;

@Service("userService")
public class UserService implements UserServiceInterface {
 
	@Autowired
	private UserDaoInterface userDaoInterface;
	@Override
	public User signUp(User user) {
		 userDaoInterface.signUp(user);
		 return user;
	}
	@Override
	public List<User> login() {
		System.out.println(userDaoInterface.login());
		return userDaoInterface.login();
	}
	@Override
	public Boolean delete(int id) {
		return userDaoInterface.delete(id);
	}
	@Override
	public User findById(int id) {
		return userDaoInterface.findById(id);
	}
	@Override
	public boolean existsById(int id) {
		return userDaoInterface.findId(id);
	}
	@Override
	public void updateData(User user) {
		userDaoInterface.update(user);	
	}
	@Override
	public User findByEmail(String email) {
		return userDaoInterface.findByEmail(email);
	}
	@Override
	public boolean existsByEmail(String email) {
		return userDaoInterface.findEmail(email);
	}
}