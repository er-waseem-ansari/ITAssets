package com.hexaware.ITAssets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ITAssets.entity.Ticket;
import com.hexaware.ITAssets.service.TicketService;

@RestController
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/raise-ticket")
	public Ticket createTicket(@RequestBody Ticket ticket) {
	
		System.out.println(ticket);
		return ticketService.createTicket(ticket);
	}
	
	@GetMapping("/raise-ticket/check")
	public String check() {
		return "Working";
	}
	
	@PostMapping("/approveTicket")
	public String approveTicket(@RequestParam Long ticketId)
	{
		return ticketService.approveTicket(ticketId);
		
	}
	@PostMapping("/returnAsset")
	public String returnTicket(@RequestParam Long ticketId)
	{
		ticketService.returnTicket(ticketId);
		return "s";
	}
}
