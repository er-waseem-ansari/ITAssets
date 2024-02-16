package com.hexaware.ITAssets.service;


import java.util.List;

import com.hexaware.ITAssets.entity.Ticket;

public interface TicketService {

	public Ticket createTicket(Ticket ticket);

	public String approveTicket(Long ticketId);

	public List<Ticket> getTicketsByStatus(String status);

	
}