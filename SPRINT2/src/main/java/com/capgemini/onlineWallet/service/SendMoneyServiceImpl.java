package com.capgemini.onlineWallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlineWallet.dao.OnlineWalletInterfaceDao;



@Service
public class SendMoneyServiceImpl implements SendMoneyService{

	@Autowired
	private OnlineWalletInterfaceDao dao;
	
	@Override
	public boolean sendMoney(int senderId, int receiverId, double amount) {
		dao.sendMoney(senderId, receiverId, amount);
		return false;
	}

}
