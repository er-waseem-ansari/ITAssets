package com.hexaware.ITAssets.service.serviceimpl;
import java.time.LocalDateTime;
import java.util.List;
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
	
		String message = "Something went wrong!";
		Optional<Ticket> ticket=ticketRepository.findById(ticketId); // Exception to be added later
		
		
		Employee employee=ticket.get().getEmployee();
		
		Asset asset=ticket.get().getAsset();
		System.out.println(asset.getAssetId());
		if(ticket.get().getTicketType()== Ticket.tickettype.ISSUE) {
			IssuedAsset issuedAsset= new IssuedAsset();
			issuedAsset.setAsset(asset);
			issuedAsset.setEmployee(employee);
			
			
			ticketRepository.updateTicketStatus(ticket.get().getTicketId(), "RESOLVED");
			issuedAssetRepository.save(issuedAsset);
			message = "ticket has been approved and asset has been issued";
			
		}
		
		else if (ticket.get().getTicketType()== Ticket.tickettype.RETURN) {
			
			Optional<IssuedAsset>issuedAsset = issuedAssetRepository.findByAssetId(asset.getAssetId());
			if(issuedAsset.isEmpty()) {
				System.out.println("Asset not issued!");
			}
			else {
				ReturnedAsset returnedAsset=new ReturnedAsset();
				returnedAsset.setAsset(issuedAsset.get().getAsset());
				returnedAsset.setEmployee(issuedAsset.get().getEmployee());
				returnedAsset.setIssueDate(issuedAsset.get().getIssueDate());
				
				returnedAssetRepository.save(returnedAsset);
				issuedAssetRepository.deleteById(issuedAsset.get().getIssuedAssetsid());
				ticketRepository.updateTicketStatus(ticket.get().getTicketId(), "RESOLVED");
				
				message = "return ticket has been approved";
			}
		}
		
		return message;
	}

	@Override
	public List<Ticket> getTicketsByStatus(String status) {
		// TODO Auto-generated method stub
		 List<Ticket> tickets = ticketRepository.findByStatus(status);
		return tickets;
	}

}
