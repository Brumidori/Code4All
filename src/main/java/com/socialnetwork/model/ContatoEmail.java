package com.socialnetwork.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tb_contato_email")

public class ContatoEmail {
	
	@UpdateTimestamp
	@NotNull(message = "A data é obrigatória!")
	private LocalDateTime data_envio_email;
	
	@NotNull
	private LocalDateTime prazo_max_confirmacao;
	
	@NotNull
	@UpdateTimestamp
	private LocalDateTime data_confirmacao;
	
	private long id_tipo_contato;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_usuario;
	
	@OneToOne
	@JoinColumn(name = "tipo_contato_email")
	private TipoContatoEmail tipoContatoEmail;
	
	
	public LocalDateTime getData_envio_email() {
		return data_envio_email;
	}
	public void setData_envio_email(LocalDateTime data_envio_email) {
		this.data_envio_email = data_envio_email;
	}
	public LocalDateTime getPrazo_max_confirmacao() {
		return prazo_max_confirmacao;
	}
	public void setPrazo_max_confirmacao(LocalDateTime prazo_max_confirmacao) {
		this.prazo_max_confirmacao = prazo_max_confirmacao;
	}
	public LocalDateTime getData_confirmacao() {
		return data_confirmacao;
	}
	public void setData_confirmacao(LocalDateTime data_confirmacao) {
		this.data_confirmacao = data_confirmacao;
	}
	public long getId_tipo_contato() {
		return id_tipo_contato;
	}
	public void setId_tipo_contato(long id_tipo_contato) {
		this.id_tipo_contato = id_tipo_contato;
	}
	public long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public TipoContatoEmail getTipoContatoEmail() {
		return tipoContatoEmail;
	}
	public void setTipoContatoEmail(TipoContatoEmail tipoContatoEmail) {
		this.tipoContatoEmail = tipoContatoEmail;
	}
	
		}