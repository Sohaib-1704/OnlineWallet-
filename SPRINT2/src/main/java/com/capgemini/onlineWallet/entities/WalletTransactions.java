package com.capgemini.onlineWallet.entities;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transactionsAishwaryas")
public class WalletTransactions {

	@Id
	@Column(name="transactionid")
	private int transactionId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="Date")
	private LocalDate date;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="accountbalance")
	private double accountBalance;

	@ManyToOne
	@JoinColumn(name="accountid", referencedColumnName="accountid")
	private WalletAccount acc= new WalletAccount();
	
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public WalletAccount getAcc() {
		return acc;
	}

	public void setAcc(WalletAccount acc) {
		this.acc = acc;
	}
	
	
	
}
