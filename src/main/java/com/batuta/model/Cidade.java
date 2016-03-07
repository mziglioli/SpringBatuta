package com.batuta.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

/**
 * The persistent class for the cidade database table.
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cidade", catalog = Catalago.BATUTA)
public class Cidade extends JpaRepositoryClass implements Serializable {

	private static final long serialVersionUID = -4603068296601411268L;

	@TableGenerator(name = "cidade_generator", table = "generated_keys", pkColumnName = "PK_COLUMN", valueColumnName = "VALUE_COLUMN", pkColumnValue = "id_cidade", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "cidade_generator")
	private Long id;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	private Date createdDate;

	// @JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estado", nullable = false)
	private Estado estado;

	@Column(length = 200, nullable = false)
	private String nome;

	@Column(length = 2, nullable = false)
	private String ddd;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false)
	private Date updatedDate;

	@JsonIgnore
	@Column(name = "created_by", nullable = false)
	private Long createdBy;

	@JsonIgnore
	@Column(name = "updated_by", nullable = false)
	private Long updatedBy;

	@JsonIgnore
	@OneToMany(mappedBy = "cidade")
	private List<Prestador> prestadores;

}