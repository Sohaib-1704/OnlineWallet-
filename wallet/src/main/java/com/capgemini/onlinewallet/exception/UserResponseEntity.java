package com.capgemini.onlinewallet.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserResponseEntity 
{
	private int statusCode;
	private String msg;
	private long time;
	
	public UserResponseEntity(int statusCode)
	{
		super();
		this.statusCode = statusCode;
	}
	
}
