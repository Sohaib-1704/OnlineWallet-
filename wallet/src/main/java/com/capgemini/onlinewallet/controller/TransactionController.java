package com.capgemini.onlinewallet.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinewallet.Service.TransactionService;
import com.capgemini.onlinewallet.dto.Transaction;
/************************************************************************************
*          @author          Sharon Sony
*          Description      It is a controller class that process action for 
*          					passbook operations like getalltransactions and searchbydate.
*         
*          Version          1.0
*          Created Date     22-APR-2020
************************************************************************************/
@RestController
public class TransactionController 
{
	@Autowired
	private TransactionService transactionService;
	@GetMapping("/gettransactions/{accountId}")
	public ResponseEntity<List<Transaction>> getAllTransactions(@PathVariable int accountId)
	{
		return transactionService.getAllTransactions(accountId);
	}
	@CrossOrigin
	@GetMapping("/transactions/{start}/{end}")
	public ResponseEntity<List<Transaction>> getByDate(@PathVariable("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,@PathVariable("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end)
	{
		return transactionService.getByDate(start, end);
	}
}
