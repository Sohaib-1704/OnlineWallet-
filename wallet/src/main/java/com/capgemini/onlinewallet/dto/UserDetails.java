package com.capgemini.onlinewallet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDetails 
{
	private String email;
	private String firstName;
	private String lastName;
	private String phoneNumber;
}
