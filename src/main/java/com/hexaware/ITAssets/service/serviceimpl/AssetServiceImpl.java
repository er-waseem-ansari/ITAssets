package com.hexaware.ITAssets.service.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ITAssets.entity.Asset;
import com.hexaware.ITAssets.repository.AssetRepository;
import com.hexaware.ITAssets.service.AssetService;

@Service
public class AssetServiceImpl implements AssetService {
	@Autowired
	private AssetRepository assetRepository;

	@Override
	public Asset addAsset(Asset asset) {
		return assetRepository.save(asset);
	}

	@Override
	public Asset getAssetById(Long assetId) {
		Asset asset = null;
		Optional<Asset> _asset = assetRepository.findById(assetId);
		if(_asset.isPresent()) {
			asset = _asset.get();		
			}
		return asset;
	}
	
	
	

}
