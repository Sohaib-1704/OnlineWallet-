package com.capgemini.onlineWallet.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/* *************************************************************************************
 *          @author         Aishwarya Srivastava
 *          Description      It is a entity class that provides the entities for 
 *                           wallet user.
 *          Version          1.0
 *          Created Date     20-APR-2020
 ************************************************************************************/
@Entity
@Table(name = "WalletUser")
public class WalletUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usr_seq")
	@SequenceGenerator(sequenceName = "usr_seq", allocationSize = 1, name = "usr_seq")

	@Column(name = "userid")
	private int userId;

	@Column(name = "password")
	private String password;

	@Column(name = "phonenumber")
	private String phoneNumber;

	@Column(name = "loginname")
	private String loginName;

	public int getUserId() {
		return userId;
	}

	@OneToOne
	@JoinColumn(name = "accountid", referencedColumnName = "accountid")
	private WalletAccount walletAccout;// = new WalletAccount();

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}



	public WalletAccount getWalletAccout() {
		return walletAccout;
	}

	public void setWalletAccout(WalletAccount walletAccout) {
		this.walletAccout = walletAccout;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public WalletUser(String password, String phoneNumber, String loginName, WalletAccount walletAccout) {
		super();
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.loginName = loginName;
		this.walletAccout = walletAccout;
	}



}
