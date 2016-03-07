package com.batuta.model.json;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Marcelo Ziglioli on 09/07/2015.
 */
public class MeFacebook implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String ddd;
	private Long cidade;
	private Long estado;
	private String password;
	private boolean prestador;
	private List<FriendFacebook> friends;

	public MeFacebook() {
	}
	
	

	public MeFacebook(String id, String name, String ddd, Long cidade, Long estado, String password, boolean prestador) {
		super();
		this.id = id;
		this.name = name;
		this.ddd = ddd;
		this.cidade = cidade;
		this.estado = estado;
		this.password = password;
		this.prestador = prestador;
	}



	public MeFacebook(String id, String name, String ddd, Long cidade,
			Long estado, String password) {
		super();
		this.id = id;
		this.name = name;
		this.ddd = ddd;
		this.cidade = cidade;
		this.estado = estado;
		this.password = password;
	}



	public MeFacebook(String id, String name, String ddd, Long cidade,
			Long estado, String password, List<FriendFacebook> friends) {
		super();
		this.id = id;
		this.name = name;
		this.ddd = ddd;
		this.cidade = cidade;
		this.estado = estado;
		this.password = password;
		this.friends = friends;
	}

	public MeFacebook(String id, String name, String ddd, Long cidade, Long estado, boolean prestador, List<FriendFacebook> friends) {
		super();
		this.id = id;
		this.name = name;
		this.ddd = ddd;
		this.cidade = cidade;
		this.estado = estado;
		this.prestador = prestador;
		this.friends = friends;
	}



	public MeFacebook(String id, String name, List<FriendFacebook> friends) {
		this.id = id;
		this.name = name;
		this.friends = friends;
	}

	



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FriendFacebook> getFriends() {
		return friends;
	}

	public void setFriends(List<FriendFacebook> friends) {
		this.friends = friends;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public Long getCidade() {
		return cidade;
	}

	public void setCidade(Long cidade) {
		this.cidade = cidade;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setPrestador(boolean prestador) {
		this.prestador = prestador;
	}
	public boolean isPrestador() {
		return prestador;
	}

	@Override
    public String toString() {
        return "MeFacebook{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ddd='" + ddd + '\'' +
                ", cidade=" + cidade +
                ", estado=" + estado +
                ", password='" + password + '\'' +
                ", prestador=" + prestador +
                ", friends=" + friends +
                '}';
    }
}
