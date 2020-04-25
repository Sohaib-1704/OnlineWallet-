package com.capgemini.onlineWallet;

//import javax.persistence.EntityManager;
//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.onlineWallet.dao.OnlineWalletDaoInterface;




@SpringBootApplication
public class Sprint2Application {//implements CommandLineRunner {
    @Autowired
    OnlineWalletDaoInterface addMoneyDao;
	public static void main(String[] args) {
		SpringApplication.run(Sprint2Application.class, args);
	}
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}

}
