package com.microservice.source.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app-rest")
public class RestInicio {
	
	@GetMapping("/inicio")
	public String Paginafunciona() {
		return "Funciono";
		
	}

}
