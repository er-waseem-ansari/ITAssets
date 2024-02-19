package com.hexaware.ITAssets.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AssetNotFoundException extends Exception {
	
	private String message;
	public AssetNotFoundException(String message)
	{
		super(message);
	}

}
