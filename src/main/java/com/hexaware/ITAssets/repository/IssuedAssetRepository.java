package com.hexaware.ITAssets.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.ITAssets.entity.IssuedAsset;

@Repository
public interface IssuedAssetRepository extends JpaRepository<IssuedAsset, Long> {
	
	@Query(value="SELECT * FROM issued_assets WHERE "+
			"asset_id = :assetId", nativeQuery = true)
	public Optional<IssuedAsset> findByAssetId(Long assetId);
}
