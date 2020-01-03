package com.example.springrestfulwebservices.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Esto es una excepcion que sera retornada en el formato standard de springboot
 * 
 * */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFountException extends RuntimeException {

	public UserNotFountException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}




}
