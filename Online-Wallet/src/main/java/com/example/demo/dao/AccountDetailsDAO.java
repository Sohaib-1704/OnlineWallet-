package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.AccountDetails;

public interface AccountDetailsDAO
{
	public List<AccountDetails> getAllAccounts();
	public void updateBalace(long accountNumber,int balance);
	public int showBalance(long accountNumber);
	public AccountDetails findByAccountNumber(long accountNumber);
}
