package com.hexaware.ITAssets.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ReturnedAsset addToReturnedAsset(@RequestBody ReturnedAsset returnedAsset) {
		return returnedAssetService.addToReturnedAssets(returnedAsset);
	}
	
}
