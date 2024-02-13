package com.hexaware.ITAssets.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ITAssets.entity.IssuedAsset;
import com.hexaware.ITAssets.repository.IssuedAssetRepository;
import com.hexaware.ITAssets.service.IssuedAssetService;

@Service
public class IssuedAssetServiceImpl implements IssuedAssetService {
	
	@Autowired
	private IssuedAssetRepository issuedAssetRepository;

	@Override
	public IssuedAsset addToIssuedAsset(IssuedAsset issuedAsset) {
		return issuedAssetRepository.save(issuedAsset);
	}


}
