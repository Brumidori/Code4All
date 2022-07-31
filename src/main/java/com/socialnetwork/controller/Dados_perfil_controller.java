package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model_usuarios.Dados_perfil;
import com.socialnetwork.repository_usuarios.Dados_perfil_repository;


@RestController
@RequestMapping ("/dados_perfil")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class Dados_perfil_controller {

	@Autowired
	private Dados_perfil_repository dados_perfil_repository;
	
	@GetMapping
	public ResponseEntity<List<Dados_perfil>> getAll(){
		return ResponseEntity.ok(dados_perfil_repository.findAll());
	}
}
