package com.hexaware.ITAssets.dto;

import com.hexaware.ITAssets.entity.Asset;
import com.hexaware.ITAssets.entity.Employee;

public class TicketDTO {
	
	public enum tickettype{
		ISSUE,
		RETURN,
		REPAIR,
		LICENCE
	}
	
	private tickettype ticketType;
	
	private String problemDescription;
	
	private Employee employee;
	
	private Asset asset;

	public tickettype getTicketType() {
		return ticketType;
	}

	public void setTicketType(tickettype ticketType) {
		this.ticketType = ticketType;
	}

	public String getProblemDescription() {
		return problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
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

	public TicketDTO(tickettype ticketType, String problemDescription, Employee employee, Asset asset) {
		super();
		this.ticketType = ticketType;
		this.problemDescription = problemDescription;
		this.employee = employee;
		this.asset = asset;
	}

	@Override
	public String toString() {
		return "TicketDTO [ticketType=" + ticketType + ", problemDescription=" + problemDescription + ", employee="
				+ employee + ", asset=" + asset + "]";
	}

	public TicketDTO() {
		super();
	}

	
	
	

}