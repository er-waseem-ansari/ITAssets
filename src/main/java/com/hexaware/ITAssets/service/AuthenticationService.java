package com.hexaware.ITAssets.service;

import com.hexaware.ITAssets.dto.LoginRequestDTO;
import com.hexaware.ITAssets.dto.LoginResponseDTO;
import com.hexaware.ITAssets.entity.Employee;

public interface AuthenticationService {
	LoginResponseDTO signup(Employee employee);
	
	LoginResponseDTO signin(LoginRequestDTO loginRequestDTO);
}
