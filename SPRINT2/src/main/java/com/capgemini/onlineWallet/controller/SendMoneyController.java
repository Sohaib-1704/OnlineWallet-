package com.capgemini.onlineWallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlineWallet.service.SendMoneyService;



@RestController
public class SendMoneyController {

	@Autowired
	private SendMoneyService service;
	
	@GetMapping("/sendmoney/{sid}/{rid}/{amt}")
	public boolean sendMoney(@PathVariable(name="sid") int sid, @PathVariable(name="rid") int rid, @PathVariable(name="amt") double amt) {
		service.sendMoney(sid, rid, amt);
		return true;
	}
}
