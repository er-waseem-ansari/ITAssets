package com.hexaware.ITAssets.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ITAssets.Exception.AssetNotFoundException;
import com.hexaware.ITAssets.dto.AssetDTO;
import com.hexaware.ITAssets.entity.Asset;
import com.hexaware.ITAssets.service.AssetService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/assets")
public class AssetController {
	
	@Autowired
	private AssetService assetService;
	
	@PostMapping("/add")
	public ResponseEntity<Asset> addAsset(@RequestBody Asset asset) {
		
		return ResponseEntity.ok().body(assetService.addAsset(asset));
	}
	
	@GetMapping("/{assetId}")
	public ResponseEntity<Asset> getAssetById(@PathVariable Long assetId)throws AssetNotFoundException
	{
		
		return ResponseEntity.ok().body(assetService.getAssetById(assetId));
	}
	

	@GetMapping("/all")
	public ResponseEntity<List<AssetDTO>> getTotalAssets(){
		return ResponseEntity.ok().body(assetService.getTotalAssets());
	}
	
	@GetMapping("/available")
	public ResponseEntity<List<AssetDTO>> getAvailableAssets(){
		return ResponseEntity.ok().body(assetService.getAvailableAssets());
	}
	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<AssetDTO>> getAvailableAssetsByCategoryId(@PathVariable Long categoryId){
		
		return ResponseEntity.ok().body(assetService.getAvailableAssetsByCategoryId(categoryId));
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping("/{assetId}")
	public ResponseEntity<String> deleteAssetById(@PathVariable Long assetId) {
		String message = "Asset not deleted";
		if(assetService.deleteAssetById(assetId)) {
			message = "Asset deleted";
		}
		return ResponseEntity.ok().body(message);
		
	}
	


}
