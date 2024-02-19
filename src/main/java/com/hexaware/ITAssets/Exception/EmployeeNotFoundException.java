package com.hexaware.ITAssets.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeNotFoundException extends Exception {
	
	private String message;
	public EmployeeNotFoundException(String message)
	{
		super(message);
		
	}

}
