package com.hexaware.ITAssets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.ITAssets.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
