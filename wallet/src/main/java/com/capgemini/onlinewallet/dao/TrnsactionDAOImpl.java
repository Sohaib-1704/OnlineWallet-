package com.capgemini.onlinewallet.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinewallet.dto.Transaction;
import com.capgemini.onlinewallet.entity.WalletTransaction;

@Repository(value = "transactionDAO")
public class TrnsactionDAOImpl implements TransactionDAO
{
	@Autowired
	private EntityManager em;
	
	@Override
	public List<Transaction> getAllTransactions(int accountId) 
	{
		List<Transaction> transaction = new ArrayList<>();
		String HQL = "From WalletTransaction where account_id =?1";
		for(WalletTransaction trans:em.createQuery(HQL,WalletTransaction.class).setParameter(1, accountId).getResultList())
		{
			transaction.add(new Transaction(trans.getTransactionId(),trans.getDescription(),trans.getAmount(),trans.getAccountBalance(),trans.getTransactionDate()));
		}
		return transaction;
	}

	@Override
	public List<Transaction> getByDate(LocalDate start, LocalDate end)
	{
		List<Transaction> transaction = new ArrayList<>();
		String HQL = "From WalletTransaction where date BETWEEN ?1 AND ?2";
		for(WalletTransaction trans:em.createQuery(HQL,WalletTransaction.class).setParameter(1, start).setParameter(2, end).getResultList())
		{
			transaction.add(new Transaction(trans.getTransactionId(),trans.getDescription(),trans.getAmount(),trans.getAccountBalance(),trans.getTransactionDate()));
		}
		return transaction;
	}

}
