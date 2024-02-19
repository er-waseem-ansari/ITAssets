package com.hexaware.ITAssets.service;

import java.util.List;

import com.hexaware.ITAssets.Exception.AssetNotFoundException;
import com.hexaware.ITAssets.dto.AssetDTO;
import com.hexaware.ITAssets.entity.Asset;

public interface AssetService {
	public Asset addAsset(Asset asset);
	public Asset getAssetById(Long assetId)throws AssetNotFoundException;
	public List<AssetDTO> getTotalAssets();
	public List<AssetDTO> getAvailableAssets();
	public List<AssetDTO> getAvailableAssetsByCategoryId(Long categoryId);
	public boolean deleteAssetById(Long assetId);
}
