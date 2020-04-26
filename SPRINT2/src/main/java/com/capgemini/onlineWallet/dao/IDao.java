package com.capgemini.onlineWallet.dao;

public interface IDao {

	public boolean addMoney(int accountId, double amount);
	public boolean sendMoney(int senderAccId, int receiverAccId, double amount);
}
