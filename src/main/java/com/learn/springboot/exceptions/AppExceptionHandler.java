package com.learn.springboot.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) {
		
		ErrorMessage msg = new ErrorMessage(ex.getLocalizedMessage(), new java.util.Date());
		
		return new ResponseEntity<>(msg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
	public ResponseEntity<Object> handleSpecificException(Exception ex, WebRequest request) {
		
		ErrorMessage msg = new ErrorMessage(ex.getLocalizedMessage(), new java.util.Date());
		
		return new ResponseEntity<>(msg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	/*
	 * @ExceptionHandler(value = UserServiceException.class) public
	 * ResponseEntity<Object> handleUserServiceException(UserServiceException ex,
	 * WebRequest request) {
	 * 
	 * ErrorMessage msg = new ErrorMessage(ex.getLocalizedMessage(), new
	 * java.util.Date());
	 * 
	 * return new ResponseEntity<>(msg, new HttpHeaders(),
	 * HttpStatus.INTERNAL_SERVER_ERROR);
	 * 
	 * }
	 */

}
