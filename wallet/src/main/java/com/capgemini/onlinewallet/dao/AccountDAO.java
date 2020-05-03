package com.capgemini.onlinewallet.dao;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinewallet.entity.WalletAccount;
/*****************Interface of checkbalance ********************/
public interface AccountDAO 
{
	public WalletAccount getAccountDetails(int id);
}
