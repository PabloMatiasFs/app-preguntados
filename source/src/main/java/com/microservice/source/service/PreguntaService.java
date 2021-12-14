package com.microservice.source.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.source.entity.Categoria;
import com.microservice.source.entity.Pregunta;
import com.microservice.source.entityDTO.PreguntaDTO;
import com.microservice.source.repository.CategoriaRepository;
import com.microservice.source.repository.PreguntaRepository;

@Service
@Transactional(readOnly= false)
public class PreguntaService {

	@Autowired
	private PreguntaRepository  preguntaRepository;
	
	@Autowired
	private CategoriaRepository  categoriaRepository;
	
	
	public Boolean crearPregunta(PreguntaDTO preguntaDTO) {
		
		Categoria categoria  = categoriaRepository.getById(preguntaDTO.getCategoria());
		if(categoria != null) {
			preguntaRepository.save(Pregunta.builder().enunciado(preguntaDTO.getEnunciado()).categoria(categoria).build());
			return true;
		}else {
			return false;
		}
	}
	
	public Pregunta buscarPregunta(Long id) {
		return preguntaRepository.existsById(id) != false ? preguntaRepository.getById(id): null;
	}
	
	public List<Pregunta> buscarAllPregunta() {
		return preguntaRepository.findAll();
	}
}
