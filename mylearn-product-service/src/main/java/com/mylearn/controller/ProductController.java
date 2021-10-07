package com.mylearn.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mylearn.command.CreateProductCommand;
import com.mylearn.request.ProductCreateRequest;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private final Environment env;
	private final CommandGateway commandGateway;
	
	@Autowired
	public ProductController(Environment env, CommandGateway commandGateway) {
		super();
		this.env = env;
		this.commandGateway = commandGateway;
	}
	
	@PostMapping
	public String createProduct(@RequestBody ProductCreateRequest request) {
		
		CreateProductCommand command= CreateProductCommand.builder()
														.price(request.getPrice())
														.quantity(request.getQuantity())
														.title(request.getTitle())
														.productId(UUID.randomUUID().toString())
														.build();
		
		String returnValue =null;
		try {
			returnValue	= commandGateway.sendAndWait(command);	
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "HTTP POST Handled  "+request.getTitle();
	}
	@PutMapping
	public String updateProduct() {
		return "HTTP PUT Handled";
	}
	@GetMapping
	public String getProduct() {
		return "HTTP GET Handled";
	}
	@DeleteMapping
	public String deleteProduct() {
		return "HTTP DELETE Handled";
	}
}
