package com.capgemini.onlinewallet.exception;
/************************************************************************************
 *          @author          Sohaib Khan
 *          Description      It is a exception class for user
 *          Version          1.0
 *          Created Date     24-APR-2020
 ************************************************************************************/
public class UserException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserException(String msg) {
		super(msg);
	}

}
