package com.hexaware.ITAssets.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ITAssets.entity.Category;
import com.hexaware.ITAssets.repository.CategoryRepository;
import com.hexaware.ITAssets.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

}
