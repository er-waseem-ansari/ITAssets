package com.hexaware.ITAssets.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ITAssets.dto.LoginRequestDTO;
import com.hexaware.ITAssets.dto.LoginResponseDTO;
import com.hexaware.ITAssets.entity.Employee;
import com.hexaware.ITAssets.service.AuthenticationService;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	@Autowired
	private AuthenticationService authenticationService;
	
    @PostMapping("/signup")
    public ResponseEntity<LoginResponseDTO> signup(@RequestBody Employee employee) {
        return ResponseEntity.ok(authenticationService.signup(employee));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> signin(@RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(authenticationService.signin(loginRequestDTO));
    }
    
    @PostMapping("/check")
    public String checking() {
    	return "Check successful";
    }
}
