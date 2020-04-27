package com.cg.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.dao.UserDaoInterface;
import com.cg.app.entity.User;
import com.cg.app.entity.User.type;
import com.cg.app.exception.UserException;
import com.cg.app.entity.User.login;

@Service("userService")
public class UserService implements UserServiceInterface {
 
	@Autowired
	private UserDaoInterface userDaoInterface;
	@Override
	public User signUp(User user) throws UserException {
		checkEmail(user.getEmail());
		userDaoInterface.signUp(user);
		return user;
	}
	@Override
    public User loginUser(String email, String password) throws UserException{   
    	if(userDaoInterface.findUserByEmail(email)==false)
    		throw new UserException("User does not exist, Please enter a valid email");
    	User user=userDaoInterface.getUserByEmail(email);
        if(user.getUserType()==type.admin)
        	throw new UserException("User login only");
    	if(user.getPassword().equals(password)==false)
    		throw new UserException("Email or password does not match");
    	user.setLoginStatus(login.loggedIn);
    	return user;		
    }
	boolean checkEmail(String email) throws UserException {
		 if(userDaoInterface.findUserByEmail(email)==true)
			 throw new UserException("User already exists, please login with your email");
		else return true;
	}
	@Override
    public Integer loginAdmin(String email, String password) throws UserException{   
    	if(userDaoInterface.findUserByEmail(email)==false)
    		throw new UserException("User does not exist, Please enter a valid email");
    	User user=userDaoInterface.getUserByEmail(email);
        if(user.getUserType()==type.user)
        	throw new UserException("Admin login only");
    	if(user.getPassword().equals(password)==false)
    		throw new UserException("Email or password does not match");
    	user.setLoginStatus(login.loggedIn);
    	return user.getId();		
    }
	@Override
	public List<User> findAll() {
		return userDaoInterface.reterive();
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
	public String updateData(User user, int id) throws UserException {
		if (userDaoInterface.update(user,id)==true)
			return "updated";
		else 
			throw new UserException("Error");
	}
	@Override
	public User findByEmail(String email) {
		return userDaoInterface.getUserByEmail(email);
	}
	@Override
	public boolean existsByEmail(String email) {
		return userDaoInterface.findUserByEmail(email);
	}
	
	@Override
	public void logout(Integer userId){
		User user=userDaoInterface.getUser(userId);
	   	user.setLoginStatus(login.LoggedOut);
 	}
	
}