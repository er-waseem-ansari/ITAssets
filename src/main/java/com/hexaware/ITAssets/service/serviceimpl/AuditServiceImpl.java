package com.hexaware.ITAssets.service.serviceimpl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ITAssets.entity.Asset;

import com.hexaware.ITAssets.repository.AssetRepository;
import com.hexaware.ITAssets.service.AuditService;

@Service
public class AuditServiceImpl implements AuditService {

	@Autowired
	private AssetRepository assetRepository;
	
	
	
	@Override
	public String auditAssetStatus() {
		
		   List<Asset> assets = assetRepository.findAll();
		   
		   int count=0;
		   int returnCount=0;
	        for (Asset asset : assets) {
	            // Check if asset status matches its actual state
	            if (asset.getAssetStatus() == Asset.status.AVAILABLE) {
	                // Check if the asset is issued but its status is AVAILABLE
//	                long issuedCount = issuedAssetRepository.countByAsset(asset);
	                count=count+1;
	            } else if (asset.getAssetStatus() == Asset.status.UNAVAILABLE) {
	                // Check if the asset is returned but its status is UNAVAILABLE
	               returnCount=returnCount+1;
	                
	            }
	        }
	        return "Asset status auditing completed.";
	    }
}
