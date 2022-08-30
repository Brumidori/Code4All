package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model.District;
import com.socialnetwork.repository.DistrictRepository;

@RestController
@RequestMapping("/district")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DistrictController {

	@Autowired
	private DistrictRepository districtRepository;
	
	@GetMapping
	public ResponseEntity<List<District>>getAll(){
		return ResponseEntity.ok(districtRepository.findAll());
	}
}
