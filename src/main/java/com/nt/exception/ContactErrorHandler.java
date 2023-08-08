package com.nt.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ContactErrorHandler {
	
	
	@ExceptionHandler(ContactNotFoundException.class)
	public  ResponseEntity<ErrorDetails>  handleContacttNotFound(ContactNotFoundException cnfe )
	{
		  ErrorDetails details = new ErrorDetails(LocalDateTime.now(),cnfe.getMessage(),"404- Contact Not Found");
		  return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public  ResponseEntity<ErrorDetails> handleAllProblems(Exception e)
	{
		  ErrorDetails details = new ErrorDetails(LocalDateTime.now(),e.getMessage(),"Problem in execution");
		  return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
