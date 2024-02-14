package com.hexaware.ITAssets.service.serviceimpl;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ITAssets.entity.Asset;
import com.hexaware.ITAssets.entity.Employee;
import com.hexaware.ITAssets.entity.IssuedAsset;
import com.hexaware.ITAssets.entity.Ticket;
import com.hexaware.ITAssets.repository.IssuedAssetRepository;
import com.hexaware.ITAssets.repository.TicketRepository;
import com.hexaware.ITAssets.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private IssuedAssetRepository issuedAssetRepository;
	
	@Override
	public Ticket createTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public String approveTicket(Long ticketId) {
		
		String s="";
		
		Optional<Ticket> ticket=ticketRepository.findById(ticketId); // Exception to be added later

		if(ticket.get().getTicketStatus()!=Ticket.status.IN_PROCESS)
		{
			s="ticket already approve OR Rejected"; // Exception to be added later
			return s;
		}
		
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
	}
	
//	private boolean issueTicket(Long ticketId) {
//		
//	}

}
