package com.batuta.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.batuta.service.PrestadorService;

@Component
public class PrestadorConverter {
	
	@Autowired
	private PrestadorService prestadorService;
	
	public boolean isPrestador(Long id){
		return prestadorService.isPrestador(id);
	}
}
