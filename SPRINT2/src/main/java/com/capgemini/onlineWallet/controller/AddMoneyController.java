package com.capgemini.onlineWallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlineWallet.service.AddMoneyService;



@RestController
public class AddMoneyController {

	@Autowired
	private AddMoneyService service;
	
	@GetMapping("/addmoney/{accountid}/{amount}")
	public boolean addMoney(@PathVariable(name="accountid") int accId, @PathVariable(name="amount") double amt ) {
		service.addMoney(accId, amt);
		return true;
	}
}
