package com.capgemini.onlineWallet.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.onlineWallet.entities.WalletTransactions;


@Transactional
@Repository("addMoneyDao")
public class OnlineWalletDao implements OnlineWalletDaoInterface {
	@PersistenceContext
	private EntityManager entityManager;

	//@Override
	public WalletTransactions AddMoney(WalletTransactions walletTransactions) {
		entityManager.persist( walletTransactions);
		return  walletTransactions;
	}
	
}
