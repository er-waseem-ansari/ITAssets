package com.hexaware.ITAssets.service.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ITAssets.entity.Asset;
import com.hexaware.ITAssets.entity.AssetRequest;
import com.hexaware.ITAssets.entity.Employee;
import com.hexaware.ITAssets.entity.IssuedAsset;
import com.hexaware.ITAssets.entity.ReturnedAsset;
import com.hexaware.ITAssets.repository.AssetRequestRepository;
import com.hexaware.ITAssets.service.AssetRequestService;
import com.hexaware.ITAssets.service.IssuedAssetService;
import com.hexaware.ITAssets.service.ReturnedAssetService;

@Service
public class AssetRequestServiceImpl implements AssetRequestService {

	@Autowired
	private AssetRequestRepository assetRequestRepository;

	@Autowired
	private IssuedAssetService issuedAssetService;
	
	@Autowired
	private ReturnedAssetService returnedAssetService;
	
	@Override
	public AssetRequest addAssetRequest(AssetRequest assetRequest) {
		return assetRequestRepository.save(assetRequest);
	}
	

	@Override
	public String approveAssetRequest(Long requestId) {
		String message = "Something went wrong!";
		
		Optional<AssetRequest> assetRequest = assetRequestRepository.findById(requestId);
		Asset asset = assetRequest.get().getAsset();
		Employee employee = assetRequest.get().getEmployee();
		
		if(assetRequest.get().getRequestType() == AssetRequest.type.ISSUE) {
			IssuedAsset issuedAsset = new IssuedAsset();
			issuedAsset.setEmployee(employee);
			issuedAsset.setAsset(asset);
			issuedAssetService.addToIssuedAsset(issuedAsset);
			message= "Asset issued!";
		}
		else {
			ReturnedAsset returnedAsset = new ReturnedAsset();

//			issuedAssetService.removeByAssetId(asset.getAssetId());
			
			returnedAsset.setAsset(asset);
			returnedAsset.setEmployee(employee);
			returnedAsset.setIssueDate(assetRequest.get().getRequestDate());  // to be update this cloumn later
			returnedAssetService.addToReturnedAssets(returnedAsset);
			
			message= "Asset returned!";
		}
		
		
		if(message!="Something went wrong!") {
			assetRequestRepository.deleteById(requestId);
		}
		
		return message;
		
		
	}

}
