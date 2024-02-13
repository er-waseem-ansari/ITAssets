package com.hexaware.ITAssets.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="asset_requests")
public class AssetRequest {
	
	public enum type{
		ISSUE,
		RETURN
	}
	
	@Id
	@Column(name="asset_request_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long assetRequestId;
	
	@Column(name="request_type")
	private type requestType;
	
	@Column(name="request_date")
	private LocalDateTime requestDate;
	
	@ManyToOne
	@JoinColumn(name = "employee_id", referencedColumnName="employee_id")
	private Employee employee;
	
	@OneToOne
	@JoinColumn(name="asset_id", referencedColumnName = "asset_id")
	private Asset asset;

	public AssetRequest() {
		super();
	}

	public AssetRequest(Long assetRequestId, type requestType, LocalDateTime requestDate, Employee employee,
			Asset asset) {
		super();
		this.assetRequestId = assetRequestId;
		this.requestType = requestType;
		this.requestDate = requestDate;
		this.employee = employee;
		this.asset = asset;
	}

	public Long getAssetRequestId() {
		return assetRequestId;
	}

	public void setAssetRequestId(Long assetRequestId) {
		this.assetRequestId = assetRequestId;
	}

	public type getRequestType() {
		return requestType;
	}

	public void setRequestType(type requestType) {
		this.requestType = requestType;
	}

	public LocalDateTime getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(LocalDateTime requestDate) {
		this.requestDate = requestDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	@Override
	public String toString() {
		return "AssetRequest [assetRequestId=" + assetRequestId + ", requestType=" + requestType + ", requestDate="
				+ requestDate + ", employee=" + employee + ", asset=" + asset + "]";
	}
	
	
}
