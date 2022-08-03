package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model.Estado;
import com.socialnetwork.repository.EstadoRepository;

@RestController
@RequestMapping("/estado")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping
	public ResponseEntity<List<Estado>>getAll(){
		return ResponseEntity.ok(estadoRepository.findAll());
	}

}
