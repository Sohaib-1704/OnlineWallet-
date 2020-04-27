package com.capgemini.onlineWallet.dao;

public interface OnlineWalletInterfaceDao {

	public boolean addMoney(int accountId, double amount);
	public boolean sendMoney(int senderAccId, int receiverAccId, double amount);
}
