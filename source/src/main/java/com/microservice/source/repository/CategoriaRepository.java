package com.microservice.source.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.source.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

}
