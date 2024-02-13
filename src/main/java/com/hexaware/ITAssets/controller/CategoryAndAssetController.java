package com.hexaware.ITAssets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ITAssets.dto.CategoryAndAsset;
import com.hexaware.ITAssets.entity.Asset;
import com.hexaware.ITAssets.entity.Category;
import com.hexaware.ITAssets.service.AssetService;
import com.hexaware.ITAssets.service.CategoryService;

@RestController
@RequestMapping("/it-assets/api/asset")
public class CategoryAndAssetController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private AssetService assetService;
	
	
//	{
//		  "category": {
//		    "categoryId": 12,
//		    "categoryName": "Desktop",
//		    "quantity": 10,
//		    "categoryType": "HARDWARE"
//		  },
//		  "asset": {
//		    "assetId": 1,
//		    "model": "Lenovo",
//		    "description": "Low-performance laptop",
//		    "image": "https://example.com/dell-latitude.jpg"
//		  }
//		}
	
	@PostMapping("/add-asset")
	public void addAssetWithCategory(@RequestBody CategoryAndAsset categoryAndAsset) {
		
		Category category =categoryService.addCategory(categoryAndAsset.getCategory());
		Asset asset = categoryAndAsset.getAsset();
		asset.setCategory(category);
		assetService.addAsset(categoryAndAsset.getAsset());
		
	}
}
