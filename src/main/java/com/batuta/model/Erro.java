package com.batuta.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * The persistent class for the categoria database table.
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "erro", catalog = Catalago.BATUTA)
public class Erro extends JpaRepositoryClass implements Serializable {

	private static final long serialVersionUID = 4662364351086876579L;

	@TableGenerator(name = "erro_generator", table = "generated_keys", pkColumnName = "PK_COLUMN", valueColumnName = "VALUE_COLUMN", pkColumnValue = "id_erro", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "erro_generator")
	private Long id;

	@Column(name = "assunto", unique = false, length = 200, nullable = false)
	private String assunto;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	private Date createdDate;
	
	@JsonIgnore
	@Column(name = "created_by", nullable = false)
	private Long createdBy;
}