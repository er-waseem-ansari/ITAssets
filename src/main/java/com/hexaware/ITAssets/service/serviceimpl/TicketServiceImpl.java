package com.hexaware.ITAssets.service.serviceimpl;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ITAssets.entity.Asset;
import com.hexaware.ITAssets.entity.Employee;
import com.hexaware.ITAssets.entity.IssuedAsset;
import com.hexaware.ITAssets.entity.ReturnedAsset;
import com.hexaware.ITAssets.entity.Ticket;
import com.hexaware.ITAssets.repository.IssuedAssetRepository;
import com.hexaware.ITAssets.repository.ReturnedAssetRepository;
import com.hexaware.ITAssets.repository.TicketRepository;
import com.hexaware.ITAssets.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private IssuedAssetRepository issuedAssetRepository;
	
	@Autowired
	private ReturnedAssetRepository returnedAssetRepository;
	
	@Override
	public Ticket createTicket(Ticket ticket) {
		ticket.setTicketStatus(Ticket.status.IN_PROCESS);
		return ticketRepository.save(ticket);
	}

	@Override
	public String approveTicket(Long ticketId) {
		
		String s="";
		
		Optional<Ticket> ticket=ticketRepository.findById(ticketId); // Exception to be added later

//		if(ticket.get().getTicketStatus()!=Ticket.status.IN_PROCESS)
////		{
////			s="ticket already approve OR Rejected"; // Exception to be added later
////			return s;
////		}
		
		Employee employee=ticket.get().getEmployee();
		
		Asset asset=ticket.get().getAsset();

		
		IssuedAsset issuedAsset= new IssuedAsset();
		issuedAsset.setAsset(asset);
		issuedAsset.setEmployee(employee);
		
		
		ticket.get().setTicketStatus(Ticket.status.RESOLVED);
		ticketRepository.save(ticket.get());
		issuedAssetRepository.save(issuedAsset);
		s="ticket has been approved and asset has been issued";
		return s;
		//shshjduuejf
	}

	@Override
	public String returnTicket(Long ticketId) {
		// TODO Auto-generated method stub
		Optional<Ticket> ticket=ticketRepository.findById(ticketId);
		String s="";
		if(ticket.get().getTicketStatus()!=Ticket.status.IN_PROCESS)
		{
			return "ticket has been approved or rejected";
		}
		
		
		Optional<IssuedAsset>issuedAsset=issuedAssetRepository.findById(ticket.get().getAsset().getAssetId());
		
		System.out.println(issuedAsset.get());
		
		ReturnedAsset returnAsset=new ReturnedAsset();
		
		returnAsset.setAsset(issuedAsset.get().getAsset());
		returnAsset.setEmployee(issuedAsset.get().getEmployee());
		returnAsset.setIssueDate(issuedAsset.get().getIssueDate());
		returnAsset.setReturnDate(LocalDateTime.now());
		
		ticket.get().setTicketStatus(Ticket.status.RESOLVED);
//		ticketRepository.save(ticket.get());
		
		returnedAssetRepository.save(returnAsset);
		
		issuedAssetRepository.delete(issuedAsset.get());
		
	
		return "return ticket has been approved";
	}
	
//	private boolean issueTicket(Long ticketId) {
//		
//	}

}
