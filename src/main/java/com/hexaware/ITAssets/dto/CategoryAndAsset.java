package com.hexaware.ITAssets.dto;

import com.hexaware.ITAssets.entity.Asset;
import com.hexaware.ITAssets.entity.Category;

public class CategoryAndAsset {
	private Category category;
	private Asset asset;
	public CategoryAndAsset() {
		super();
	}
	public CategoryAndAsset(Category category, Asset asset) {
		super();
		this.category = category;
		this.asset = asset;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Asset getAsset() {
		return asset;
	}
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	
}
