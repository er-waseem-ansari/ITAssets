package com.hexaware.ITAssets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.ITAssets.entity.ReturnedAsset;

@Repository
public interface ReturnedAssetRepository extends JpaRepository<ReturnedAsset, Long> {
	
}
