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

import com.microservice.source.entity.Categoria;
import com.microservice.source.entityDTO.CategoriaDTO;
import com.microservice.source.service.CategoriaService;



@RestController
@RequestMapping("categoria")
public class RestCategoria {
	
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/{id}")
    public ResponseEntity<String> getPregunta(@PathVariable Long id) {
		
		Categoria categoria = categoriaService.buscarCategoria(id);
		if(categoria != null)
			return ResponseEntity.status(200).body(""+categoria);
		else 
			return ResponseEntity.status(404).body("NO SE ENCONTRO LA CATEGORIA CORRESPONDIENTE AL ID INDICADO");
    }
	
	@PostMapping("/newcategoria")
	public ResponseEntity<String> CreatePregunta(@RequestBody CategoriaDTO categoriaDTO) {
		return ResponseEntity.status(201).body("LA CATEGORIA FUE CREADA CON EXITO" + categoriaService.crearCategoria(categoriaDTO));
	}
	
	@GetMapping("/allc")
	public List<Categoria> allPregunta() {
		return categoriaService.buscarAllCategoria();
	}

}

