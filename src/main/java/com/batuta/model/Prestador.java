package com.batuta.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.batuta.util.Catalago;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the prestador database table.
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false,of={"id"})
@Entity
@Table(name = "prestador", catalog = Catalago.BATUTA)
public class Prestador extends JpaRepositoryClass implements Serializable {

	private static final long serialVersionUID = -4271296116570974034L;

	@TableGenerator(name = "prestador_generator", table = "generated_keys", pkColumnName = "PK_COLUMN", valueColumnName = "VALUE_COLUMN", pkColumnValue = "id_prestador", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "prestador_generator")
	private Long id;

	@Column
	private String bairro;

	@ManyToOne
	@JoinColumn(name = "cidade", nullable = false)
	private Cidade cidade;

	@Column
	private String endereco;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	private Date createdDate;

	@Column
	private boolean enable;

	@Column(nullable = false)
	private String nome;

	@Column
	private String apelido;

	@Column
	private String documento;

	@Column
	private boolean fisica;

	@Column
	private boolean juridica;

	@Column
	private String email;

	@Column
	private String site;

	@ManyToOne
	@JoinColumn(name = "parent")
	private Prestador parent;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false)
	private Date updatedDate;

	// @JsonIgnore
	@OneToMany(mappedBy = "prestador", fetch = FetchType.EAGER)
	private List<Indicacao> indicacaos;

	@JsonIgnore
	@Column(name = "created_by", nullable = false)
	private Long createdBy;

	private String status;

	@JsonIgnore
	@Column(name = "updated_by", nullable = false)
	private Long updatedBy;

	// @JsonIgnore
	@OneToMany(mappedBy = "prestador", fetch = FetchType.EAGER)
	private List<PrestadorTelefone> prestadorTelefones;

	@Column(name = "userId", nullable = true)
	private Long userId;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "prestador_categoria", catalog = "novainteracao", joinColumns = { @JoinColumn(name = "prestador_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "categoria_id", nullable = false, updatable = false) })
	private Set<Categoria> categorias = new HashSet<Categoria>();

	public Prestador(String bairro, Cidade cidade, String endereco, Date createdDate, boolean enable, String nome, String apelido, String documento, boolean fisica, boolean juridica, String email,
			String site, Prestador parent, Date updatedDate, List<Indicacao> indicacaos, Long createdBy, String status, Long updatedBy, List<PrestadorTelefone> prestadorTelefones, Long userId,
			Set<Categoria> categorias) {
		super();
		this.bairro = bairro;
		this.cidade = cidade;
		this.endereco = endereco;
		this.createdDate = createdDate;
		this.enable = enable;
		this.nome = nome;
		this.apelido = apelido;
		this.documento = documento;
		this.fisica = fisica;
		this.juridica = juridica;
		this.email = email;
		this.site = site;
		this.parent = parent;
		this.updatedDate = updatedDate;
		this.indicacaos = indicacaos;
		this.createdBy = createdBy;
		this.status = status;
		this.updatedBy = updatedBy;
		this.prestadorTelefones = prestadorTelefones;
		this.userId = userId;
		this.categorias = categorias;
	}
	
	public Prestador(String bairro, Cidade cidade, String endereco, Date createdDate, boolean enable, String nome, String apelido, String documento, boolean fisica, boolean juridica, String email,
			String site, Prestador parent, Date updatedDate, Long createdBy, String status, Long updatedBy, Set<Categoria> categorias, Long userId) {
		super();
		this.bairro = bairro;
		this.cidade = cidade;
		this.endereco = endereco;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.enable = enable;
		this.nome = nome;
		this.apelido = apelido;
		this.documento = documento;
		this.fisica = fisica;
		this.juridica = juridica;
		this.email = email;
		this.site = site;
		this.parent = parent;
		this.createdBy = createdBy;
		this.status = status;
		this.updatedBy = updatedBy;
		this.userId = userId;
		this.categorias = categorias;
	}	


}