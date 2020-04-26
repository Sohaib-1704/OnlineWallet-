package com.capgemini.onlineWallet.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="onlinewallettransactions")
public class WalletTransactions {

	@Id
	@Column(name="transaction_id")
	private int transactionId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="dateOfTransaction")
	private LocalDate dateOfTransaction;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="account_balance")
	private double accountBalance;
	
	@ManyToOne
	@JoinColumn(name="account_id", referencedColumnName="account_id")
	WalletAccount obj = new WalletAccount();

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

	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
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

	public WalletAccount getObj() {
		return obj;
	}

	public void setObj(WalletAccount obj) {
		this.obj = obj;
	}
	
	
}
