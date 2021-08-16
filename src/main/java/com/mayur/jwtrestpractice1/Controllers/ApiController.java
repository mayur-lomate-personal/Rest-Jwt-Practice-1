package com.mayur.jwtrestpractice1.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mayur.jwtrestpractice1.Entities.RestUser;
import com.mayur.jwtrestpractice1.Payloads.JwtRequest;
import com.mayur.jwtrestpractice1.Payloads.JwtResponse;
import com.mayur.jwtrestpractice1.Services.JwtTokenUtil;
import com.mayur.jwtrestpractice1.Services.MyUserDetailsService;
import com.mayur.jwtrestpractice1.Services.RestUserService;

@RestController
public class ApiController {
	
	@Autowired
	RestUserService restUserService;
	
	@Autowired
	UserDetailsService myUserDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/api/admin")
	public String adminMessage() {
		return "This is Admin";
	}
	
	
	@GetMapping("/api/user")
	@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
	public String userMessage() {
		return "This is User";
	}
	
	@PostMapping("/api/jwt")
	public JwtResponse getJwt(@Valid @RequestBody JwtRequest jwtRequest) {
		restUserService.authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		//final UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
		return new JwtResponse(jwtTokenUtil.generateTokenUsingUsername(jwtRequest.getUsername()));
	}
	
	@PostMapping("/api/register/user")
	public String registerUser(@Valid @RequestBody RestUser restUser) {
		restUserService.saveUser(restUser);
		return "User Registered Sucessfully";
	}
}
