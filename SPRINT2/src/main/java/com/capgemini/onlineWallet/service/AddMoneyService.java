package com.capgemini.onlineWallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlineWallet.dao.OnlineWalletDaoInterface;
import com.capgemini.onlineWallet.entities.WalletTransactions;


@Service("addMoneyService")
public class AddMoneyService implements AddMoneyServiceInterface{
	
	@Autowired
	private OnlineWalletDaoInterface addMoneyInterface;
	
	@Override
	public WalletTransactions AddMoney(WalletTransactions walletTransactions ) {
		//OnlineWalletDaoInterface.AddMoney(walletTransactions);
		 return walletTransactions;

}
}