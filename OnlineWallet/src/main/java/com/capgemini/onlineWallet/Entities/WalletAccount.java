package com.capgemini.onlineWallet.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/* ************************************************************************************
 *          @author          Aishwarya Srivastava
 *          Description      It is a entity class that provides the entities for 
 *                           wallet account.
 *          Version          1.0
 *          Created Date     20-APR-2020
 ************************************************************************************/
@Entity
@Table(name = "WalletAccount")
public class WalletAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
	@SequenceGenerator(sequenceName = "account_seq", allocationSize = 1, name = "account_seq")

	@Column(name = "accountid")
	private int accountId;

	@Column(name = "accountbalance")
	private Double accountBalance;

	@Column(name = "status")
	private String status;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double amt) {
		this.accountBalance = amt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public WalletAccount(Double accountBalance, String status) {
		super();
		this.accountBalance = accountBalance;
		this.status = status;
	}

	public WalletAccount() {
		super();
	}
	

}
