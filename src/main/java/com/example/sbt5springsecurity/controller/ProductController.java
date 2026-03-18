package com.example.sbt5springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@RequestMapping("/products")
	public String getProducts() {
		return "List of products";
	}

}
