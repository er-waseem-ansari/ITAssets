package com.hexaware.ITAssets.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.hexaware.ITAssets.entity.Ticket;


@Transactional
//@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
	
	@Modifying
	@Query(value="UPDATE tickets SET ticket_status = :status WHERE ticket_id = :ticketId", nativeQuery = true)
	void updateTicketStatus(Long ticketId, String status);

	List<Ticket> findByStatus(String status);
}
