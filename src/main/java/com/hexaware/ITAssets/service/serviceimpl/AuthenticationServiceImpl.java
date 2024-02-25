package com.hexaware.ITAssets.service.serviceimpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.ITAssets.dto.LoginRequestDTO;
import com.hexaware.ITAssets.dto.LoginResponseDTO;
import com.hexaware.ITAssets.entity.Employee;
import com.hexaware.ITAssets.repository.EmployeeRepository;
import com.hexaware.ITAssets.service.AuthenticationService;
import com.hexaware.ITAssets.service.JwtService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public LoginResponseDTO signup(Employee employee) {
		// TODO Auto-generated method stub
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		String jwtToken =  jwtService.generateToken(employeeRepository.save(employee));
		LoginResponseDTO response = new LoginResponseDTO(jwtToken, employee.getUsername());
		return response;
	}

	@Override
	public LoginResponseDTO signin(LoginRequestDTO loginRequestDTO) {
		// TODO Auto-generated method stub
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()));
		Optional<Employee> employeeOptional = employeeRepository.findByEmail(loginRequestDTO.getEmail());
		if(employeeOptional.isEmpty()) {
			throw new IllegalArgumentException("Invalid email or password");
		}
		String jwtToken = jwtService.generateToken(employeeOptional.get());
		LoginResponseDTO response = new LoginResponseDTO(jwtToken, employeeOptional.get().getUsername());
		return response;
	}

}
