package com.prowings.exception;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler(SQLException.class)
	public ResponseEntity<String> handleSQLException(HttpServletRequest request, Exception ex){
		
		return new ResponseEntity<String>("database_error",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InvalidNetworkException.class)
	public ResponseEntity<Error> handleInvalidNetworkException(Throwable e){
		String message = e.getMessage();
		
		Error error = new Error();
		error.setMessage(message);
		error.setRootCause("due to some inauthorised activity");
		error.setStatusCode(404);
		
		return new ResponseEntity<Error>(error,HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<Error> handleNetworkNotFoundException(Throwable e){
		
		String message = e.getMessage();
		
		Error error = new Error();
		
		error.setMessage(message);
		error.setRootCause("due to some illegal activity");
		error.setStatusCode(500);
		
		return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
	}
}
