package com.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialnetwork.model.UsuariosBloqueados;

@Repository
public interface UsuariosBLoqueadosRepository extends JpaRepository<UsuariosBloqueados, Long>{

}
