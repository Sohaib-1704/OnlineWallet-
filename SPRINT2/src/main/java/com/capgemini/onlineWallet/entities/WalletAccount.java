package com.capgemini.onlineWallet.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="AishwaryaAccount")
public class WalletAccount {

	@Id
	@Column(name="accountid")
	private int accountId;
	
	@Column(name="accountbalance")
	private int accountBalance;
	
	@Column(name="status")
	private String status;
	
	@OneToOne
	@JoinColumn(name="userid", referencedColumnName="userid")
	private WalletUser user= new WalletUser();

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public WalletUser getUser() {
		return user;
	}

	public void setUser(WalletUser user) {
		this.user = user;
	}


	
	
	
}
