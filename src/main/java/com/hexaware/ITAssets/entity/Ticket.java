package com.hexaware.ITAssets.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {

	public enum status{
		IN_PROCESS,
		RESOLVED,
		REJECTED
	}
	
	public enum tickettype{
		ISSUE,
		RETURN,
		REPAIR,
		LICENCE
	}
	
	@Id
	@Column(name="ticket_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long TicketId;
	
	@Column(name="problem_description")
	private String problemDescription;
	
	
	@Column(name="ticket_status")
	@Enumerated(EnumType.STRING)
	private status ticketStatus;
	
	@ManyToOne
	@JoinColumn(name = "employee_id", referencedColumnName="employee_id")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="asset_id",referencedColumnName="asset_id")
	private Asset asset;
	
	@Column(name="ticket_type")
	@Enumerated(EnumType.STRING)
	private tickettype ticketType;

	public Long getTicketId() {
		return TicketId;
	}

	public void setTicketId(Long ticketId) {
		TicketId = ticketId;
	}

	public String getProblemDescription() {
		return problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public status getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(status ticketStatus) {
		this.ticketStatus = ticketStatus;
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

	public tickettype getTicketType() {
		return ticketType;
	}

	public void setTicketType(tickettype ticketType) {
		this.ticketType = ticketType;
	}

	public Ticket(Long ticketId, String problemDescription, status ticketStatus, Employee employee, Asset asset,
			tickettype ticketType) {
		super();
		TicketId = ticketId;
		this.problemDescription = problemDescription;
		this.ticketStatus = ticketStatus;
		this.employee = employee;
		this.asset = asset;
		this.ticketType = ticketType;
	}

	public Ticket() {
		super();
	}

	@Override
	public String toString() {
		return "Ticket [TicketId=" + TicketId + ", problemDescription=" + problemDescription + ", ticketStatus="
				+ ticketStatus + ", employee=" + employee + ", asset=" + asset + ", ticketType=" + ticketType + "]";
	}

	
	
	
	

}