package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class AccountDetails 
{
	@Id
	@Column(name = "account_number",nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accountNumber;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "balance")
	private int balance;
	
	public AccountDetails()
	{
		super();
	}

	public AccountDetails(String userName, int balance) 
	{
		super();
		this.userName = userName;
		this.balance = balance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}
