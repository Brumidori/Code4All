package com.socialnetwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_estado")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_estado;
	
	@NotBlank
	@Size (min = 3, max = 255)
	private String nome_estado;
	@NotBlank
	@Size (min = 2, max = 2)
	private String sigla_estado;
	
	
	public long getId_estado() {
		return id_estado;
	}
	public void setId_estado(long id_estado) {
		this.id_estado = id_estado;
	}
	public String getNome_estado() {
		return nome_estado;
	}
	public void setNome_estado(String nome_estado) {
		this.nome_estado = nome_estado;
	}
	public String getSigla_estado() {
		return sigla_estado;
	}
	public void setSigla_estado(String sigla_estado) {
		this.sigla_estado = sigla_estado;
	}
	
}
