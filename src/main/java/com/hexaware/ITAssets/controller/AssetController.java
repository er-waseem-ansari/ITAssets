package com.hexaware.ITAssets.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Asset addAsset(@RequestBody Asset asset) {
		return assetService.addAsset(asset);
	}
	
	@GetMapping("/getById")
	public Asset getAssetById(@RequestParam Long assetId)throws AssetNotFoundException
	{
		return assetService.getAssetById(assetId);
	}
	
	@GetMapping("/get-total-assets")
	public List<AssetDTO> getTotalAssets(){
		return assetService.getTotalAssets();
	}
	
	@GetMapping("/get-available-assets")
	public List<AssetDTO> getAvailableAssets(){
		return assetService.getAvailableAssets();
	}
	
	@GetMapping("/get-available-assets-by-category")
	public List<AssetDTO> getAvailableAssetsByCategoryId(@RequestParam Long categoryId){
		return assetService.getAvailableAssetsByCategoryId(categoryId);
	}
	
	@DeleteMapping("/delete-asset-by-id")
	public String deleteAssetById(@RequestParam Long assetId) {
		String message = "Asset not deleted";
		if(assetService.deleteAssetById(assetId)) {
			message = "Asset deleted";
		}
		return message;
	}
	


}
