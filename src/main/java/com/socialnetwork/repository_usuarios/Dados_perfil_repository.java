package com.socialnetwork.repository_usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialnetwork.model_usuarios.Dados_perfil;

@Repository
public interface Dados_perfil_repository extends JpaRepository<Dados_perfil, Long>{

}
