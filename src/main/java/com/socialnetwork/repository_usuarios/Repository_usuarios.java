package com.socialnetwork.repository_usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialnetwork.model_usuarios.Usuarios;

@Repository
public interface Repository_usuarios extends JpaRepository <Usuarios, Long>{

}
