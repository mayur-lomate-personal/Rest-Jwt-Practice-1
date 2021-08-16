package com.mayur.jwtrestpractice1.Payloads;

import java.io.Serializable;

public class JwtResponse implements Serializable {
	
	private String token;

	public JwtResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
}
