package com.capgemini.onlinewallet.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinewallet.dao.AccountDAO;
import com.capgemini.onlinewallet.dto.Transaction;
import com.capgemini.onlinewallet.entity.WalletAccount;

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
