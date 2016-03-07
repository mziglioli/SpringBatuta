package com.batuta.service;

import org.springframework.stereotype.Service;

import com.batuta.model.Prestador;
import com.batuta.repository.PrestadorRepository;

@Service
public class PrestadorService extends ServiceDefault<Prestador, PrestadorRepository> {

	public boolean isPrestador(Long id){
		Prestador p = getRepository().findByUserId(id);
		if(p != null){
			return true;
		}
		return false;
	}
}
