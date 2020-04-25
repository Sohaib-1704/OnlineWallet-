package com.capgemini.onlineWallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlineWallet.service.AddMoneyServiceInterface;

@RestController
public class OnlineWalletController {
	@Autowired
	private AddMoneyServiceInterface addMoneyServiceInterface;

}
