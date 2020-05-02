package com.capgemini.onlinewallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinewallet.Service.AccountService;
import com.capgemini.onlinewallet.entity.WalletAccount;

@RestController
public class AccountController 
{
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/accounts/{id}")
	public ResponseEntity<WalletAccount> getAccountDetails(@PathVariable int id)
	{
		return accountService.getAccountDetails(id);
	}
}
