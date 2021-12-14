package com.microservice.source.entityDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class RespuestaDTO {
	
	private Long id;
	public String texto;
	public Boolean estado;
	public Long pregunta;

}
