package com.capgemini.onlineWallet.Dao;

import com.capgemini.onlineWallet.Entities.WalletAccount;
import com.capgemini.onlineWallet.Entities.WalletTransactions;
import com.capgemini.onlineWallet.Entities.WalletUser;

public interface OnlineWalletDao {
	//void persistUser(WalletUser user);
	WalletUser getUser(Integer userId);
	WalletAccount getAccount(Integer accountId);
	WalletTransactions getTransaction(Integer transactionId);
	//void persistAccount(WalletAccount account);
	
	void persistTransaction(WalletTransactions transaction);
	void addUser(WalletUser user);
	//void addTransaction(WalletTransactions transaction);
	void addAccount(WalletAccount account);
	//void editUser(WalletTransactions transaction);
}
