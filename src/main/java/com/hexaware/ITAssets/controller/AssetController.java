package com.hexaware.ITAssets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ITAssets.dto.CategoryAndAsset;
import com.hexaware.ITAssets.entity.Asset;
import com.hexaware.ITAssets.entity.Category;
import com.hexaware.ITAssets.service.AssetService;
import com.hexaware.ITAssets.service.CategoryService;

@RestController
public class AssetController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private AssetService assetService;
	@PostMapping("/saveAsset")
	public Asset addAsset(@RequestBody CategoryAndAsset categoryandassetdto)
	{
		Asset asset=categoryandassetdto.getAsset();	
		Category category=categoryandassetdto.getCategory();
		Category savedCategory=categoryService.addCategory(category);
		asset.setCategory(savedCategory);
		return assetService.addAsset(asset);
	}
// this is a comment
}
//tejas1