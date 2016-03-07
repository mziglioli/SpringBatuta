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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the perfilFalso database table.
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "perfil_falso", catalog = Catalago.BATUTA)
public class PerfilFalso extends JpaRepositoryClass implements Serializable {

	private static final long serialVersionUID = 1974732771061332606L;

	@TableGenerator(name = "perfil_falso_generator", table = "generated_keys", pkColumnName = "PK_COLUMN", valueColumnName = "VALUE_COLUMN", pkColumnValue = "id_perfil_falso", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "perfil_falso_generator")
	private Long perfilFalsoId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	private Date createdDate;

	@Column(name = "created_by", nullable = false)
	private Long createdBy;

	@Column(name = "telefone", length = 20, nullable = false)
	private String telefone;

	@Column(name = "situacao", length = 20, nullable = false)
	private String situacao;

	public PerfilFalso(Date createdDate, Long createdBy, String telefone, String situacao) {
		super();
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.telefone = telefone;
		this.situacao = situacao;
	}
}