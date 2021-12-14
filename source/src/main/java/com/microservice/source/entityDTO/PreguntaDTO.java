package com.microservice.source.entityDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PreguntaDTO {

	public Long id;
	public String enunciado;
	public Long categoria;
}
