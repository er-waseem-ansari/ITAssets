package com.hexaware.ITAssets.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {
	
	@ExceptionHandler({EmployeeNotFoundException.class})
	public ResponseEntity<String> handleCustomerNotFound(){
		return new ResponseEntity<String>("employee with given id not found", HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler({TicketNotFoundException.class})
	public ResponseEntity<String> handleTicketNotFound(){
		return new ResponseEntity<String>("ticket not found with given id",HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler({AssetNotFoundException.class})
	public ResponseEntity<String> handleAssetNotFound(){
		return new ResponseEntity<String>("Asset with given id not found", HttpStatus.NOT_FOUND);
		
	}

}
