package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AccountDetails;
import com.example.demo.service.AccountDetailsService;

@RestController
@RequestMapping("/api")
public class AccountDetailsController 
{
	@Autowired
	private AccountDetailsService accountService;
	
	@RequestMapping(value = "/accounts",method = RequestMethod.GET)
	public List<AccountDetails> getAllAccounts()
	{
		return accountService.getAllAccounts();
	}
	
	@RequestMapping(value = "/accounts/{accountNumber}/{balance}",method = RequestMethod.GET)
	public void updateBalance(@PathVariable long accountNumber,@PathVariable int balance)
	{
		accountService.updateBalace(accountNumber, balance);
	}
	
	@RequestMapping(value = "/accounts/{accountNumber}",method = RequestMethod.GET)
	public AccountDetails getByAccountNumber(@PathVariable long accountNumber)
	{
		return accountService.findByAccountNumber(accountNumber);
	}
	
	@RequestMapping(value = "/accounts/balance/{accountNumber}",method = RequestMethod.GET)
	public int showBalance(@PathVariable long accountNumber)
	{
		return accountService.showBalance(accountNumber);
	}
}
