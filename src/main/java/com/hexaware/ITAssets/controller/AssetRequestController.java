package com.hexaware.ITAssets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ITAssets.entity.AssetRequest;
import com.hexaware.ITAssets.service.AssetRequestService;

@RestController
@RequestMapping("/it-assets/api/asset-request")
public class AssetRequestController {

	@Autowired
	private AssetRequestService assetRequestService;
	
	@PostMapping("/add-asset-request")
	public AssetRequest addAssetRequest(@RequestBody AssetRequest assetRequest){
		return assetRequestService.addAssetRequest(assetRequest);
	}
	
	@PutMapping("/approve-asset-request/{requestId}")
	public String approveAssetRequest(@PathVariable Long requestId) {
		return assetRequestService.approveAssetRequest(requestId);
		
	}
	
}
