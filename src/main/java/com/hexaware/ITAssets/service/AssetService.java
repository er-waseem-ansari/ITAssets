package com.hexaware.ITAssets.service;

import com.hexaware.ITAssets.entity.Asset;

public interface AssetService {
	public Asset addAsset(Asset asset);
	public Asset getAssetById(Long assetId);
}
