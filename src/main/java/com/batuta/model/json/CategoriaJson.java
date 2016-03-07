package com.batuta.model.json;

import java.io.Serializable;

/**
 * The persistent class for the categoria database table.
 * 
 */
public class CategoriaJson implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long categoriaId;
	private String nome;
	private CategoriaJson parent;
    private String indexacao;
    private String icone;
	
	public CategoriaJson() {
		// TODO Auto-generated constructor stub
	}
	
	public CategoriaJson(Long categoriaId, String nome, CategoriaJson parent,String icone) {
		super();
		this.categoriaId = categoriaId;
		this.nome = nome;
		this.parent = parent;
		this.icone = icone;
	}

    public CategoriaJson(Long categoriaId, String nome, CategoriaJson parent, String indexacao, String icone) {
        this.categoriaId = categoriaId;
        this.nome = nome;
        this.parent = parent;
        this.indexacao = indexacao;
        this.icone = icone;
    }

    public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CategoriaJson getParent() {
		return parent;
	}

	public void setParent(CategoriaJson parent) {
		this.parent = parent;
	}

    public void setIndexacao(String indexacao) {
        this.indexacao = indexacao;
    }

    public String getIndexacao() {
        return indexacao;
    }
    
    public String getIcone() {
		return icone;
	}
    public void setIcone(String icone) {
		this.icone = icone;
	}

    @Override
    public String toString() {
        return "Categoria{" +
                "categoriaId=" + categoriaId +
                ", nome='" + nome + '\'' +
                ", parent=" + parent +
                ", indexacao='" + indexacao + '\'' +
                '}';
    }
	
}