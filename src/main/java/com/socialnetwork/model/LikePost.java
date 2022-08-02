package com.socialnetwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_like_post")
public class LikePost {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@ManyToOne
@JsonIgnoreProperties("likePost")
private Post post;

@ManyToOne
@JsonIgnoreProperties("likePost")
private Usuarios usuarios;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public Post getPost() {
	return post;
}

public void setPost(Post post) {
	this.post = post;
}

public Usuarios getUsuarios() {
	return usuarios;
}

public void setUsuarios(Usuarios usuarios) {
	this.usuarios = usuarios;
}


}
