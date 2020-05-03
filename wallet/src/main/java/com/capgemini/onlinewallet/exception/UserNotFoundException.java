package com.capgemini.onlinewallet.exception;

import lombok.Getter;
/************************************************************************************
 *          @author          Sharon Sony
 *          Description      It is a exception class for user
 *          Version          1.0
 *          Created Date     24-APR-2020
 ************************************************************************************/
@Getter
public class UserNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = -3204705332368137965L;
	
	private String msg;
	
	public UserNotFoundException(String msg)
	{
		super();
		this.msg = msg;
	}
	
	
}
