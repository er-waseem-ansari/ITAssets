package com.hexaware.ITAssets.service.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ITAssets.entity.IssuedAsset;
import com.hexaware.ITAssets.repository.IssuedAssetRepository;
import com.hexaware.ITAssets.service.IssuedAssetService;

@Service
public class IssuedAssetServiceImpl implements IssuedAssetService {
	
	private static final Logger logger = LoggerFactory.getLogger(IssuedAssetServiceImpl.class);
	
	@Autowired
	private IssuedAssetRepository issuedAssetRepository;

	@Override
	public IssuedAsset addToIssuedAsset(IssuedAsset issuedAsset) {
		logger.info("asset has been issued successfully");
		return issuedAssetRepository.save(issuedAsset);
	}


}
