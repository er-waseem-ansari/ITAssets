package com.hexaware.ITAssets.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	enum type {
		HARDWARE,
		SOFTWARE
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
	private Long categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="category_type")
	private type categoryType;

	public Category() {
		super();
	}

	public Category(Long categoryId, String categoryName, int quantity, type categoryType) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.quantity = quantity;
		this.categoryType = categoryType;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public type getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(type categoryType) {
		this.categoryType = categoryType;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", quantity=" + quantity
				+ ", categoryType=" + categoryType + "]";
	}
	
	
	
}
