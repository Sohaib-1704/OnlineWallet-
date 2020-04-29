package com.capgemini.onlinewallet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinewallet.dao.UserDaoInterface;
import com.capgemini.onlinewallet.entity.User;
import com.capgemini.onlinewallet.entity.User.type;
import com.capgemini.onlinewallet.exception.UserException;

@Transactional
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

	boolean checkEmail(String email) throws UserException {
		if (userDaoInterface.findUserByEmail(email) == true)
			throw new UserException("User already exists, please login with your email");
		else
			return true;
	}

	@Override
	public User loginUser(String email, String password) throws UserException {
		if (userDaoInterface.findUserByEmail(email) == false)
			throw new UserException("User does not exist, Please enter a valid email");
		User user = userDaoInterface.getUserByEmail(email);
		if (user.getUserType() == type.admin)
			throw new UserException("User login only");
		if (user.getPassword().equals(password) == false)
			throw new UserException("Email and password does not match");
		if (userDaoInterface.updateLogoutStatus(user, email) != true)
			throw new UserException("User already LoggedIn");
		return user;
	}

	@Override
	public User loginAdmin(String email, String password) throws UserException {
		if (userDaoInterface.findUserByEmail(email) == false)
			throw new UserException("User does not exist, Please enter a valid email");
		User user = userDaoInterface.getUserByEmail(email);
		if (user.getUserType() == type.user)
			throw new UserException("Admin login only");
		if (user.getPassword().equals(password) == false)
			throw new UserException("Email and password does not match");
		if (userDaoInterface.updateLogoutStatus(user, email) != true)
			throw new UserException("Admin already LoggedIn");
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userDaoInterface.retrieveData();
	}

	@Override
	public Boolean delete(int id) throws UserException {
		if (userDaoInterface.findId(id) == false)
			throw new UserException("User does not exist");
		return userDaoInterface.delete(id);
	}

	@Override
	public User findById(int id) throws UserException {
		if (userDaoInterface.findId(id) == false)
			throw new UserException("User does not exist");
		return userDaoInterface.findById(id);
	}

	@Override
	public boolean existsById(int id) throws UserException {
		if (userDaoInterface.findId(id) == false)
			throw new UserException("User does not exist");
		return userDaoInterface.findId(id);
	}

	@Override
	public User findByEmail(String email) throws UserException {
		if (userDaoInterface.findUserByEmail(email) == false)
			throw new UserException("User does not exist");
		return userDaoInterface.getUserByEmail(email);
	}

	@Override
	public boolean existsByEmail(String email) throws UserException {
		if (userDaoInterface.findUserByEmail(email) == false)
			throw new UserException("User does not exist");
		return userDaoInterface.findUserByEmail(email);
	}

	@Override
	public String updateFullName(User user, int id) throws UserException {
		if (userDaoInterface.updateFullName(user, id) == true)
			return "Name Updated";
		else
			throw new UserException("Error updating Name");
	}

	@Override
	public String updatePassword(User user, int id) throws UserException {
		if (userDaoInterface.updatePassword(user, id) == true)
			return "Password Updated";
		else
			throw new UserException("Error updating Password");
	}

	@Override
	public String updatePhoneNumber(User user, int id) throws UserException {
		if (userDaoInterface.updatePhoneNumber(user, id) == true)
			return "PhoneNumber Updated";
		else
			throw new UserException("Error updating PhoneNumber");
	}

	@Override
	public String updateUserToAdmin(User user, int id) throws UserException {
		if (userDaoInterface.updateUserToAdmin(user, id) == true)
			return " Updated";
		else
			throw new UserException("Error updating status");
	}

	@Override
	public String updateToUser(User user, int id) throws UserException {
		if (userDaoInterface.updateToUser(user, id) == true)
			return " Updated";
		else
			throw new UserException("Error updating status");
	}

	@Override
	public String logout(User user, int id) throws UserException {
		if (userDaoInterface.updateLoginStatus(user, id) != true)
			throw new UserException("User already LoggedOut");
		else
			return "LoggedOut";
	}

}