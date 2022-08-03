package com.socialnetwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_bairro")
public class Bairro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_bairro;
	
	@NotBlank
	@Size(min = 1, max = 255)
	private String nome_bairro;
	
	@ManyToOne
	@JsonIgnoreProperties("Bairro")
	private Cidade cidade;


}
