package com.capgemini.onlineWallet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlineWallet.Service.OnlineWalletService;

@RestController
public class OnlineWalletController {

	@Autowired
	private OnlineWalletService service;
	
	@GetMapping("/addmoney/{accountid}/{amount}")
	public boolean addMoney(@PathVariable(name="accountid") int accId, @PathVariable(name="amount") double amt ) {
		service.addMoney(accId, amt);
		return true;
	}
	
	@GetMapping("/transfermoney/{sid}/{rid}/{amt}")
	public boolean transferMoney(@PathVariable(name="sid") int sid, @PathVariable(name="rid") int rid, @PathVariable(name="amt") double amt) {
		service.transferMoney(sid, rid, amt);
		return true;
	}
		
		

}