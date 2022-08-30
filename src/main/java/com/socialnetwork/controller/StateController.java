package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model.State;
import com.socialnetwork.repository.StateRepository;

@RestController
@RequestMapping("/state")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StateController {
	
	@Autowired
	private StateRepository stateRepository;
	
	@GetMapping
	public ResponseEntity<List<State>>getAll(){
		return ResponseEntity.ok(stateRepository.findAll());
	}

}
