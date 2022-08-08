package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model.Seguindo;
import com.socialnetwork.repository.SeguindoRepository;

@RestController
@RequestMapping ("/seguindo")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class SeguindoController {
	
	@Autowired
	private SeguindoRepository seguindoRepository;
	
	@GetMapping
	public ResponseEntity<List<Seguindo>> getAll(){
		return ResponseEntity.ok(seguindoRepository .findAll());
	}

}
