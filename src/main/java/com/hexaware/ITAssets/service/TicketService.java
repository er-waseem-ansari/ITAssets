package com.hexaware.ITAssets.service;


import java.util.List;

import com.hexaware.ITAssets.Exception.TicketNotFoundException;
import com.hexaware.ITAssets.entity.Ticket;

public interface TicketService {

	public Ticket createTicket(Ticket ticket);

	public String approveTicket(Long ticketId)throws TicketNotFoundException;

	public List<Ticket> getTicketsByStatus(String status);

	public List<Ticket> getTicketsByEmployeeId(Long employeeId);

	
}