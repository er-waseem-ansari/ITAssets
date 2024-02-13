package com.hexaware.ITAssets.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ITAssets.entity.ReturnedAsset;
import com.hexaware.ITAssets.repository.ReturnedAssetRepository;
import com.hexaware.ITAssets.service.ReturnedAssetService;
@Service
public class RetunedAssetServiceImpl implements ReturnedAssetService {

	@Autowired
	private ReturnedAssetRepository returnedAssetRepository;
	@Override
	public ReturnedAsset addToReturnedAssets(ReturnedAsset returnedAsset) {
		return returnedAssetRepository.save(returnedAsset);
	}

}
