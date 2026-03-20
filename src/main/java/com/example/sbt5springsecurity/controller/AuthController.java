package com.example.sbt5springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbt5springsecurity.entity.LoginDTO;
import com.example.sbt5springsecurity.entity.RegisterDTO;
import com.example.sbt5springsecurity.entity.Users;
import com.example.sbt5springsecurity.service.AuthService;
import com.example.sbt5springsecurity.service.JwtService;

@RestController
public class AuthController {
	
	@Autowired
	private AuthService authService;
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/register")
    public String register(@RequestBody RegisterDTO registerDto) {
		return authService.register(registerDto);
    }
	
	@PostMapping("/login")
	public String login(@RequestBody LoginDTO loginDto) {
		Users user = authService.login(loginDto);
		String token = jwtService.generateToken(user);
		return token;
	}
	
	

}
