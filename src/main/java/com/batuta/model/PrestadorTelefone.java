package com.batuta.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * The persistent class for the prestador_telefone database table.
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prestador_telefone", catalog = Catalago.BATUTA)
public class PrestadorTelefone extends JpaRepositoryClass implements Serializable {

	private static final long serialVersionUID = -4186803523214453857L;

	@TableGenerator(name = "prest_tel_generator", table = "generated_keys", pkColumnName = "PK_COLUMN", valueColumnName = "VALUE_COLUMN", pkColumnValue = "id_prest_telefone", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "prest_tel_generator")
	private Long id;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date",nullable=false)
	private Date createdDate;

	private String telefone;

	@Column(name = "telefone_ddd")
	private String telefoneDdd;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	private Date updatedDate;

	@JsonIgnore
	@Column(name = "created_by")
	private Long createdBy;

	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "prestador")
	private Prestador prestador;

	@JsonIgnore
	@Column(name = "updated_by")
	private Long updatedBy;

	public PrestadorTelefone(Date createdDate, String telefone,
			String telefoneDdd, Date updatedDate, Long createdBy,
			Prestador prestador, Long updatedBy) {
		super();
		this.createdDate = createdDate;
		this.telefone = telefone;
		this.telefoneDdd = telefoneDdd;
		this.updatedDate = updatedDate;
		this.createdBy = createdBy;
		this.prestador = prestador;
		this.updatedBy = updatedBy;
	}
}