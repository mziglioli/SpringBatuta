package com.batuta.model.json;

import java.util.List;

public class Estados {

	private List<EstadoJson> estados;
	
	public Estados() {
		// TODO Auto-generated constructor stub
	}
	public List<EstadoJson> getEstados() {
		return estados;
	}
	public void setEstados(List<EstadoJson> estados) {
		this.estados = estados;
	}
	@Override
	public String toString() {
		return "Estados [estados=" + estados + "]";
	}
	
	
}
