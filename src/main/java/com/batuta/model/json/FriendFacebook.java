package com.batuta.model.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcelo Ziglioli Classe FriendFacebook,classe provisoria responsavel
 *         somente para facilitar a utilizacao dos dados recebido pela SDK do
 *         facebook. Esta classe é utilizado no momento do login do usuario,
 *         para instanciar objetos que contenham o id e o nome dos amigos do
 *         usuario logado. Estes dados sao retornados pelo SDK do facebook assim
 *         que o usuario logar no applicativo utilizando o botao de login do
 *         facebook.
 * @see com.facebook.FacebookCallback
 * */
public class FriendFacebook implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	public FriendFacebook() {
		// TODO Auto-generated constructor stub
	}

	public FriendFacebook(String id) {
		this.id = id;
	}

	public FriendFacebook(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static void main(String[] args) {
		MeFacebook me = new MeFacebook();
		int id = 4;
		me.setId("111");
		me.setName("name");

		FriendFacebook ff = new FriendFacebook("122");
		FriendFacebook ff2 = new FriendFacebook("123");

		List<FriendFacebook> friends = new ArrayList<FriendFacebook>();
		friends.add(ff);
		friends.add(ff2);
		me.setFriends(friends);

		StringBuilder sb = new StringBuilder(
				"select tt.id, tt.bairro, tt.created_date,tt.enable,tt.nome,tt.status,tt.updated_date, tt.cidade, tt.created_by, tt.updated_by, tt.user, tt.user_seq from "
						+ "(Select p.*,i.user,CONCAT(9, i.user.id) user_seq,i.qualidade from Prestador p,Indicacao i where p.id = i.prestador.id and i.categoria.categoriaId = " + id
						+ " and i.user.id = '" + me.getId() + "' limit 1 "

						+ " Union all " + " Select p.*,i.user,CONCAT(5, i.user.id) user_seq,i.qualidade from Prestador p,Indicacao i where p.id = i.prestador.id and i.categoria.categoriaId = " + id
						+ " and i.user.id in (");

		for (FriendFacebook f : me.getFriends()) {
			sb.append("'" + f.getId() + "',");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append(") limit 99 " + " Union all "
				+ " Select p.*,i.user,CONCAT(5, i.user.id) user_seq,i.qualidade from Prestador p,Indicacao i where p.id = i.prestador.id and i.categoria.categoriaId = " + id
				+ " and i.user.id not in (");
		for (FriendFacebook f : me.getFriends()) {
			sb.append("'" + f.getId() + "',");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append(") limit 99 ) as tt order by tt.user_seq desc, qualidade desc");

		System.out.println(sb.toString());
	}
}
