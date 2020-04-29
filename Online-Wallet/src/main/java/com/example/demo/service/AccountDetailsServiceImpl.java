package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountDetailsDAO;
import com.example.demo.entity.AccountDetails;

@Service(value = "accountService")
public class AccountDetailsServiceImpl implements AccountDetailsService 
{
	@Autowired
	private AccountDetailsDAO accountDAO;
	@Override
	public List<AccountDetails> getAllAccounts() 
	{
		return accountDAO.getAllAccounts();
	}

	@Override
	public void updateBalace(long accountNumber, int balance) 
	{
		accountDAO.updateBalace(accountNumber, balance);
	}

	@Override
	public int showBalance(long accountNumber)
	{
		return accountDAO.showBalance(accountNumber);
	}

	@Override
	public AccountDetails findByAccountNumber(long accountNumber)
	{
		return accountDAO.findByAccountNumber(accountNumber);
	}

}
