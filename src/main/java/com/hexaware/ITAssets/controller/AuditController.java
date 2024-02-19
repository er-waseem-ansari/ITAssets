package com.hexaware.ITAssets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ITAssets.service.AuditService;

@RestController
public class AuditController {
	
	// audit asset status-tejas
	@Autowired
	private AuditService auditService;
	//audit ticket
	
	public ResponseEntity<String> auditAssetStatus()
	{
		
		return ResponseEntity.ok().body(auditService.auditAssetStatus());
	}
	//

}
