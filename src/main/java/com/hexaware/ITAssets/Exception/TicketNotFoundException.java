package com.hexaware.ITAssets.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TicketNotFoundException extends Exception {
	
	private String message;
	
	public TicketNotFoundException(String message)
	{
		super(message);
	}

}
