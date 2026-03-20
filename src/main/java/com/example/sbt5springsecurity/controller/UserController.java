package com.example.sbt5springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbt5springsecurity.entity.Users;
import com.example.sbt5springsecurity.service.UsersService;

@RestController
public class UserController {
	
	
	@Autowired
	private UsersService usersService;
	
	@GetMapping("/hello")
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public String user() {
		return "Hello user";
	}
	
	
	@GetMapping("/users/all")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Users> getAllUsers() {
		return usersService.getAllUsers();
	}

}
