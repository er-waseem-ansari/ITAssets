package com.hexaware.ITAssets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ITAssets.Exception.TicketNotFoundException;
import com.hexaware.ITAssets.entity.Ticket;
import com.hexaware.ITAssets.service.TicketService;

@RestController
@RequestMapping("/tickets")
@CrossOrigin("http://localhost:3000")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/raise")
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
	
		System.out.println(ticket);
		return ResponseEntity.ok().body(ticketService.createTicket(ticket));
	}
	
	
	@PostMapping("/approve/{ticketId}")
	public String approveTicket(@PathVariable Long ticketId) throws TicketNotFoundException
	{
		System.out.println("ticket id recieved: " + ticketId);
		return ticketService.approveTicket(ticketId);
		
	}
	
	@GetMapping("/status/{status}")
	public ResponseEntity<List<Ticket>> getTicketsByStatus(@PathVariable String status) 
	{
	    List<Ticket> tickets = ticketService.getTicketsByStatus(status);
	    return ResponseEntity.ok(tickets);
	}
	
	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<List<Ticket>> getTicketsByEmployeeId(@PathVariable Long employeeId) 
	{
		System.out.println("Inside get ticket by employee id and emp id is : " + employeeId);
	    List<Ticket> tickets = ticketService.getTicketsByEmployeeId(employeeId);
	    return ResponseEntity.ok(tickets);
	}
}
