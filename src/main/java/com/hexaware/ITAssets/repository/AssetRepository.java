package com.hexaware.ITAssets.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.ITAssets.entity.Asset;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
	
	@Query(value="SELECT * FROM assets", nativeQuery = true)
	public List<Asset>getTotalAssets();
	
	@Query(value="SELECT * FROM assets WHERE asset_status= 'available'", nativeQuery = true)
	public List<Asset>getAvailableAssets();
	
	@Query(value="SELECT * FROM assets WHERE asset_status= 'available' AND category_id= :categoryId", nativeQuery = true)
	public List<Asset> getAvailableAssetsByCategoryId(Long categoryId);

	@Modifying
	@Query(value="UPDATE assets SET asset_status= :status WHERE asset_id= :assetId",nativeQuery=true)
	public void updateAssetStatusByAssetId(Long assetId, String status);
}
