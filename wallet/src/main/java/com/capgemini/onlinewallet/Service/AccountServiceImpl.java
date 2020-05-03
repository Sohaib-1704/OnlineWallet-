package com.capgemini.onlinewallet.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinewallet.dao.AccountDAO;
import com.capgemini.onlinewallet.dto.Transaction;
import com.capgemini.onlinewallet.entity.WalletAccount;
/************************************************************************************
 * @author:						Sharon Sony 
 * Description:					It is a service class that provides the services for 
 * 								account control methods 
 * Version:						1.0 
 * Created:						Date 22-APR-2020
 ************************************************************************************/
@Service(value = "accountService")
public class AccountServiceImpl implements AccountService
{
	@Autowired
	private AccountDAO accountDAO;
	@Override
	public ResponseEntity<WalletAccount> getAccountDetails(int id) 
	{
		return ResponseEntity.ok().body(accountDAO.getAccountDetails(id));
	}

}
