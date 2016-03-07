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
 * The persistent class for the estado database table.
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estado", catalog = Catalago.BATUTA)
public class Estado extends JpaRepositoryClass implements Serializable {

	private static final long serialVersionUID = 658386777916143848L;

	@TableGenerator(name = "estado_generator", table = "generated_keys", pkColumnName = "PK_COLUMN", valueColumnName = "VALUE_COLUMN", pkColumnValue = "id_estado", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "estado_generator")
	private Integer id;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	private Date createdDate;

	@Column(length = 254, unique = true, nullable = false)
	private String nome;

	@Column(length = 2, nullable = false)
	private String sigla;

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
	@OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
	private List<Cidade> cidades;

	public Estado(Date createdDate, String nome, String sigla,
			Date updatedDate, Long createdBy, Long updatedBy) {
		super();
		this.createdDate = createdDate;
		this.nome = nome;
		this.sigla = sigla;
		this.updatedDate = updatedDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

}