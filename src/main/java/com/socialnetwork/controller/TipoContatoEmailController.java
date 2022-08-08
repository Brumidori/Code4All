package com.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.model.TipoContatoEmail;
import com.socialnetwork.repository.TipoContatoEmailRepository;

@RestController
@RequestMapping ("/tipoContatoEmail")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class TipoContatoEmailController {

	@Autowired
	private TipoContatoEmailRepository tipoContatoEmailRepository;
	
	@GetMapping
	public ResponseEntity<List<TipoContatoEmail>> getAll(){
		return ResponseEntity.ok(tipoContatoEmailRepository.findAll());
	}
}
