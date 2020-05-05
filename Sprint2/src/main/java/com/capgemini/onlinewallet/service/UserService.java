package com.capgemini.onlinewallet.service;

import java.util.List;

import com.capgemini.onlinewallet.entity.User;
import com.capgemini.onlinewallet.exception.UserException;
/**********************Service Interface******************************/
public interface UserService {

	User signUp(User user) throws UserException;

	Boolean deleteUser(int id) throws UserException;

	User findById(int id) throws UserException;

	User loginUser(String email, String password) throws UserException;

	User loginAdmin(String email, String password) throws UserException;

	User findByEmail(String email) throws UserException;

	String logout(User user, int id) throws UserException;

	String updatePassword(User user, int id) throws UserException;

	String updatePhoneNumber(User user, int id) throws UserException;

	String updateFullName(User user, int id) throws UserException;

	String updateUserToAdmin(User user, int id) throws UserException;

	List<User> getAllUsers();

	String updateToUser(User user, int id) throws UserException;

	String updateUser(User user, int id) throws UserException;


}
