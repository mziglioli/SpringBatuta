package com.batuta.model.json;

import java.io.Serializable;

public class MeusChats implements Serializable {
	private static final long serialVersionUID = 1L;

	private String prestadorId;
	private String prestadorNome;
	private String ultimoContato;
	private String outrasCategoriasPrestador;

	public MeusChats() {
	}

	public MeusChats(String prestadorId, String prestadorNome, String ultimoContato, String outrasCategoriasPrestador) {
		super();
		this.prestadorId = prestadorId;
		this.prestadorNome = prestadorNome;
		this.ultimoContato = ultimoContato;
		this.outrasCategoriasPrestador = outrasCategoriasPrestador;
	}

	public String getPrestadorId() {
		return prestadorId;
	}

	public void setPrestadorId(String prestadorId) {
		this.prestadorId = prestadorId;
	}

	public String getPrestadorNome() {
		return prestadorNome;
	}

	public void setPrestadorNome(String prestadorNome) {
		this.prestadorNome = prestadorNome;
	}

	public String getUltimoContato() {
		return ultimoContato;
	}

	public void setUltimoContato(String ultimoContato) {
		this.ultimoContato = ultimoContato;
	}

	public String getOutrasCategoriasPrestador() {
		return outrasCategoriasPrestador;
	}

	public void setOutrasCategoriasPrestador(String outrasCategoriasPrestador) {
		this.outrasCategoriasPrestador = outrasCategoriasPrestador;
	}

	@Override
	public String toString() {
		return "MeusChatsDto [prestadorId=" + prestadorId + ", prestadorNome=" + prestadorNome + ", ultimoContato="
				+ ultimoContato + ", outrasCategoriasPrestador=" + outrasCategoriasPrestador + "]";
	}
}
