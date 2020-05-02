package com.capgemini.onlinewallet;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.capgemini.onlinewallet.entity.User;
import com.capgemini.onlinewallet.entity.WalletAccount;
import com.capgemini.onlinewallet.entity.WalletTransaction;
import com.capgemini.onlinewallet.entity.WalletAccount.status;

@SpringBootApplication
@EnableTransactionManagement
public class WalletApplication implements CommandLineRunner
{
	@Autowired
	private EntityManager em;
	public static void main(String[] args) 
	{
		SpringApplication.run(WalletApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception
	{
		WalletAccount w1 = new WalletAccount(530.00,status.Active);
		em.persist(new User("email_1","Naruto","Uzumaki","rasengan","rasengan","9455925519",w1));
		em.persist(w1);
		WalletAccount w2 = new WalletAccount(400.00,status.Active);
		em.persist(new User("email_2","kazuto","kirigaya","rasengan","rasengan","7087233323",w2));
		em.persist(w2);
		WalletAccount w3 = new WalletAccount(500.00,status.Active);
		em.persist(new User("email_3","Ken","Kaneki","rasengan","rasengan","9696132996",w3));
		em.persist(w3);
		WalletAccount w4 = new WalletAccount(600.00,status.Active);
		em.persist(new User("email_4","Kaori","Miyazono","rasengan","rasengan","9125476123",w4));
		em.persist(w4);
		//Transactions W1
		em.persist(new WalletTransaction("food",LocalDate.of(2017, 12, 10),100.20,500.20,w1));
		em.persist(new WalletTransaction("food",LocalDate.of(2017, 12, 11),200.80,2100.20,w1));
		em.persist(new WalletTransaction("food",LocalDate.of(2017, 12, 12),110.00,5200.20,w1));
		em.persist(new WalletTransaction("food",LocalDate.of(2017, 12, 13),180.20,5300.20,w1));
		em.persist(new WalletTransaction("food",LocalDate.of(2017, 12, 14),120.20,800.20,w1));
		//Transactions W2
		em.persist(new WalletTransaction("food",LocalDate.of(2017, 12, 10),110.40,900.20,w2));
		em.persist(new WalletTransaction("food",LocalDate.of(2017, 12, 10),130.10,400.20,w2));
		em.persist(new WalletTransaction("food",LocalDate.of(2017, 12, 10),140.50,600.20,w2));
		em.persist(new WalletTransaction("food",LocalDate.of(2017, 12, 10),160.10,1200.20,w2));
		em.persist(new WalletTransaction("food",LocalDate.of(2017, 12, 10),110.70,500.20,w2));
		
	}

}
