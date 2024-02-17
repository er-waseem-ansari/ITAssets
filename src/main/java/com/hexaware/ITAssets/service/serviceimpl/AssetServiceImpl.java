package com.hexaware.ITAssets.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ITAssets.dto.AssetDTO;
import com.hexaware.ITAssets.entity.Asset;
import com.hexaware.ITAssets.repository.AssetRepository;
import com.hexaware.ITAssets.repository.CategoryRepository;
import com.hexaware.ITAssets.service.AssetService;

@Service
public class AssetServiceImpl implements AssetService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AssetRepository assetRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Asset addAsset(Asset asset) {
		Asset savedAsset =  assetRepository.save(asset);
		categoryRepository.updateCategoryQuantityById(savedAsset.getCategory().getCategoryId(), 1, 1);
		return savedAsset;
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

	@Override
	public List<AssetDTO> getTotalAssets() {
		List<Asset> assetList = assetRepository.getTotalAssets();
		List<AssetDTO> assetDTOList = new ArrayList<AssetDTO>();
		for (Asset asset : assetList) 
		{ 
			assetDTOList.add(modelMapper.map(asset, AssetDTO.class));
		}
		return assetDTOList;
	}


	@Override
	public List<AssetDTO> getAvailableAssets() {
		List<Asset> assetList = assetRepository.getAvailableAssets();
		List<AssetDTO> assetDTOList = new ArrayList<AssetDTO>();
		for (Asset asset : assetList) 
		{ 
			assetDTOList.add(modelMapper.map(asset, AssetDTO.class));
		}
		return assetDTOList;
	}


	@Override
	public List<AssetDTO> getAvailableAssetsByCategoryId(Long categoryId) {
		List<Asset> assetList = assetRepository.getAvailableAssetsByCategoryId(categoryId);
		List<AssetDTO> assetDTOList = new ArrayList<AssetDTO>();
		for (Asset asset : assetList) 
		{ 
			assetDTOList.add(modelMapper.map(asset, AssetDTO.class));
		}
		return assetDTOList;
	}


	@Override
	public boolean deleteAssetById(Long assetId) {
		Optional<Asset> asset = assetRepository.findById(assetId);
		categoryRepository.updateCategoryQuantityById(asset.get().getCategory().getCategoryId(), -1, -1);
		assetRepository.deleteById(assetId);
		return true;
	}
	
	
	

}
