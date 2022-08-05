package com.socialnetwork.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuariosBloqueados> getById(@PathVariable Long id) {
		return usuariosBloqueadosRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PostMapping
	public ResponseEntity<UsuariosBloqueados> post(@Valid @RequestBody UsuariosBloqueados usuariosbloqueados){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuariosBloqueadosRepository.save(usuariosbloqueados));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuariosBloqueados> put(@PathVariable Long id, @Valid @RequestBody UsuariosBloqueados usuariosbloqueados){
		return usuariosBloqueadosRepository.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK)
				.body(usuariosBloqueadosRepository.save(usuariosbloqueados))).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); 
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<UsuariosBloqueados> usuarios = usuariosBloqueadosRepository.findById(id);
		
		if(usuarios.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		usuariosBloqueadosRepository.deleteById(id);
	}
}
