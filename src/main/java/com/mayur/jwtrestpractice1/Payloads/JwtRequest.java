package com.mayur.jwtrestpractice1.Payloads;

import javax.validation.constraints.NotBlank;

public class JwtRequest {
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	
	public JwtRequest() {
		
	}
	
	public JwtRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
