package com.capgemini.onlinewallet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/************************************************************************************
 *          @author          Sohaib Khan
 *          Description      It is a entity class that provides the entities for 
 *                           wallet account.
 *          Version          1.0
 *          Created Date     20-APR-2020
 ************************************************************************************/
@Entity
@Table(name = "WalletAccount")

public class WalletAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;

	@Column(name = "accountBalance")
	private Double accountBalance = 0.0;

	public enum status {
		Active, Inactive
	};

	@Enumerated(EnumType.STRING)
	private status activity;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public status getActivity() {
		return activity;
	}

	public void setActivity(status activity) {
		this.activity = activity;
	}

	public WalletAccount(Double accountBalance, status activity) {
		super();
		this.accountBalance = accountBalance;
		this.activity = activity;
	}

	public WalletAccount() {
		super();
	}

}
