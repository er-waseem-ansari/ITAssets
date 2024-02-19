package com.hexaware.ITAssets.Repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.ITAssets.entity.Asset;
import com.hexaware.ITAssets.entity.Employee;
import com.hexaware.ITAssets.entity.Ticket;
import com.hexaware.ITAssets.repository.AssetRepository;
import com.hexaware.ITAssets.repository.EmployeeRepository;
import com.hexaware.ITAssets.repository.TicketRepository;

@SpringBootTest
public class CustomQueryTest {
	
	 
	 
	@Autowired
	private AssetRepository assetRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Test
	@Disabled
	void getAvailableAsset()
	{
		Long id=1L;
		List<Asset>assetList=assetRepository.getAvailableAssetsByCategoryId(id);
		System.out.println("available asset list: "+assetList);
		
		
	}
	
	@Test
	@Disabled
	void getEmployeeById()
	{
		Long id=2L;
		Optional<Employee> employee=employeeRepository.findById(id);
		
		Employee e=null;
		e=employee.get();
		System.out.println("Employee details are: "+e);
	}
	
	@Test
	@Disabled
	void getAllTickets()
	{
		List<Ticket>tickets=ticketRepository.findAll();
		
		System.out.println("list of tickets are: "+tickets);
	}

}
