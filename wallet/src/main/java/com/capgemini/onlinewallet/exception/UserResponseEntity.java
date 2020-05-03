package com.capgemini.onlinewallet.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/************************************************************************************
 *          @author          Sharon Sony
 *          Description      It is a exception class for user
 *          Version          1.0
 *          Created Date     24-APR-2020
 ************************************************************************************/
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
