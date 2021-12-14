package com.microservice.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.source.entity.Pregunta;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long>{

}
