package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model.DadosPerfil;
import com.socialnetwork.repository.DadosPerfilRepository;


@RestController
@RequestMapping ("/dados_perfil")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class DadosPerfilController {

	@Autowired
	private DadosPerfilRepository dados_perfil_repository;
	
	@GetMapping
	public ResponseEntity<List<DadosPerfil>> getAll(){
		return ResponseEntity.ok(dados_perfil_repository.findAll());
	}
}
