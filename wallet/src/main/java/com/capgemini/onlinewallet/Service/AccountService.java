package com.capgemini.onlinewallet.Service;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinewallet.entity.WalletAccount;
/**********************Service Interface******************************/
public interface AccountService 
{
	public ResponseEntity<WalletAccount> getAccountDetails(int id);
}
