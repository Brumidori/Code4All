package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model_usuarios.Usuarios;
import com.socialnetwork.repository_usuarios.Repository_usuarios;


@RestController
@RequestMapping ("/usuarios")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class Controller_usuarios {

	@Autowired
	private Repository_usuarios usuarios_repository;
	
	@GetMapping
	public ResponseEntity<List<Usuarios>> getAll(){
		return ResponseEntity.ok(usuarios_repository.findAll());
	}

}

