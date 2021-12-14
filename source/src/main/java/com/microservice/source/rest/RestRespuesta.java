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

import com.microservice.source.entity.Respuesta;
import com.microservice.source.entityDTO.RespuestaDTO;
import com.microservice.source.service.RespuestaService;



@RestController
@RequestMapping("respuesta")
public class RestRespuesta {

	@Autowired
	private RespuestaService RespuestaService;

	@GetMapping("/{id}")
    public ResponseEntity<String> getRespuesta(@PathVariable Long id) {
		Respuesta respuesta = RespuestaService.buscarRespuesta(id);
		if(respuesta != null)
			return ResponseEntity.status(200).body(""+respuesta);
		else 
			return ResponseEntity.status(404).body("NO SE ENCONTRO LA RESPUESTA CORRESPONDIENTE AL ID INDICADO");
    }
	
	@PostMapping("/newrespuesta")
	public ResponseEntity<String> CreateRespuesta(@RequestBody RespuestaDTO respuestaDTO) {
		if(RespuestaService.crearRespuesta(respuestaDTO))
			return ResponseEntity.status(201).body("LA RESPUESTA FUE CREADA CON EXITO");
		else
			return ResponseEntity.status(404).body("LA RESPUESTA NO SE PUDO CREAR, EL ID DE LA PREGUNTA INGRESADA NO SE ENCUENTRA");
	}
	
	@GetMapping("/allr")
	public List<Respuesta> allRespuesta() {
		return RespuestaService.buscarAllRespuesta();
	}
}
