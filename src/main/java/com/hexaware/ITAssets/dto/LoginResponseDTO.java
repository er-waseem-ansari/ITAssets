package com.hexaware.ITAssets.dto;

import com.hexaware.ITAssets.entity.Role;

public class LoginResponseDTO {
	private String jwtToken;
	private String email;
	private Role role;
	public LoginResponseDTO() {
		super();
	}
	public LoginResponseDTO(String jwtToken, String email, Role role) {
		super();
		this.jwtToken = jwtToken;
		this.email = email;
		this.role = role;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public String getUsername() {
		return email;
	}
	public void setUsername(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "LoginResponseDTO [jwtToken=" + jwtToken + ", email=" + email + ", role=" + role + "]";
	}
	
	
	
}
