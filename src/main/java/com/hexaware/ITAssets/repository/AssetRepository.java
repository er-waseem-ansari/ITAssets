package com.hexaware.ITAssets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.ITAssets.entity.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long> {

}
