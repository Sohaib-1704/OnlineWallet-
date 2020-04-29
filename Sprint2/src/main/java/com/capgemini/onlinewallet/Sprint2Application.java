package com.capgemini.onlinewallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sprint2Application //implements CommandLineRunner
{
		@Autowired
	public static void main(String[] args) {
		SpringApplication.run(Sprint2Application.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		User user1=new User("sharon@gmail.com","Sharon","sony","Sharon@123","Sharon@123");
//		userDao.addUser(user1);
//	}

	
}
