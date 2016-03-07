package com.batuta.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the acesso database table.
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "metrica_acesso", catalog = Catalago.BATUTA)
public class MetricaAcesso extends JpaRepositoryClass implements Serializable {

	private static final long serialVersionUID = 6889146613461178236L;

	@TableGenerator(name = "metrica_acesso_generator", table = "generated_keys", pkColumnName = "PK_COLUMN", valueColumnName = "VALUE_COLUMN", pkColumnValue = "id_metrica_acesso", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "metrica_acesso_generator")
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;

	@ManyToOne
	@JoinColumn(name = "user")
	private User user;

	public MetricaAcesso(Calendar data, User user) {
		super();
		this.data = data;
		this.user = user;
	}
}