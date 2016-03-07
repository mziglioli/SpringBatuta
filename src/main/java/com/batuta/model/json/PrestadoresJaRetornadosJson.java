package com.batuta.model.json;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe responsável para gerenciar os prestadores que ja forma retornados nas
 * consultas da url (/prestadoresByCategoria/{id}/{ddd}/{me})
 * */
public class PrestadoresJaRetornadosJson implements Serializable {

	private static final long serialVersionUID = 1L;
	private MeFacebook me;
	private Set<Long> prestadores;

	public PrestadoresJaRetornadosJson() {
		prestadores = new HashSet<Long>();
	}

	public void setMe(MeFacebook me) {
		this.me = me;
	}
	
	public void setPrestadores(Set<Long> prestadores) {
		this.prestadores = prestadores;
	}
	
	public MeFacebook getMe() {
		return me;
	}

	public Set<Long> getPrestadores() {
		return prestadores;
	}
	
	@Override
    public String toString() {
        return "PrestadoresJaRetornadosJson{" +
                "me=" + me +
                ", prestadores=" + prestadores +
                '}';
    }

}