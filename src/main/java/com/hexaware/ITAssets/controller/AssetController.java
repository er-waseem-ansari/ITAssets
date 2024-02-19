package com.hexaware.ITAssets.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ITAssets.Exception.AssetNotFoundException;
import com.hexaware.ITAssets.dto.AssetDTO;
import com.hexaware.ITAssets.entity.Asset;
import com.hexaware.ITAssets.service.AssetService;


@RestController
@RequestMapping("/it-assets/api/asset")
public class AssetController {
	
	@Autowired
	private AssetService assetService;
	
	@PostMapping("/add-asset")
	public ResponseEntity<Asset> addAsset(@RequestBody Asset asset) {
		
		return ResponseEntity.ok().body(assetService.addAsset(asset));
	}
	
	@GetMapping("/getById")
	public ResponseEntity<Asset> getAssetById(@RequestParam Long assetId)throws AssetNotFoundException
	{
		
		return ResponseEntity.ok().body(assetService.getAssetById(assetId));
	}
	
	@GetMapping("/get-total-assets")
	public ResponseEntity<List<AssetDTO>> getTotalAssets(){
		return ResponseEntity.ok().body(assetService.getTotalAssets());
	}
	
	@GetMapping("/get-available-assets")
	public ResponseEntity<List<AssetDTO>> getAvailableAssets(){
		return ResponseEntity.ok().body(assetService.getAvailableAssets());
	}
	
	@GetMapping("/get-available-assets-by-category")
	public ResponseEntity<List<AssetDTO>> getAvailableAssetsByCategoryId(@RequestParam Long categoryId){
		
		return ResponseEntity.ok().body(assetService.getAvailableAssetsByCategoryId(categoryId));
	}
	
	@DeleteMapping("/delete-asset-by-id")
	public ResponseEntity<String> deleteAssetById(@RequestParam Long assetId) {
		String message = "Asset not deleted";
		if(assetService.deleteAssetById(assetId)) {
			message = "Asset deleted";
		}
		return ResponseEntity.ok().body(message);
		
	}
	


}
