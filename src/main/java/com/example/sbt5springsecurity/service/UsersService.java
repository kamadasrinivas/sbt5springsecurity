package com.example.sbt5springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sbt5springsecurity.entity.Users;
import com.example.sbt5springsecurity.repository.UserRepository;

@Service
public class UsersService {
	
	
	@Autowired
	private UserRepository repo;
	
	public List<Users> getAllUsers() {
		return repo.findAll();
	}
	
	public Users getUserByEmail(String email) {
		return repo.findByEmail(email);
	}

}
