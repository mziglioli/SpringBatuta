package com.batuta.model.json;

import java.io.Serializable;
import java.util.Date;

import com.batuta.model.Categoria;
import com.batuta.model.Prestador;
import com.batuta.model.User;

/**
 * The persistent class for the indicacao database table.
 * 
 */
public class IndicacaoJson implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	// private float preco;
	// private float qualidade;
	// private float tempo;
	// private float forma;
	// private float media;
	private Long categoria;
	private String categoriaNome;
	private Long prestador;
	private String prestadorNome;
	private Long prestadorUserId;
	private String status;
	private Long user;
	private String userNome;
	private Date data;

	public IndicacaoJson() {
		// TODO Auto-generated constructor stub
	}

	public IndicacaoJson(Long id, Categoria categoria,  Prestador prestador, String status, User user, Date data) {
		super();
		this.categoria = categoria.getCategoriaId();
		this.categoriaNome = categoria.getNome();
		this.prestador = prestador.getId();
		this.prestadorNome = prestador.getNome();
		this.prestadorUserId = prestador.getUserId();
		this.status = status;
		this.user = user.getId();
		this.userNome = user.getNome();
		this.data = data;
	}

	public IndicacaoJson(Long categoria, String categoriaNome, Long prestador, String prestadorNome, Long prestadorUserId, String status, Long user, String userNome, Date data) {
		super();
		this.categoria = categoria;
		this.categoriaNome = categoriaNome;
		this.prestador = prestador;
		this.prestadorNome = prestadorNome;
		this.prestadorUserId = prestadorUserId;
		this.status = status;
		this.user = user;
		this.userNome = userNome;
		this.data = data;
	}

	// public IndicacaoJson(Long id, float preco, float qualidade, float tempo,
	// float forma, float media, Long categoria, Long prestador, String
	// prestadorNome, Long prestadorUserId, String status,
	// Long user, String userNome) {
	// super();
	// this.id = id;
	// this.preco = preco;
	// this.qualidade = qualidade;
	// this.tempo = tempo;
	// this.forma = forma;
	// this.media = media;
	// this.categoria = categoria;
	// this.prestador = prestador;
	// this.prestadorNome = prestadorNome;
	// this.status = status;
	// this.user = user;
	// this.userNome = userNome;
	// this.prestadorUserId = prestadorUserId;
	// }
	//
	// public IndicacaoJson(Long id, float preco, float qualidade, float tempo,
	// float forma, float media, Long categoria, Long prestador, String status,
	// Long user, String usernome) {
	// super();
	// this.id = id;
	// this.preco = preco;
	// this.qualidade = qualidade;
	// this.tempo = tempo;
	// this.forma = forma;
	// this.media = media;
	// this.categoria = categoria;
	// this.prestador = prestador;
	// this.status = status;
	// this.user = user;
	// this.userNome = usernome;
	// }
	//
	// public IndicacaoJson(float preco, float qualidade, float tempo, float
	// forma, float media, Long categoria, Long prestador, String status, Long
	// user, String usernome) {
	// super();
	// this.preco = preco;
	// this.qualidade = qualidade;
	// this.tempo = tempo;
	// this.forma = forma;
	// this.media = media;
	// this.categoria = categoria;
	// this.prestador = prestador;
	// this.status = status;
	// this.user = user;
	// this.userNome = usernome;
	// }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// public float getPreco() {
	// return preco;
	// }
	//
	// public void setPreco(float preco) {
	// this.preco = preco;
	// }
	//
	// public float getQualidade() {
	// return qualidade;
	// }
	//
	// public void setQualidade(float qualidade) {
	// this.qualidade = qualidade;
	// }
	//
	// public float getTempo() {
	// return tempo;
	// }
	//
	// public void setTempo(float tempo) {
	// this.tempo = tempo;
	// }
	//
	// public float getForma() {
	// return forma;
	// }
	//
	// public void setForma(float forma) {
	// this.forma = forma;
	// }
	//
	// public float getMedia() {
	// return media;
	// }
	//
	// public void setMedia(float media) {
	// this.media = media;
	// }

	public Long getCategoria() {
		return categoria;
	}

	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}

	public Long getPrestador() {
		return prestador;
	}

	public void setPrestador(Long prestador) {
		this.prestador = prestador;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public String getUserNome() {
		return userNome;
	}

	public void setUserNome(String userNome) {
		this.userNome = userNome;
	}

	public String getPrestadorNome() {
		return prestadorNome;
	}

	public void setPrestadorNome(String prestadorNome) {
		this.prestadorNome = prestadorNome;
	}

	public Long getPrestadorUserId() {
		return prestadorUserId;
	}

	public void setPrestadorUserId(Long prestadorUserId) {
		this.prestadorUserId = prestadorUserId;
	}

	public String getCategoriaNome() {
		return categoriaNome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "IndicacaoJson{" + "id=" + id + ", categoria=" + categoria + ", categoriaNome='" + categoriaNome + '\'' + ", prestador=" + prestador + ", prestadorNome='" + prestadorNome + '\''
				+ ", prestadorUserId=" + prestadorUserId + ", status='" + status + '\'' + ", user=" + user + ", userNome='" + userNome + '\'' + ", data=" + data + '}';
	}

}