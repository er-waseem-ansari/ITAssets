package com.hexaware.ITAssets.service;


import com.hexaware.ITAssets.entity.Ticket;

public interface TicketService {

	public Ticket createTicket(Ticket ticket);

	public String approveTicket(Long ticketId);

	public String returnTicket(Long ticketId);
	
}