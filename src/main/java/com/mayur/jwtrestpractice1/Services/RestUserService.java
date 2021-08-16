package com.mayur.jwtrestpractice1.Services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mayur.jwtrestpractice1.Entities.RestUser;
import com.mayur.jwtrestpractice1.Repositories.RestUserRepo;

@Service
public class RestUserService {

	@Autowired
	private RestUserRepo restUserRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public void saveUser(RestUser restUser) {
		if(restUserRepo.existsById(restUser.getUsername())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already Exist.");
		}
		restUser.setPassword(encoder.encode(restUser.getPassword()));
		restUserRepo.save(restUser);
	}
	
	public void authenticate(String username, String password) {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "USER_DISABLED");
		} catch (BadCredentialsException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "INVALID_CREDENTIALS");
		}
	}
}
