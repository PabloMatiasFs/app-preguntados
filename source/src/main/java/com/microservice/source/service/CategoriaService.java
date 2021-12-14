package com.microservice.source.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.source.entity.Categoria;
import com.microservice.source.entityDTO.CategoriaDTO;
import com.microservice.source.repository.CategoriaRepository;

@Service
@Transactional(readOnly= false)
public class CategoriaService {

	@Autowired
	public CategoriaRepository  categoriaRepository;
	
	
	public Categoria crearCategoria(CategoriaDTO categoriaDTO) {
		Categoria categoria = Categoria.builder().descripcion(categoriaDTO.getDescripcion()).nombre(categoriaDTO.getNombre()).build();
		return categoriaRepository.save(categoria);
	}
	
	public Categoria buscarCategoria(Long id) {
		return categoriaRepository.existsById(id) != false ? categoriaRepository.getById(id): null;
	}
	
	public List<Categoria> buscarAllCategoria() {
		return categoriaRepository.findAll();
	}
}

