package com.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialnetwork.model.Comentario;


public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
