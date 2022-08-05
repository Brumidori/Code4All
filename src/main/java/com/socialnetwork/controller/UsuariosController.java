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

import com.socialnetwork.model.Usuarios;
import com.socialnetwork.repository.UsuariosRepository;


@RestController
@RequestMapping ("/usuarios")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class UsuariosController {

	@Autowired
	private UsuariosRepository usuarios_repository;
	
	@GetMapping
	public ResponseEntity<List<Usuarios>> getAll(){
		return ResponseEntity.ok(usuarios_repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuarios> getById(@PathVariable Long id){
		return usuarios_repository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuarios>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(usuarios_repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<List<Usuarios>> getByCpf(@PathVariable String cpf){
		return ResponseEntity.ok(usuarios_repository.findAllByCpfContainingIgnoreCase(cpf));
	}
	
	@PostMapping
	public ResponseEntity<Usuarios> post(@Valid @RequestBody Usuarios usuarios){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarios_repository.save(usuarios));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuarios> put(@PathVariable Long id, @Valid @RequestBody Usuarios usuarios){
		return usuarios_repository.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK)
				.body(usuarios_repository.save(usuarios))).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); 
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Usuarios> usuarios = usuarios_repository.findById(id);
		
		if(usuarios.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		usuarios_repository.deleteById(id);
	}

}

