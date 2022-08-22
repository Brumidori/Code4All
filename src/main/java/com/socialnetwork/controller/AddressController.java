package com.socialnetwork.controller;

import java.util.List;

import com.socialnetwork.model.Address;
import com.socialnetwork.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adress")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AddressController {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@GetMapping
	public ResponseEntity<List<Address>>getAll(){
		return ResponseEntity.ok(addressRepository.findAll());
	}
}
