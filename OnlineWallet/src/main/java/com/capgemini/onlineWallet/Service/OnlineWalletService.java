package com.capgemini.onlineWallet.Service;

public interface OnlineWalletService {

	void transferMoney(int sid, int rid, double amt);

	void addMoney(int accId, double amt);

}
