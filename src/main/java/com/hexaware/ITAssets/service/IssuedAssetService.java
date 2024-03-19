package com.hexaware.ITAssets.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hexaware.ITAssets.entity.IssuedAsset;

public interface IssuedAssetService {
	public IssuedAsset addToIssuedAsset(IssuedAsset issuedAsset);

	public List<IssuedAsset> getIssuedAssetByEmployeeId(Long employeeId);

	public List<IssuedAsset> getAllIssuedAsset();
}
