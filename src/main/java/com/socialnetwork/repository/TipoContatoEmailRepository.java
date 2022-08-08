package com.socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialnetwork.model.TipoContatoEmail;

@Repository
public interface TipoContatoEmailRepository extends JpaRepository<TipoContatoEmail, Long> {

}
