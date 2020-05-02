package com.capgemini.onlinewallet.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinewallet.dto.UserDetails;
import com.capgemini.onlinewallet.entity.User;

@Repository(value = "userDAO")
public class UserDAOImpl implements UserDAO
{
	private EntityManager em;
	@Autowired
	public UserDAOImpl(EntityManager em)
	{
		super();
		this.em = em;
	}

	@Override
	public List<UserDetails> showAllUsers() 
	{
		List<UserDetails> userDetails = new ArrayList<>();
		for(User user:em.createQuery("From User",User.class).getResultList())
		{
			userDetails.add(new UserDetails(user.getFirstname(),user.getLastname(),user.getEmail(),user.getPhoneNumber()));
		}
		return userDetails;
	}

	@Override
	public User findById(int id)
	{ 
		return em.find(User.class, id);
	}

	@Override
	public String updateUserDetails(UserDetails userDetails,int id) 
	{
		User user = em.find(User.class, id);
		user.setFirstname(userDetails.getFirstName());
		user.setLastname(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
		user.setPhoneNumber(userDetails.getPhoneNumber());
		em.merge(user);
		return "User updated";
	}

	@Override
	public String delete(int id) 
	{
		em.remove(em.find(User.class, id));
		return "Deletion successful";
	}

}
