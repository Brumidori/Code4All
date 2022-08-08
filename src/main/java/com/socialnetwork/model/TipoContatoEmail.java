package com.socialnetwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_tipo_contato_email")

public class TipoContatoEmail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_tipo_contato;
	
	@NotBlank
	@Size(min = 5, max = 500)
	private String contato_email_descricao;
	
	@OneToOne
	@JoinColumn(name = "contato_email")
	private ContatoEmail ContatoEmail;

	public long getId_tipo_contato() {
		return id_tipo_contato;
	}

	public void setId_tipo_contato(long id_tipo_contato) {
		this.id_tipo_contato = id_tipo_contato;
	}

	public String getContato_email_descricao() {
		return contato_email_descricao;
	}

	public void setContato_email_descricao(String contato_email_descricao) {
		this.contato_email_descricao = contato_email_descricao;
	}

	public ContatoEmail getContatoEmail() {
		return ContatoEmail;
	}

	public void setContatoEmail(ContatoEmail contatoEmail) {
		ContatoEmail = contatoEmail;
	}
	

}

