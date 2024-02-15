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
@Table(name="returned_assets")
public class ReturnedAsset {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="returned_assets_id")
	private Long returnedAssetsId;
	
	@ManyToOne
	@JoinColumn(name = "asset_id", referencedColumnName = "asset_id")
	private Asset asset;
	
	@ManyToOne
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
	private Employee employee;
	
	@Column(name = "issue_date")
	private LocalDateTime issueDate;
	
	@CreationTimestamp
	@Column(name = "return_date")
	private LocalDateTime returnDate;
	
	@Column(name = "description")
	private String description;

	public ReturnedAsset() {
		super();
	}

	public ReturnedAsset(Long returnedAssetsId, Asset asset, Employee employee, LocalDateTime issueDate,
			LocalDateTime returnDate, String description) {
		super();
		this.returnedAssetsId = returnedAssetsId;
		this.asset = asset;
		this.employee = employee;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.description = description;
	}

	public Long getReturnedAssetsId() {
		return returnedAssetsId;
	}

	public void setReturnedAssetsId(Long returnedAssetsId) {
		this.returnedAssetsId = returnedAssetsId;
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

	public LocalDateTime getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDateTime issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ReturnedAsset [returnedAssetsId=" + returnedAssetsId + ", asset=" + asset + ", employee=" + employee
				+ ", issueDate=" + issueDate + ", returnDate=" + returnDate + ", description=" + description + "]";
	}
	
	
	
}
