package com.microservice.source.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.source.entity.Pregunta;
import com.microservice.source.entityDTO.PreguntaDTO;
import com.microservice.source.service.PreguntaService;

@RestController
@RequestMapping("preguntas")
public class RestPreguntas {
	
	@Autowired
	private PreguntaService  preguntaService;

	@GetMapping("/{id}")
    public ResponseEntity<String> getPregunta(@PathVariable Long id) {
		
		Pregunta pregunta = preguntaService.buscarPregunta(id);
		if(pregunta != null)
			return ResponseEntity.status(200).body(""+pregunta);
		else 
			return ResponseEntity.status(404).body("NO SE ENCONTRO LA PREGUNTA CORRESPONDIENTE AL ID INDICADO");
    }
	
	@PostMapping("/newpregunta")
	public ResponseEntity<String> CreatePregunta(@RequestBody PreguntaDTO preguntaDTO) {
		if(preguntaService.crearPregunta(preguntaDTO))
			return ResponseEntity.status(201).body("LA PREGUNTA FUE CREADA CON EXITO");
		else
			return ResponseEntity.status(404).body("LA PREGUNTA NO SE PUDO CREAR, EL ID DE LA CATEGORIA INGRESADA NO SE ENCUENTRA");
	}
	
	@GetMapping("/allp")
	public List<Pregunta> allPregunta() {
		return preguntaService.buscarAllPregunta();
	}

}
