package com.hexaware.ITAssets.service;

import java.util.List;

import com.hexaware.ITAssets.entity.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);

	public List<Category> getAllCategory();
}
