package com.capgemini.onlinewallet.dao;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinewallet.entity.WalletAccount;

public interface AccountDAO 
{
	public WalletAccount getAccountDetails(int id);
}
