package com.socialnetwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_seguindo")

public class Seguindo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_seguindo;
	
	@OneToOne
	private long relacionar_dois_usuarios;
	private long id_usuario1;
	
	@ManyToOne
	@JoinColumn(name = "usuarios")
	private Usuarios usuarios;

	public long getId_seguindo() {
		return id_seguindo;
	}

	public void setId_seguindo(long id_seguindo) {
		this.id_seguindo = id_seguindo;
	}

	public long getRelacionar_dois_usuarios() {
		return relacionar_dois_usuarios;
	}

	public void setRelacionar_dois_usuarios(long relacionar_dois_usuarios) {
		this.relacionar_dois_usuarios = relacionar_dois_usuarios;
	}

	public long getId_usuario1() {
		return id_usuario1;
	}

	public void setId_usuario1(long id_usuario1) {
		this.id_usuario1 = id_usuario1;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	
	
}

