package com.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialnetwork.model.Seguindo;

@Repository
public interface SeguindoRepository extends JpaRepository<Seguindo, Long>{

}
