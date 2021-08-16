package com.mayur.jwtrestpractice1.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mayur.jwtrestpractice1.Entities.MyUserDetails;
import com.mayur.jwtrestpractice1.Entities.RestUser;
import com.mayur.jwtrestpractice1.Repositories.RestUserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private RestUserRepo restUserRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<RestUser> user = restUserRepo.findById(username);
		if(user.isPresent()) {
			return new MyUserDetails(user.get());
		}
		throw new UsernameNotFoundException("Username not Found");
	}

}
