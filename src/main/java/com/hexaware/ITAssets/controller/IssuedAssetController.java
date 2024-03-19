package com.hexaware.ITAssets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ITAssets.entity.IssuedAsset;
import com.hexaware.ITAssets.service.IssuedAssetService;
//
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/it-assets/api/asset")
public class IssuedAssetController {
//	
	@Autowired
	private IssuedAssetService issuedAssetService;
//	
//	@PostMapping("/issue-asset")
//	public IssuedAsset addToIssuedAsset(@RequestBody IssuedAsset issuedAsset) {
//		return issuedAssetService.addToIssuedAsset(issuedAsset);
//	}
//
//@GetMapping("/category/{categoryId}")
//	public ResponseEntity<List<AssetDTO>> getAvailableAssetsByCategoryId(@PathVariable Long categoryId){
//		
//		return ResponseEntity.ok().body(assetService.getAvailableAssetsByCategoryId(categoryId));
//	}
	
	@GetMapping("/issue-asset/{employeeId}")
	public ResponseEntity<List<IssuedAsset>> getIssuedAssetByEmployeeId(@PathVariable Long employeeId)
	{
		return ResponseEntity.ok().body(issuedAssetService.getIssuedAssetByEmployeeId(employeeId));
	}
	
	@GetMapping("/get-all-issued-asset")
	public ResponseEntity<List<IssuedAsset>> getAllIssuedAsset()
	{
		return ResponseEntity.ok().body(issuedAssetService.getAllIssuedAsset());
	}


//	
}

