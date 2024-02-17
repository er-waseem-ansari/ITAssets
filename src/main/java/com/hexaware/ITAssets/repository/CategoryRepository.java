package com.hexaware.ITAssets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hexaware.ITAssets.entity.Category;
@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {
	@Modifying
	@Query(value="UPDATE category "
	        + "SET total_quantity = total_quantity + :updateTotal, available_quantity = available_quantity + :updateAvailable "
	        + "WHERE category_id = :categoryId", nativeQuery = true)
	void updateCategoryQuantityById(Long categoryId, int updateAvailable, int updateTotal);

}
