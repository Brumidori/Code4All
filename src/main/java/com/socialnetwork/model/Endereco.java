package com.socialnetwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_endereco;
		
	@NotNull
	private Long nr_endereco;
	
	@NotBlank
	@Size(min = 1, max = 20, message = "Complemento deve ter no mínimo 1 e no máximo 20 caracteres.")
	private String complemento;
	
	@ManyToOne
	@JsonIgnoreProperties ("Endereco")
	private Usuarios usuarios;
	
	@ManyToOne
	@JsonIgnoreProperties ("Endereco")
	private TipoLogradouro tipoLogradouro;
	
	@ManyToOne
	@JsonIgnoreProperties ("Endereco")
	private Bairro bairro;

	
	public Long getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(Long id_endereco) {
		this.id_endereco = id_endereco;
	}

	public Long getNr_endereco() {
		return nr_endereco;
	}

	public void setNr_endereco(Long nr_endereco) {
		this.nr_endereco = nr_endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

}
