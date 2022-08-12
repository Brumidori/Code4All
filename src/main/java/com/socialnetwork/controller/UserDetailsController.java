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

import com.socialnetwork.model.UserDetails;
import com.socialnetwork.repository.UserDetailsRepository;


@RestController
@RequestMapping ("/userDetails")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class UserDetailsController {

	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@GetMapping
	public ResponseEntity<List<UserDetails>> getAll(){
		return ResponseEntity.ok(userDetailsRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDetails> getById(@PathVariable Long id){
		return userDetailsRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<UserDetails>> getByNome(@PathVariable String name){
		return ResponseEntity.ok(userDetailsRepository.findAllByNameContainingIgnoreCase(name));
	}
	
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<List<UserDetails>> getByCpf(@PathVariable String document){
		return ResponseEntity.ok(userDetailsRepository.findAllByDocumentContainingIgnoreCase(document));
	}
	
	@PostMapping
	public ResponseEntity<UserDetails> post(@Valid @RequestBody UserDetails userDetails){
		return ResponseEntity.status(HttpStatus.CREATED).body(userDetailsRepository.save(userDetails));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDetails> put(@PathVariable Long id, @Valid @RequestBody UserDetails userDetails){
		return userDetailsRepository.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK)
				.body(userDetailsRepository.save(userDetails)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); 
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<UserDetails> usuarios = userDetailsRepository.findById(id);
		
		if(usuarios.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		userDetailsRepository.deleteById(id);
	}

}

