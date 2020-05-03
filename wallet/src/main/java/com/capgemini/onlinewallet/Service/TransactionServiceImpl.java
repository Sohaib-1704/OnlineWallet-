package com.capgemini.onlinewallet.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinewallet.dao.TransactionDAO;
import com.capgemini.onlinewallet.dto.Transaction;
/************************************************************************************
 * @author:						Sharon Sony 
 * Description:					It is a service class that provides the services for 
 * 								transaction control methods 
 * Version:						1.0 
 * Created:						Date 22-APR-2020
 ************************************************************************************/
@Service(value = "transactionService")
public class TransactionServiceImpl implements TransactionService
{
	@Autowired
	private TransactionDAO transactionDAO;
	/************************************************************************************
	 * Method: 					get all transactions
	 * Description: 			To show the transaction
	 * @param showtransaction:  show the transactions
	 * @param showtransaction: 	show all transactions
	 * @returns: 			    returns the details
	 ************************************************************************************/
	@Override
	public ResponseEntity<List<Transaction>> getAllTransactions(int accountId) 
	{
		
		return ResponseEntity.ok().body(transactionDAO.getAllTransactions(accountId));
	}

	@Override
	public ResponseEntity<List<Transaction>> getByDate(LocalDate start, LocalDate end)
	{
		return ResponseEntity.ok().body(transactionDAO.getByDate(start, end));
	}

}
