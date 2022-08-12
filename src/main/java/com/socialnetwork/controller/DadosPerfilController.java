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

import com.socialnetwork.model.DadosPerfil;
import com.socialnetwork.repository.ProfileDataRepository;

@RestController
@RequestMapping("/dados_perfil")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DadosPerfilController {

	@Autowired
	private ProfileDataRepository dados_perfil_repository;

	@GetMapping
	public ResponseEntity<List<DadosPerfil>> getAll() {
		return ResponseEntity.ok(dados_perfil_repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<DadosPerfil> getById(@PathVariable Long id) {
		return dados_perfil_repository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/apelido/{apelido}")
	public ResponseEntity<List<DadosPerfil>> getByApelido(@PathVariable String apelido) {
		return ResponseEntity.ok(dados_perfil_repository.findAllByApelidoContainingIgnoreCase(apelido));
	}

	@PostMapping
	public ResponseEntity<DadosPerfil> post(@Valid @RequestBody DadosPerfil dadosperfil) {
		return ResponseEntity.status(HttpStatus.CREATED).body(dados_perfil_repository.save(dadosperfil));
	}

	@PutMapping("/{id}")
	public ResponseEntity<DadosPerfil> put(@PathVariable Long id, @Valid @RequestBody DadosPerfil dadosperfil) {
		return dados_perfil_repository.findById(id)
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(dados_perfil_repository.save(dadosperfil)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<DadosPerfil> dadosperfil = dados_perfil_repository.findById(id);

		if (dadosperfil.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		dados_perfil_repository.deleteById(id);
	}

}
