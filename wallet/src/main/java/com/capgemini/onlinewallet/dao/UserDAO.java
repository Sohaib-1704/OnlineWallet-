package com.capgemini.onlinewallet.dao;

import java.util.List;
import java.util.Optional;

import com.capgemini.onlinewallet.dto.UserDetails;
import com.capgemini.onlinewallet.entity.User;

public interface UserDAO 
{
	public List<UserDetails> showAllUsers();
	public User findById(int id);
	public String updateUserDetails(UserDetails userDetails,int id);
	public String delete(int id);
}
