package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model.UsuariosBloqueados;
import com.socialnetwork.repository.UsuariosBLoqueadosRepository;

@RestController
@RequestMapping ("/usuariosbloqueados")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuariosBloqueadosController {

	@Autowired
	private UsuariosBLoqueadosRepository usuariosBloqueadosRepository;
	
	@GetMapping
	public ResponseEntity<List<UsuariosBloqueados>> getAll(){
		return ResponseEntity.ok(usuariosBloqueadosRepository.findAll());
	}
}
