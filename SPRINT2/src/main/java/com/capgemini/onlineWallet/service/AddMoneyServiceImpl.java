package com.capgemini.onlineWallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlineWallet.dao.IDao;



@Service
public class AddMoneyServiceImpl implements AddMoneyService	 {

	@Autowired
	private IDao dao;
	
	@Override
	public boolean addMoney(int accId, double amt) {
		dao.addMoney(accId, amt);
		return false;
	}

}
