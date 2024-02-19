package com.hexaware.ITAssets.service.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ITAssets.entity.Category;
import com.hexaware.ITAssets.repository.CategoryRepository;
import com.hexaware.ITAssets.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {

	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public Category addCategory(Category category) {
		logger.info("category added successfully");
		return categoryRepository.save(category);
	}

}
