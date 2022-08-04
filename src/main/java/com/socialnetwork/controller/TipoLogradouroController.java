package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model.TipoLogradouro;
import com.socialnetwork.repository.TipoLogradouroRepository;

@RestController
@RequestMapping("/logradouro")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TipoLogradouroController {

	@Autowired
	private TipoLogradouroRepository tipoLogradouroRepository;
	
	@GetMapping
	public ResponseEntity<List<TipoLogradouro>>getAll(){
		return ResponseEntity.ok(tipoLogradouroRepository.findAll());
	}
}
