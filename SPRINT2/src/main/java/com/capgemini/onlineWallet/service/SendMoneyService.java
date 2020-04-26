package com.capgemini.onlineWallet.service;

public interface SendMoneyService {

	public boolean sendMoney(int senderId, int receiverId, double amount);
}
