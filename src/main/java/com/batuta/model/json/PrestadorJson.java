package com.batuta.model.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.builder.CompareToBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe PrestadorJson, Esta classe é responsavel pelo wrapper entre
 * server-cliente do objeto Indicacao. O objeto Prestador no banco de dados é
 * muito complexo e possui dados que nao serao utilizados pelo aplicativo no
 * android. Para evitar o processamento e protecao de alguns dados do usuario.
 * Esta classe conversa diretamente com o servidor utilizando RestTemplate
 * Spring
 * 
 * @implements Serializable
 */
public class PrestadorJson implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String bairro;
	private String cidade;
	private boolean enable;
	private String estado;
	private String nome;
	private String apelido;
	private String status;
	// esse atributo é o id do prestador como usuario do facebook
	private Long userId;
	private Long createdBy;
	private String endereco;
	private String documento;
	private boolean fisica;
	private boolean juridica;
	private String email;
	private String site;
	private Long parent;
	private List<String> telefones;
	private List<IndicacaoJson> indicacoesJson;
	private List<Long> categorias;

	public PrestadorJson() {
		this.telefones = new ArrayList<String>();
		this.indicacoesJson = new ArrayList<IndicacaoJson>();
		this.categorias = new ArrayList<Long>();
	}

	public PrestadorJson(Long id, String bairro, String cidade, boolean enable, String estado, String nome,
			String status, Long userId, Long createdBy, List<String> telefones, List<IndicacaoJson> indicacoesJson) {
		this.id = id;
		this.bairro = bairro;
		this.cidade = cidade;
		this.enable = enable;
		this.estado = estado;
		this.nome = nome;
		this.status = status;
		this.userId = userId;
		this.createdBy = createdBy;
		this.telefones = telefones;
		this.indicacoesJson = indicacoesJson;
	}

	public PrestadorJson(Long id, String bairro, String cidade, boolean enable, String estado, String nome,
			String status, Long createdBy, List<String> telefones, List<IndicacaoJson> indicacoesJson) {
		this.id = id;
		this.bairro = bairro;
		this.cidade = cidade;
		this.enable = enable;
		this.estado = estado;
		this.nome = nome;
		this.status = status;
		this.createdBy = createdBy;
		this.telefones = telefones;
		this.indicacoesJson = indicacoesJson;
	}

	public PrestadorJson(List<IndicacaoJson> indicacoesJson, List<String> telefones, Long createdBy, String status,
			String nome, String estado, boolean enable, String cidade, String bairro) {
		this.indicacoesJson = indicacoesJson;
		this.telefones = telefones;
		this.createdBy = createdBy;
		this.status = status;
		this.nome = nome;
		this.estado = estado;
		this.enable = enable;
		this.cidade = cidade;
		this.bairro = bairro;
	}

	public PrestadorJson(Long id, String bairro, String cidade, boolean enable, String estado, String nome,
			String status, Long userId, Long createdBy, String endereco, String documento, boolean fisica,
			boolean juridica, String email, String site, Long parent, List<String> telefones,
			List<IndicacaoJson> indicacoesJson, List<Long> categorias) {
		super();
		this.id = id;
		this.bairro = bairro;
		this.cidade = cidade;
		this.enable = enable;
		this.estado = estado;
		this.nome = nome;
		this.status = status;
		this.userId = userId;
		this.createdBy = createdBy;
		this.endereco = endereco;
		this.documento = documento;
		this.fisica = fisica;
		this.juridica = juridica;
		this.email = email;
		this.site = site;
		this.parent = parent;
		this.telefones = telefones;
		this.indicacoesJson = indicacoesJson;
		this.categorias = categorias;
	}

	public PrestadorJson(Long id, String bairro, String cidade, boolean enable, String estado, String nome,
			String apelido, String status, Long userId, Long createdBy, List<String> telefones,
			List<IndicacaoJson> indicacoesJson) {
		this.id = id;
		this.bairro = bairro;
		this.cidade = cidade;
		this.enable = enable;
		this.estado = estado;
		this.nome = nome;
		this.status = status;
		this.userId = userId;
		this.createdBy = createdBy;
		this.telefones = telefones;
		this.indicacoesJson = indicacoesJson;
		this.apelido = apelido;
	}

	public PrestadorJson(Long id, String bairro, String cidade, boolean enable, String estado, String nome,
			String apelido, String status, Long createdBy, List<String> telefones, List<IndicacaoJson> indicacoesJson) {
		this.id = id;
		this.bairro = bairro;
		this.cidade = cidade;
		this.enable = enable;
		this.estado = estado;
		this.nome = nome;
		this.apelido = apelido;
		this.status = status;
		this.createdBy = createdBy;
		this.telefones = telefones;
		this.indicacoesJson = indicacoesJson;
	}

	public PrestadorJson(List<IndicacaoJson> indicacoesJson, List<String> telefones, Long createdBy, String status,
			String nome, String apelido, String estado, boolean enable, String cidade, String bairro) {
		this.indicacoesJson = indicacoesJson;
		this.telefones = telefones;
		this.createdBy = createdBy;
		this.status = status;
		this.nome = nome;
		this.apelido = apelido;
		this.estado = estado;
		this.enable = enable;
		this.cidade = cidade;
		this.bairro = bairro;
	}

	public PrestadorJson(Long id, String bairro, String cidade, boolean enable, String estado, String nome,
			String apelido, String status, Long userId, Long createdBy, String endereco, String documento,
			boolean fisica, boolean juridica, String email, String site, Long parent, List<String> telefones,
			List<IndicacaoJson> indicacoesJson, List<Long> categorias) {
		this.id = id;
		this.bairro = bairro;
		this.cidade = cidade;
		this.enable = enable;
		this.estado = estado;
		this.nome = nome;
		this.apelido = apelido;
		this.status = status;
		this.userId = userId;
		this.createdBy = createdBy;
		this.endereco = endereco;
		this.documento = documento;
		this.fisica = fisica;
		this.juridica = juridica;
		this.email = email;
		this.site = site;
		this.parent = parent;
		this.telefones = telefones;
		this.indicacoesJson = indicacoesJson;
		this.categorias = categorias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public boolean isFisica() {
		return fisica;
	}

	public void setFisica(boolean fisica) {
		this.fisica = fisica;
	}

	public boolean isJuridica() {
		return juridica;
	}

	public void setJuridica(boolean juridica) {
		this.juridica = juridica;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}

	public List<IndicacaoJson> getIndicacoesJson() {
		return indicacoesJson;
	}

	@JsonIgnore
	public List<IndicacaoJson> getIndicacoesJsonOrderByData() {
		Collections.sort(indicacoesJson, new Comparator<IndicacaoJson>() {
			@Override
			public int compare(IndicacaoJson i0, IndicacaoJson i1) {
				return new CompareToBuilder().append(i1.getData(), i0.getData()).toComparison();
			}
		});

		return indicacoesJson;
	}

	public void setIndicacoesJson(List<IndicacaoJson> indicacoesJson) {
		this.indicacoesJson = indicacoesJson;
	}

	public List<Long> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Long> categorias) {
		this.categorias = categorias;
	}

	@Override
	public String toString() {
		return "PrestadorJson{" + "id=" + id + ", bairro='" + bairro + '\'' + ", cidade='" + cidade + '\'' + ", enable="
				+ enable + ", estado='" + estado + '\'' + ", nome='" + nome + '\'' + ", apelido='" + apelido + '\''
				+ ", status='" + status + '\'' + ", userId=" + userId + ", createdBy=" + createdBy + ", endereco='"
				+ endereco + '\'' + ", documento='" + documento + '\'' + ", fisica=" + fisica + ", juridica=" + juridica
				+ ", email='" + email + '\'' + ", site='" + site + '\'' + ", parent=" + parent + ", telefones="
				+ telefones + ", indicacoesJson=" + indicacoesJson + ", categorias=" + categorias + '}';
	}

}