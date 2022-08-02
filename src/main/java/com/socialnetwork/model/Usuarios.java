package com.socialnetwork.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_usuarios")
public class Usuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id_usuario;
	
	@NotBlank(message = "O CPF é Obrigatório!") 
	@Size(min = 11, max = 11, message = "O CPF deve conter 11 digitos.")
	private long cpf;
	
	@NotBlank(message = "O nome é Obrigatório!") 
	@Size(min = 5, max = 100)
	private String nome;
	
	@NotBlank(message = "O e-mail é Obrigatório!") 
	@Size(min = 5, max = 100)
	private String email;
	
	@UpdateTimestamp
	private LocalDateTime cadastro;
	
	@NotBlank(message = "A data de nascimento é Obrigatória!") 
	@Size(min = 8, max = 8)
	private Date dt_nasc;
	
	@NotBlank
	private boolean ong;
	
	@NotBlank
	private boolean ativo;
	
	@NotBlank(message = "O nome de usuário é Obrigatório!") 
	private String nome_usuario;
	
	@NotBlank(message = "A senha é Obrigatória!") 
	@Size(min = 6, max = 10, message = "A senha deve conter no mínimo 6 e no máximo 10 digitos.")
	private String senha;
	
	@OneToOne(mappedBy = "usuario")
	private DadosPerfil dados_perfil;
	

	public long getId() {
		return id_usuario;
	}

	public void setId(long id) {
		this.id_usuario = id;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getCadastro() {
		return cadastro;
	}

	public void setCadastro(LocalDateTime cadastro) {
		this.cadastro = cadastro;
	}

	public Date getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(Date dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	public boolean isOng() {
		return ong;
	}

	public void setOng(boolean ong) {
		this.ong = ong;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public DadosPerfil getDados_perfil() {
		return dados_perfil;
	}

	public void setDados_perfil(DadosPerfil dados_perfil) {
		this.dados_perfil = dados_perfil;
	}

	
	
}