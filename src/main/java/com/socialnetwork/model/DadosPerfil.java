package com.socialnetwork.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table (name = "tb_dados_perfil")
public class DadosPerfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id_dados_perfil;
	
	@Size(min = 5, max = 255)
	private String apelido;
	
	@Size(min = 5, max = 255)
	private String foto_perfil;
	
	@Size(min = 5, max = 1000)
	private String dados_bio;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	private Usuarios usuario;

	public long getId_dados_perfil() {
		return id_dados_perfil;
	}

	public void setId_dados_perfil(long id_dados_perfil) {
		this.id_dados_perfil = id_dados_perfil;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getFoto_perfil() {
		return foto_perfil;
	}

	public void setFoto_perfil(String foto_perfil) {
		this.foto_perfil = foto_perfil;
	}

	public String getDados_bio() {
		return dados_bio;
	}

	public void setDados_bio(String dados_bio) {
		this.dados_bio = dados_bio;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	
	
	
}
