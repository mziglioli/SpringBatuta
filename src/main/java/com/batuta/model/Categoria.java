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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The persistent class for the categoria database table.
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(of={"categoriaId","nome","parent","indexacao"})
@Entity
@Table(name = "categoria", catalog = Catalago.BATUTA)
public class Categoria extends JpaRepositoryClass implements Serializable {

	private static final long serialVersionUID = -3019684445927328493L;

	@TableGenerator(name = "categoria_generator", table = "generated_keys", pkColumnName = "PK_COLUMN", valueColumnName = "VALUE_COLUMN", pkColumnValue = "id_categoria", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "categoria_generator")
	private Long categoriaId;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	private Date createdDate;

	@Column(name = "nome", unique = true, length = 200, nullable = false)
	private String nome;

	@Column(name = "indexacao", nullable = true)
	private String indexacao;

	@Column(name = "icone", nullable = true)
	private String icone;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false)
	private Date updatedDate;

	@JsonIgnore
	@Column(name = "created_by", nullable = false)
	private Long createdBy;

	@ManyToOne
	@JoinColumn(name = "parent")
	private Categoria parent;

	@JsonIgnore
	@OneToMany(mappedBy = "parent")
	private List<Categoria> categorias;

	@JsonIgnore
	@Column(name = "updated_by", nullable = false)
	private Long updatedBy;

	@JsonIgnore
	@OneToMany(mappedBy = "categoria")
	private List<Indicacao> indicacaos;

	@JsonIgnore
	@OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
	private List<MetricaPrestadoresCategoria> metricaPrestadoresCategorias;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categorias")
	private Set<Prestador> prestadores = new HashSet<Prestador>();

}