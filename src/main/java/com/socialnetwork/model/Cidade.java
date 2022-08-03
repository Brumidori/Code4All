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
@Table (name = "tb_cidade")
public class Cidade {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id_cidade;
	
	@NotBlank
	@Size (min = 5, max = 255)
	private String nome_cidade;
	
	@ManyToOne
	@JsonIgnoreProperties ("Cidade")
	private Estado estado;

	public long getId_cidade() {
		return id_cidade;
	}

	public void setId_cidade(long id_cidade) {
		this.id_cidade = id_cidade;
	}

	public String getNome_cidade() {
		return nome_cidade;
	}

	public void setNome_cidade(String nome_cidade) {
		this.nome_cidade = nome_cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	
}
