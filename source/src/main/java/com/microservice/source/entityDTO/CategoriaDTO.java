package com.microservice.source.entityDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CategoriaDTO {

	public Long id;
	public String nombre;
	public String descripcion;
	
}
