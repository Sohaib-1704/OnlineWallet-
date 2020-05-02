package com.capgemini.onlinewallet.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Transaction
{
	private int transactionId;
	private String descritpion;
	private double amount;
	private double accountBalance;
	private LocalDate date;
}
