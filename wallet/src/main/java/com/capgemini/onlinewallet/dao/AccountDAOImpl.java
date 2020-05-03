package com.capgemini.onlinewallet.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinewallet.Service.UserDetailsService;
import com.capgemini.onlinewallet.entity.WalletAccount;
import com.capgemini.onlinewallet.exception.UserNotFoundException;
/************************************************************************************
 *          @author          Sharon Sony
 *          Description      It is a dao class that provides the methods to fetch 
 *                           and account data
 *          Version          1.0
 *          Created Date     20-APR-2020
 ************************************************************************************/
@Repository(value = "accountDAO")
public class AccountDAOImpl implements AccountDAO
{
	@Autowired
	private EntityManager em;
	
	@Autowired
	private UserDetailsService userService;
	/************************************************************************************
	 * Method:                        show all users
	 * Description:                   To show all the Users 
	 * @param showallusers			  fetch the details
	 * @returns                      returns the details 
	 ************************************************************************************/
	@Override
	public WalletAccount getAccountDetails(int id)
	{
		if(userService.findById(id)!=null)
		{
			return em.find(WalletAccount.class, id);
		}
		else
			throw new UserNotFoundException("No such account exists");
	}
	
}
