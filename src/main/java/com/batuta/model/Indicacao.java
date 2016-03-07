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

import com.batuta.model.tipo.Status;
import com.batuta.util.Catalago;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the indicacao database table.
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "indicacao", catalog = Catalago.BATUTA)
public class Indicacao extends JpaRepositoryClass implements Serializable {

	private static final long serialVersionUID = -1133846554841605126L;

	@TableGenerator(name = "indicacao_generator", table = "generated_keys", pkColumnName = "PK_COLUMN", valueColumnName = "VALUE_COLUMN", pkColumnValue = "id_indicacao", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "indicacao_generator")
	private Long id;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date",nullable=false)
	private Date createdDate;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date",nullable=false)
	private Date updatedDate;

	@ManyToOne
	@JoinColumn(name = "categoria",nullable=false)
	private Categoria categoria;

	@JsonIgnore
	@Column(name = "created_by",nullable=false)
	private Long createdBy;

	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "prestador",nullable=false)
	private Prestador prestador;
	
	private String status;

	@JsonIgnore
	@Column(name = "updated_by",nullable=false)
	private Long updatedBy;

	@ManyToOne
	@JoinColumn(name = "user",nullable=false)
	private User user;

	public Indicacao(Date createdDate, Date updatedDate, Categoria categoria, Prestador prestador, User user) {
		super();
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.categoria = categoria;
		this.prestador = prestador;
		this.user = user;
		this.createdBy = user.getId();
		this.updatedBy = user.getId();
		this.status = Status.ATIVO.toString();
	}
}