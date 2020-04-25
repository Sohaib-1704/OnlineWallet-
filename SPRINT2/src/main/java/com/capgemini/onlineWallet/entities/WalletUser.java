package com.capgemini.onlineWallet.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UserDetails")
public class WalletUser{
	@Id
	@Column(name="userid")
	private int userId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="phonenumber")
	private String privateNumber;
	
	@Column(name="loginname")
	private String loginName;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrivateNumber() {
		return privateNumber;
	}

	public void setPrivateNumber(String privateNumber) {
		this.privateNumber = privateNumber;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}	
}
