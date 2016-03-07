package com.batuta.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the user database table.
 * Chat user, utilizado pelo ejabberd
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", catalog = "ejabberd")
public class Users extends JpaRepositoryClass implements Serializable {

	private static final long serialVersionUID = -6617815510455207819L;

	@Id
	@Column
	private String username;

	@Column(nullable = true)
	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at",nullable=false)
	private Date data;

}