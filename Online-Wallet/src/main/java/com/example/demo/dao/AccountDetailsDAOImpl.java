package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.entity.AccountDetails;

@Repository(value = "accountDAO")
@EnableTransactionManagement
public class AccountDetailsDAOImpl implements AccountDetailsDAO
{
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<AccountDetails> getAllAccounts() 
	{
		return entityManager.createQuery("from AccountDetails",AccountDetails.class).getResultList();
	}

	@Override
	@Transactional
	public void updateBalace(long accountNumber, int balance)
	{
		AccountDetails account = findByAccountNumber(accountNumber);
		account.setBalance(account.getBalance() + balance);
		entityManager.merge(account);
	}

	@Override
	@Transactional
	public int showBalance(long accountNumber)
	{
		AccountDetails account = findByAccountNumber(accountNumber);
		return account.getBalance();
	}

	@Override
	public AccountDetails findByAccountNumber(long accountNumber) 
	{
		AccountDetails account = entityManager.find(AccountDetails.class, accountNumber);
		return account;
	}
	
}
