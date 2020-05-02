package com.capgemini.onlineWallet.Service;
import java.time.LocalDate;
import java.util.Random;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.onlineWallet.Dao.OnlineWalletDao;
import com.capgemini.onlineWallet.Entities.WalletAccount;
import com.capgemini.onlineWallet.Entities.WalletTransactions;
import com.capgemini.onlineWallet.Exceptions.InvalidAmountException;
import com.capgemini.onlineWallet.Exceptions.UnauthorizedUserException;
/* ***********************************************************************************
 * @author:						Aishwarya Srivastava
 * Description:					It is a service class that provides the services for 
  								add money and transfer money methods
 * Version:						1.0 
 * Created:						Date 22-APR-2020
 ************************************************************************************/

@Transactional
@Service
public class OnlineWalletServiceImpl implements OnlineWalletService{
	
	@Autowired
	private OnlineWalletDao dao;
	
	
	
	/* ***********************************************************************************
	 * Method: 					addMoney
	 * Description: 			to add an amount to user's wallet
	 * @returns user: 			amount is added to the user's wallet
	 ************************************************************************************/
	@Override
	public void addMoney(int accountId, double amount) {
	
		
		WalletAccount userAcc= dao.getAccount(accountId);
		if(userAcc.getStatus()== "inactive")
			throw new UnauthorizedUserException("Invalid user");
		userAcc.setAccountBalance(userAcc.getAccountBalance()+amount);
		Random random = new Random();
		int transactionId=accountId+random.nextInt(1000);

		WalletTransactions obj= new WalletTransactions();
		obj.setTransactionId(transactionId);
		obj.setDescription("Money added");
		obj.setAmount(amount);
		obj.setAccountBalance(userAcc.getAccountBalance());
		obj.setWalletAccount(userAcc);
	   
		obj.setTransdate(LocalDate.now());
		dao.persistTransaction(obj);
		
	}
	/* ***********************************************************************************
	 * Method: 					transferMoney
	 * Description: 			To send money from one wallet account to another
	 * @returns user: 			amount is deducted from sender's wallet account
	 *                          amount is added into receiver's wallet account
	 ************************************************************************************/

	@Override
	public void transferMoney(int senderAccId, int receiverAccId, double amount) {
	
		WalletAccount senderAcc= dao.getAccount(senderAccId);
		WalletAccount receiverAcc = dao.getAccount( receiverAccId);
		if(senderAcc.getAccountBalance()< amount)
			throw new InvalidAmountException("Amount to be sent can not be greater than the balance ");
		if(senderAcc.getStatus()   == "inactive")
			if(receiverAcc.getStatus()== "inactive")
				throw new UnauthorizedUserException("Invalid user");
		senderAcc.setAccountBalance(senderAcc.getAccountBalance()-amount);
		receiverAcc.setAccountBalance(receiverAcc.getAccountBalance()+amount);
		
		Random random = new Random();
		int transactionId1=senderAccId+random.nextInt(1000);
		int transactionId2=receiverAccId+random.nextInt(1000);

		WalletTransactions obj1= new WalletTransactions();
		obj1.setTransactionId(transactionId1);
		obj1.setDescription("Money sent");
		obj1.setAmount(amount);
		obj1.setAccountBalance(senderAcc.getAccountBalance());
		obj1.setWalletAccount(senderAcc);
		obj1.setTransdate(LocalDate.now());
		dao.persistTransaction(obj1);
		
		
		WalletTransactions obj2= new WalletTransactions();
		obj2.setTransactionId(transactionId2);
		obj2.setDescription("Money Received");
		obj2.setAmount(amount);
		obj2.setAccountBalance(receiverAcc.getAccountBalance());
		obj2.setWalletAccount(receiverAcc);
		obj2.setTransdate(LocalDate.now());
		dao.persistTransaction(obj2);
	}
}