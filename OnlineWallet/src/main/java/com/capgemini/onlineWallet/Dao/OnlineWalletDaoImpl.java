package com.capgemini.onlineWallet.Dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.onlineWallet.Entities.WalletAccount;
import com.capgemini.onlineWallet.Entities.WalletTransactions;
import com.capgemini.onlineWallet.Entities.WalletUser;




@Repository
public class OnlineWalletDaoImpl implements OnlineWalletDao {
	@Autowired
	 @PersistenceContext
	EntityManager em;

	
	public OnlineWalletDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void persistUser(WalletUser user) {
		em.persist(user);
		
	}
	@Override
	public void persistTransaction(WalletTransactions transaction) {
	em.persist(transaction);
		
	}
	@Override
	public void persistAccount(WalletAccount account) {
		// TODO Auto-generated method stub
		em.persist(account);
	}
	@Override
	public WalletUser getUser(Integer userId) {
		WalletUser user = em.find(WalletUser.class, userId);
		return user;
	}
	@Override
	public WalletAccount getAccount(Integer accountId) {
		WalletAccount account=em.find(WalletAccount.class, accountId);
		return account;
	}

	@Override
	public WalletTransactions getTransaction(Integer transactionId) {
		WalletTransactions transaction=em.find(WalletTransactions.class, transactionId);
		return transaction;
	}

	

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}
	
	

}