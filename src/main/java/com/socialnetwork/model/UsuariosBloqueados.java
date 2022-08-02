package com.socialnetwork.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_usuarios_bloqueados")
public class UsuariosBloqueados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_solicitou_bloqueio;
	
	@UpdateTimestamp 
	@NonNull
	private LocalDateTime data_bloqueio;
	
	@Size(min = 10, max = 100)
	private String descricao_bloqueio;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuarios_bloqueados")
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	private Usuarios usuario;

	public Long getId_solicitou_bloqueio() {
		return id_solicitou_bloqueio;
	}

	public void setId_solicitou_bloqueio(Long id_solicitou_bloqueio) {
		this.id_solicitou_bloqueio = id_solicitou_bloqueio;
	}

	public LocalDateTime getData_bloqueio() {
		return data_bloqueio;
	}

	public void setData_bloqueio(LocalDateTime data_bloqueio) {
		this.data_bloqueio = data_bloqueio;
	}

	public String getDescricao_bloqueio() {
		return descricao_bloqueio;
	}

	public void setDescricao_bloqueio(String descricao_bloqueio) {
		this.descricao_bloqueio = descricao_bloqueio;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	
	
}
