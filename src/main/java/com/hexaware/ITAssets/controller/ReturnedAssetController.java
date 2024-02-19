package com.hexaware.ITAssets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ITAssets.entity.ReturnedAsset;
import com.hexaware.ITAssets.service.ReturnedAssetService;

@RestController
@RequestMapping("/it-assets/api/return-asset")
public class ReturnedAssetController {
	@Autowired
	private ReturnedAssetService returnedAssetService;
	
	@PostMapping("/return")
	public ResponseEntity<ReturnedAsset> addToReturnedAsset(@RequestBody ReturnedAsset returnedAsset) {
		
		return ResponseEntity.ok().body(returnedAssetService.addToReturnedAssets(returnedAsset));
	}
	
}
