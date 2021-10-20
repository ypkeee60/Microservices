package com.learn.springboot.exceptions;

public class UserServiceException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserServiceException (String msg) {
		super(msg);
		
	}

}
