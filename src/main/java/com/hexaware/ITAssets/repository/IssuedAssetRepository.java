package com.hexaware.ITAssets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.ITAssets.entity.IssuedAsset;

@Repository
public interface IssuedAssetRepository extends JpaRepository<IssuedAsset, Long> {
	
	@Query("DELETE FROM IssuedAsset i WHERE i.assetId = ?1")

	public IssuedAsset removeByAssetId(Long assetId);
}
