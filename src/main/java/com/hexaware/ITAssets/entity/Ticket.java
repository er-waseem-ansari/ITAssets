package com.hexaware.ITAssets.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@Table(name="tickets")
public class Ticket {
	
	enum status{
		IN_PROCESS,
		RESOLVED,
		REJECTED
	}
	
	@Id
	@Column(name="ticket_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long TicketId;
	
	@Column(name="problem_description")
	private String problemDescription;
	
	@Column(name="ticket_status")
	private status ticketStatus;
	
	@ManyToOne
	@JoinColumn(name = "employee_id", referencedColumnName="employee_id")
	private Employee employee;

	public Ticket() {
		super();
	}

	public Ticket(Long ticketId, String problemDescription, status ticketStatus, Employee employee) {
		super();
		TicketId = ticketId;
		this.problemDescription = problemDescription;
		this.ticketStatus = ticketStatus;
		this.employee = employee;
	}

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

	@Override
	public String toString() {
		return "Ticket [TicketId=" + TicketId + ", problemDescription=" + problemDescription + ", ticketStatus="
				+ ticketStatus + ", employee=" + employee + "]";
	}
}
