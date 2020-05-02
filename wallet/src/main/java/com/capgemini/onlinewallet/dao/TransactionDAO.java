package com.capgemini.onlinewallet.dao;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.onlinewallet.dto.Transaction;

public interface TransactionDAO 
{
	public List<Transaction> getAllTransactions(int accountId);
	public List<Transaction> getByDate(LocalDate start,LocalDate end);
}
