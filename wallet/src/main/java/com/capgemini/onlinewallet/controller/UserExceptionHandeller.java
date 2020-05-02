package com.capgemini.onlinewallet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.onlinewallet.exception.UserNotFoundException;
import com.capgemini.onlinewallet.exception.UserResponseEntity;

@ControllerAdvice
public class UserExceptionHandeller 
{
	@ExceptionHandler
	public ResponseEntity<UserResponseEntity> handleException(UserNotFoundException unfe)
	{
		return new ResponseEntity<UserResponseEntity>(new UserResponseEntity(HttpStatus.NOT_FOUND.value(),unfe.getMsg(),System.currentTimeMillis()),HttpStatus.NOT_FOUND);
	}
}
