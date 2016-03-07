package com.batuta.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the chat database table.
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "archive", catalog = "ejabberd")
public class Archive extends JpaRepositoryClass implements Serializable {

	private static final long serialVersionUID = 4285214468095548123L;

	@Column(length = 191, nullable = false)
	private String username;

	@Column(nullable = false)
	private Long timestamp;

	@Column(length = 191, nullable = false)
	private String peer;

	@Column(length = 191, nullable = false)
	private String bare_peer;

	@Column(nullable = false)
	private String xml;

	@Column(nullable = false)
	private String txt;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 10, nullable = false)
	private String kind;

	@Column(length = 191, nullable = false)
	private String nick;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	private Date created_at = new Date();


	
}