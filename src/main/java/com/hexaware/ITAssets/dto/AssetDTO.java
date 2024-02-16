package com.hexaware.ITAssets.dto;

public class AssetDTO {
	private Long assetId;
	private String model;
	public AssetDTO() {
		super();
	}
	public AssetDTO(Long assetId, String model) {
		super();
		this.assetId = assetId;
		this.model = model;
	}
	public Long getAssetId() {
		return assetId;
	}
	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "AssetDTO [assetId=" + assetId + ", model=" + model + "]";
	}
	
	
}
