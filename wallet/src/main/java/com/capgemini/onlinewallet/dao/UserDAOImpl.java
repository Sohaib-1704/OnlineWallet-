package com.capgemini.onlinewallet.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinewallet.dto.UserDetails;
import com.capgemini.onlinewallet.entity.User;
/************************************************************************************
 *          @author          Sharon Sony
 *          Description      It is a dao class that provides the methods to fetch 
 *                           and update user data
 *          Version          1.0
 *          Created Date     20-APR-2020
 ************************************************************************************/
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
	/************************************************************************************
	 * Method:                        show all users
	 * Description:                   To show all the Users 
	 * @param showallusers			  fetch the details
	 * @returns userDetails           returns the details 
	 ************************************************************************************/
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
	/************************************************************************************
	 * Method:                        find by id
	 * Description:                   To find by id the Users 
	 * @param findbyid				  fetch the details
	 * @returns userdetails           returns the details 
	 ************************************************************************************/
	@Override
	public User findById(int id)
	{ 
		return em.find(User.class, id);
	}
	/************************************************************************************
	 * Method:                        update user details
	 * Description:                   To show all the Users 
	 * @param updateuserdetails		  update the details
	 * @returns string                returns the details 
	 ************************************************************************************/
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
	/************************************************************************************
	 * Method:                        delete
	 * Description:                   To delete a User 
	 * @param delete				  delete the details
	 * @returns string                returns the details 
	 ************************************************************************************/
	@Override
	public String delete(int id) 
	{
		em.remove(em.find(User.class, id));
		return "Deletion successful";
	}

}
