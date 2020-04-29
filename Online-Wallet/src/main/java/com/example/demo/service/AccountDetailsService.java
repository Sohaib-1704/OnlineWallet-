package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.AccountDetails;

public interface AccountDetailsService 
{
	public List<AccountDetails> getAllAccounts();
	public void updateBalace(long accountNumber,int balance);
	public int showBalance(long accountNumber);
	public AccountDetails findByAccountNumber(long accountNumber);
}
