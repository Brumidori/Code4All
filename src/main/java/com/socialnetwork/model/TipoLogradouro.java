package com.socialnetwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_logradouro")
public class TipoLogradouro {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id_tipo_logradouro;
	
	@JsonIgnoreProperties ("TipoLogradouro")
	private String descricao_logradouro;
	
	
	
	public long getCd_tipo_logradouro() {
		return id_tipo_logradouro;
	}

	public void setCd_tipo_logradouro(long cd_tipo_logradouro) {
		this.id_tipo_logradouro = cd_tipo_logradouro;
	}

	public String getDs_tipo_logradouro() {
		return descricao_logradouro;
	}

	public void setDs_tipo_logradouro(String ds_tipo_logradouro) {
		this.descricao_logradouro = ds_tipo_logradouro;
	}

	
}
