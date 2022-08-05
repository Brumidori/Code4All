package com.socialnetwork.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.socialnetwork.model.DadosPerfil;


public interface DadosPerfilRepository extends JpaRepository<DadosPerfil, Long>{
	public List<DadosPerfil> findAllByApelidoContainingIgnoreCase(@Param("apelido") String apelido);
}
