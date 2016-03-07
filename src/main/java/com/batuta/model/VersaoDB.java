package com.batuta.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.batuta.util.Catalago;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe VersaoDB, responsavel pela versao do banco de dados. Sera utilizada
 * para comparacao da versao do db do app e o db do webservice
 * 
 * @class VersaoDB
 * @implements Serializable
 * */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "versao", catalog = Catalago.BATUTA)
public class VersaoDB extends JpaRepositoryClass implements Serializable {

	private static final long serialVersionUID = -8275989541403798258L;

	@TableGenerator(name = "versao_generator", table = "generated_keys", pkColumnName = "PK_COLUMN", valueColumnName = "VALUE_COLUMN", pkColumnValue = "id_versao", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "versao_generator")
	private Long id;

	@Column(name = "nome", unique = true, length = 200, nullable = false)
	private int value;

	public VersaoDB(int value) {
		super();
		this.value = value;
	}
}