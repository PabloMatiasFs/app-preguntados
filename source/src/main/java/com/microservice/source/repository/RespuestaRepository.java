package com.microservice.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.source.entity.Respuesta;

@Transactional
public interface RespuestaRepository extends JpaRepository<Respuesta, Long>{

}
