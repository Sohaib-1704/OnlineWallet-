package com.capgemini.onlinewallet.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinewallet.dto.Transaction;

public interface TransactionService 
{
	public ResponseEntity<List<Transaction>> getAllTransactions(int accountId);
	public ResponseEntity<List<Transaction>> getByDate(LocalDate start,LocalDate end);
}
