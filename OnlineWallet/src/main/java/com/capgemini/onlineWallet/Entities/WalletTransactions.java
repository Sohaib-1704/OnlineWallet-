package com.capgemini.onlineWallet.Entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/* ***********************************************************************************
 *          @author          Aishwarya Srivastava
 *          Description      It is a entity class that provides the entities for 
 *                           transactions.
 *          Version          1.0
 *          Created Date     20-APR-2020
 ************************************************************************************/
@Entity
@Table(name="WalletTransactions")
public class WalletTransactions {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tran_seq")
	@SequenceGenerator(sequenceName = "tran_seq", allocationSize = 1, name = "tran_seq")

	@Column(name="transactionid")
	private int transactionId;
	
	@Column(name="description")
	private String description;
	
	
	private LocalDate transdate;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="accountbalance")
	private double accountBalance;

	@ManyToOne
	@JoinColumn(name="accountid", referencedColumnName="accountid")
	private WalletAccount walletAccount;//= new WalletAccount();
	
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

	public WalletTransactions(String description, LocalDate date, double amount, double accountBalance,
			WalletAccount walletAccount) {
		super();
		this.description = description;
		this.transdate = date;
		this.amount = amount;
		this.accountBalance = accountBalance;
		this.walletAccount = walletAccount;
	}

	public WalletTransactions() {
		super();
	}

	public LocalDate getTransdate() {
		return transdate;
	}

	public void setTransdate(LocalDate transdate) {
		this.transdate = transdate;
	}


	
	
}
