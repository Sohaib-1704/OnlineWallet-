package com.capgemini.onlinewallet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.onlinewallet.exception.UserNotFoundException;
import com.capgemini.onlinewallet.exception.UserResponseEntity;
/************************************************************************************
 *          @author          Sharon Sony
 *          Description      It is a rest controller advice class for exceptions
 *          Version          1.0
 *          Created Date     24-APR-2020
 ************************************************************************************/
@ControllerAdvice
public class UserExceptionHandeller 
{
	@ExceptionHandler
	public ResponseEntity<UserResponseEntity> handleException(UserNotFoundException unfe)
	{
		return new ResponseEntity<UserResponseEntity>(new UserResponseEntity(HttpStatus.NOT_FOUND.value(),unfe.getMsg(),System.currentTimeMillis()),HttpStatus.NOT_FOUND);
	}
}
