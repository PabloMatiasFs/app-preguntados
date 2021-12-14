package com.microservice.source.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.source.entity.Pregunta;
import com.microservice.source.entity.Respuesta;
import com.microservice.source.entityDTO.RespuestaDTO;
import com.microservice.source.repository.PreguntaRepository;
import com.microservice.source.repository.RespuestaRepository;

@Service
@Transactional(readOnly= false)
public class RespuestaService {

	@Autowired
	public RespuestaRepository  respuestaRepository;
	
	@Autowired
	private PreguntaRepository  preguntaRepository;
	
	
	public Boolean crearRespuesta(RespuestaDTO respuestaDTO) {
		
		Pregunta pregunta  = preguntaRepository.getById(respuestaDTO.getPregunta());
		if(pregunta != null) {
			respuestaRepository.save(Respuesta.builder().estado(respuestaDTO.getEstado()).pregunta(pregunta).texto(respuestaDTO.getTexto()).build());
			return true;
		}else {
			return false;
		}
	}
	
	public Respuesta buscarRespuesta(Long id) {
		return respuestaRepository.existsById(id) != false ? respuestaRepository.getById(id): null;
	}
	
	public List<Respuesta> buscarAllRespuesta() {
		return respuestaRepository.findAll();
	}

}
