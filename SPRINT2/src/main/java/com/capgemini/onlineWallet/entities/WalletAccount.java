package com.capgemini.onlineWallet.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="onlinewalletaccount")
public class WalletAccount {

	@Id
	@Column(name="account_id")
	private int accountId;
	
	@Column(name="account_balance")
	private double accountBalance;
	
	@Column(name="status")
	private String status;
	
	@OneToOne
	@JoinColumn(name="user_id",referencedColumnName="user_id")
	WalletUser obj = new WalletUser();

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public WalletUser getObj() {
		return obj;
	}

	public void setObj(WalletUser obj) {
		this.obj = obj;
	}
	
	
	
}
