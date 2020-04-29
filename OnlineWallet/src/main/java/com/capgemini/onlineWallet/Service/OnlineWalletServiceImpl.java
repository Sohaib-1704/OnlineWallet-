package com.capgemini.onlineWallet.Service;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.capgemini.onlineWallet.Dao.OnlineWalletDao;
import com.capgemini.onlineWallet.Entities.WalletAccount;
import com.capgemini.onlineWallet.Exceptions.InvalidAmountException;
import com.capgemini.onlineWallet.Exceptions.UnauthorizedUserException;

@Transactional
@Service

public class OnlineWalletServiceImpl implements OnlineWalletService{
	public OnlineWalletServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private OnlineWalletDao dao;
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addMoney(int accountId, double amount) {
	
		WalletAccount userAcc= em.find(WalletAccount.class, accountId);
		if(userAcc.getStatus()== "inactive")
			throw new UnauthorizedUserException("Invalid user");
		userAcc.setAccountBalance(userAcc.getAccountBalance()+amount);
		
	}


	@Override
	public void transferMoney(int senderAccId, int receiverAccId, double amount) {
	
		
		WalletAccount senderAcc= em.find(WalletAccount.class,senderAccId);
		WalletAccount receiverAcc = em.find(WalletAccount.class,receiverAccId);
		if(senderAcc.getAccountBalance()< amount)
			throw new InvalidAmountException("Amount to be sent can not be greater than the balance ");
		if(senderAcc.getStatus()   == "inactive")
			if(receiverAcc.getStatus()== "inactive")
				throw new UnauthorizedUserException("Invalid user");
		senderAcc.setAccountBalance(senderAcc.getAccountBalance()-amount);
		receiverAcc.setAccountBalance(receiverAcc.getAccountBalance()+amount);
		
		

	}
	}