package com.hexaware.ITAssets.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name="issued_assets")
public class IssuedAsset {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "issued_assets_id")
	private Long issuedAssetsid;
	@CreationTimestamp
	@Column(name = "issue_date")
	private LocalDateTime issueDate;
	
	@OneToOne
	@JoinColumn(name = "asset_id", referencedColumnName = "asset_id" )
	private Asset asset;
	
	@ManyToOne
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
	private Employee employee;

	public IssuedAsset() {
		super();
	}

	public IssuedAsset(Long issuedAssetsid, LocalDateTime issueDate, Asset asset, Employee employee) {
		super();
		this.issuedAssetsid = issuedAssetsid;
		this.issueDate = issueDate;
		this.asset = asset;
		this.employee = employee;
	}

	public Long getIssuedAssetsid() {
		return issuedAssetsid;
	}

	public void setIssuedAssetsid(Long issuedAssetsid) {
		this.issuedAssetsid = issuedAssetsid;
	}

	public LocalDateTime getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDateTime issueDate) {
		this.issueDate = issueDate;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "IssuedAsset [issuedAssetsid=" + issuedAssetsid + ", issueDate=" + issueDate + ", asset=" + asset
				+ ", employee=" + employee + "]";
	}
	
	
	
}
