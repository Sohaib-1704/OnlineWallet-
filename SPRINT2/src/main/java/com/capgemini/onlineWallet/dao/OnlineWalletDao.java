package com.capgemini.onlineWallet.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.onlineWallet.entities.WalletAccount;



@Repository
@Transactional
public class OnlineWalletDao implements OnlineWalletInterfaceDao {

	@PersistenceContext
	private EntityManager em;


	@Override
	public boolean addMoney(int accountId, double amount) {
		WalletAccount userAcc= em.find(WalletAccount.class, accountId);
		userAcc.setAccountBalance(userAcc.getAccountBalance()+amount);
		return false;
	}


	@Override
	public boolean sendMoney(int senderAccId, int receiverAccId, double amount) {
		WalletAccount senderAcc= em.find(WalletAccount.class,senderAccId);
		WalletAccount receiverAcc = em.find(WalletAccount.class,receiverAccId);
		
		senderAcc.setAccountBalance(senderAcc.getAccountBalance()-amount);
		receiverAcc.setAccountBalance(receiverAcc.getAccountBalance()+amount);
		
		return true;
	}
	
	
}
