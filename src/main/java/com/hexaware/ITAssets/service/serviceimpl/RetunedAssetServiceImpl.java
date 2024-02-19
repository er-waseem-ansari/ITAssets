package com.hexaware.ITAssets.service.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ITAssets.entity.ReturnedAsset;
import com.hexaware.ITAssets.repository.ReturnedAssetRepository;
import com.hexaware.ITAssets.service.ReturnedAssetService;
@Service
public class RetunedAssetServiceImpl implements ReturnedAssetService {
	
	private static final Logger logger = LoggerFactory.getLogger(IssuedAssetServiceImpl.class);

	@Autowired
	private ReturnedAssetRepository returnedAssetRepository;
	@Override
	public ReturnedAsset addToReturnedAssets(ReturnedAsset returnedAsset) {
		logger.info("asset has been returned successfully");
		return returnedAssetRepository.save(returnedAsset);
	}

}
