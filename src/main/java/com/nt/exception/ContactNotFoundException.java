package com.nt.exception;

public class ContactNotFoundException extends Exception 
{
	
	private static final long serialVersionUID = 1L;

	public ContactNotFoundException(String msg) 
	{
		super(msg);
	}

}
