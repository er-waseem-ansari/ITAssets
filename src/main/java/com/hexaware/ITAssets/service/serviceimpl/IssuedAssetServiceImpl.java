package com.hexaware.ITAssets.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	@Override
	public List<IssuedAsset> getIssuedAssetByEmployeeId(Long employeeId) {
		List<IssuedAsset> issueAssets=new ArrayList<>();
		// TODO Auto-generated method stub
		return issuedAssetRepository.findByEmployeeId(employeeId);
	}

	@Override
	public List<IssuedAsset> getAllIssuedAsset() {
		// TODO Auto-generated method stub
		List<IssuedAsset> assetIssued=new ArrayList<>();
		
		return issuedAssetRepository.findAll();
	}


}
