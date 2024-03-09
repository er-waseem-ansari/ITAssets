package com.hexaware.ITAssets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ITAssets.entity.Category;
import com.hexaware.ITAssets.service.AssetService;
import com.hexaware.ITAssets.service.CategoryService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
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
	
	@PostMapping("/create")
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		
		return ResponseEntity.ok().body(categoryService.addCategory(category));
	}
	
	@GetMapping("/getcategory")
	public ResponseEntity<List<Category>> getAllCategory()
	{
		return ResponseEntity.ok().body(categoryService.getAllCategory());
	}
	
	
	
}
