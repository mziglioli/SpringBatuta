package com.batuta.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.UserDetails;

import com.batuta.model.tipo.Status;
import com.batuta.security.user.UserAuthority;
import com.batuta.util.Catalago;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The persistent class for the user database table.
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = { "id" })
@ToString(callSuper = false, of = { "id", "nome" })
@Entity
@Table(name = "user", catalog = Catalago.BATUTA)
@JsonIgnoreProperties(value = { "friends" })
public class User extends JpaRepositoryClass implements Serializable, UserDetails {
	private static final long serialVersionUID = -8984729078206143726L;

	@Id
	private Long id;

	@Column
	private String nome;

	@Column(nullable = true)
	private String username;

	@JsonIgnore
	@Column(nullable = true)
	private String password;

	@Column
	private String status;

	@Column
	private String ddd;

	@Column
	private Long cidade;

	@Column
	private Long estado;
	
	@Column(nullable = false)
	private boolean isFacebookAuthenticado;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "friends", joinColumns = @JoinColumn(name = "userId") , inverseJoinColumns = @JoinColumn(name = "friendId") )
	private Set<User> friends = new HashSet<User>();

	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<MetricaAcesso> acessos;

	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<MetricaPrestadoresCategoria> metricaPrestadoresCategorias;

	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Indicacao> indicacaos;

	@ElementCollection(fetch = FetchType.EAGER)
	private Collection<UserAuthority> authorities;
	
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		if (Status.ATIVO.toString().equals(status)) {
			return true;
		}
		return false;
	}

//	@JsonIgnore
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		Collection<SimpleGrantedAuthority> authorities = new HashSet<>();
//		if (roles != null && !roles.isEmpty()) {
//			for (String role : roles) {
//				SimpleGrantedAuthority auth = new SimpleGrantedAuthority(role);
//				authorities.add(auth);
//			}
//		}
//		return authorities;
//	}

}