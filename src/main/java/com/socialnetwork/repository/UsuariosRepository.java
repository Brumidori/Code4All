package com.socialnetwork.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.socialnetwork.model.Usuarios;


public interface UsuariosRepository extends JpaRepository <Usuarios, Long>{
	public List<Usuarios> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
	public List<Usuarios> findAllByCpfContainingIgnoreCase(@Param("cpf") String cpf);
}
