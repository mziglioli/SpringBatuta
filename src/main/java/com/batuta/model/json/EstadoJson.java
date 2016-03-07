package com.batuta.model.json;

import java.io.Serializable;
import java.util.List;

public class EstadoJson implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer estadoId;
	private String nome;
	private String sigla;
	private List<CidadeJson> cidades;

	public EstadoJson() {
		// TODO Auto-generated constructor stub
	}

	public EstadoJson(Integer id, String nome, String sigla,
			List<CidadeJson> cidades) {
		super();
		this.estadoId = id;
		this.nome = nome;
		this.sigla = sigla;
		this.cidades = cidades;
	}

	public EstadoJson(String nome, String sigla, List<CidadeJson> cidades) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.cidades = cidades;
	}

	public Integer getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<CidadeJson> getCidades() {
		return cidades;
	}

	public void setCidades(List<CidadeJson> cidades) {
		this.cidades = cidades;
	}

}