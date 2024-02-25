package com.hexaware.ITAssets.service.serviceimpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hexaware.ITAssets.entity.Employee;
import com.hexaware.ITAssets.repository.EmployeeRepository;

@Service
public class EmployeeDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Employee> employeeOptional = employeeRepository.findByEmail(username);
		
		if(employeeOptional.isEmpty()) {
			throw new UsernameNotFoundException("User not found with email: " + username);
		}
		Employee employee = employeeOptional.get();
		
//		return User.withUsername(employee.getEmail())
//                .password(employee.getPassword()) // Assuming getPassword returns the hashed password
//                .roles(employee.getRole().toString()) // Set user's roles here, if applicable
//                .accountExpired(false)
//                .accountLocked(false)
//                .credentialsExpired(false)
//                .disabled(false)
//                .build();
		return employee;
	}

}