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
	
	private Employee employee;
	
	private Asset asset;

	public tickettype getTicketType() {
		return ticketType;
	}

	public void setTicketType(tickettype ticketType) {
		this.ticketType = ticketType;
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

	public TicketDTO() {
		super();
	}
	
	public TicketDTO(tickettype ticketType, Employee employee, Asset asset) {
		super();
		this.ticketType = ticketType;
		this.employee = employee;
		this.asset = asset;
	}

	

	@Override
	public String toString() {
		return "TicketDTO [ticketType=" + ticketType + ", employee=" + employee + ", asset=" + asset + "]";
	}

	

	
	
	

}