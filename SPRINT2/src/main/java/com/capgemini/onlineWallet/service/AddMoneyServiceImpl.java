package com.capgemini.onlineWallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlineWallet.dao.OnlineWalletInterfaceDao;



@Service
public class AddMoneyServiceImpl implements AddMoneyService	 {

	@Autowired
	private OnlineWalletInterfaceDao dao;
	
	@Override
	public boolean addMoney(int accId, double amt) {
		dao.addMoney(accId, amt);
		return false;
	}

}
