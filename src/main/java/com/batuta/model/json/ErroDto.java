package com.batuta.model.json;

import java.io.Serializable;

public class ErroDto implements Serializable {
	private static final long serialVersionUID = 1L;


	private String assunto;
	private String descricao;
	private Long createdBy;

	public ErroDto(String assunto, String descricao, Long createdBy) {
		super();
		this.assunto = assunto;
		this.descricao = descricao;
		this.createdBy = createdBy;
	}

	public ErroDto() {

	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "Erro [assunto=" + assunto + ", descricao=" + descricao
				+ ", createdBy=" + createdBy + "]";
	}	
}