package com.hexaware.ITAssets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ITAssets.entity.IssuedAsset;
import com.hexaware.ITAssets.service.IssuedAssetService;

@RestController
@RequestMapping("/it-assets/api/asset")
public class IssuedAssetController {
	
	@Autowired
	private IssuedAssetService issuedAssetService;
	
	@PostMapping("/issue-asset")
	public IssuedAsset addToIssuedAsset(@RequestBody IssuedAsset issuedAsset) {
		return issuedAssetService.addToIssuedAsset(issuedAsset);
	}
	
}
