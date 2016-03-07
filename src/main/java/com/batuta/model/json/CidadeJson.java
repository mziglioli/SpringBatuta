package com.batuta.model.json;

import java.io.Serializable;

public class CidadeJson implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long cidadeId;
	private EstadoJson estado;
	private String nome;
	private String ddd;

	public CidadeJson() {
	}

	public CidadeJson(Long id, EstadoJson estado, String nome, String ddd) {
		super();
		this.cidadeId = id;
		this.estado = estado;
		this.nome = nome;
		this.ddd = ddd;
	}

	public void setCidadeId(Long cidadeId) {
		this.cidadeId = cidadeId;
	}

	public Long getCidadeId() {
		return cidadeId;
	}

	public EstadoJson getEstado() {
		return estado;
	}

	public void setEstado(EstadoJson estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

}