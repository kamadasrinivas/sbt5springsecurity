package com.example.sbt5springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.sbt5springsecurity.entity.LoginDTO;
import com.example.sbt5springsecurity.entity.RegisterDTO;
import com.example.sbt5springsecurity.entity.Users;
import com.example.sbt5springsecurity.repository.UserRepository;

@Service	
public class AuthService {
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	public String register(RegisterDTO input) {
		
		Users newUser = new Users();
		newUser.setName(input.getName());
		newUser.setEmail(input.getEmail());
		newUser.setPassword(encoder.encode(input.getPassword()));
		newUser.setRole(input.getRole());
		
		repo.save(newUser);
		
		return "User registered successfully";
		
	}
	
	public Users login(LoginDTO input) {
		Users user = repo.findByEmail(input.getEmail());

		if (user != null && encoder.matches(input.getPassword(), user.getPassword())) {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(
							input.getEmail(), input.getPassword()));
			return user;
		}

		return null;
	}
	
	

}
