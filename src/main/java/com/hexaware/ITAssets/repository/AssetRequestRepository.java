package com.hexaware.ITAssets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.ITAssets.entity.AssetRequest;

@Repository
public interface AssetRequestRepository extends JpaRepository<AssetRequest, Long> {
	
}
