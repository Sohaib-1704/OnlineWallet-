package com.capgemini.onlinewallet.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/************************************************************************************
 *          @author          Sohaib Khan
 *          Description      It is a entity class that provides the entities for 
 *                           transactions.
 *          Version          1.0
 *          Created Date     20-APR-2020
 ************************************************************************************/
@Entity
@Table(name = "WalletTransactions")

public class WalletTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;

	@Column(name = "description", length = 100)
	private String description;

	private LocalDate transactionDate;

	@Column(name = "amount")
	private double amount;

	@Column(name = "accountbalance")
	private double accountBalance;

	@ManyToOne
	@JoinColumn(name = "accountId", referencedColumnName = "accountId")
	private WalletAccount walletAccount;

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

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
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

	public WalletAccount getWalletAccount() {
		return walletAccount;
	}

	public void setWalletAccount(WalletAccount walletAccount) {
		this.walletAccount = walletAccount;
	}

	public WalletTransaction(String description, LocalDate transactionDate, double amount, double accountBalance,
			WalletAccount walletAccount) {
		super();
		this.description = description;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.accountBalance = accountBalance;
		this.walletAccount = walletAccount;
	}

	public WalletTransaction() {
		super();
	}

}