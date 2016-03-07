package com.batuta.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.batuta.model.User;
import com.batuta.model.json.FriendFacebook;
import com.batuta.model.json.MeFacebook;

@Component
public class UserConverter {
	
	@Autowired
	private PrestadorConverter prestadorConverter;
//	
	/**
	 * @author Marcelo Ziglioli Metodo responsavel em wrapper do objeto User em
	 *         um objeto MeFacebook
	 * @return MeFacebook
	 * @param user
	 *            User
	 * */
	public MeFacebook convert(User u) {
		MeFacebook me = new MeFacebook();
		me.setId(String.valueOf(u.getId()));
		me.setName(u.getNome());
		me.setDdd(u.getDdd());
		me.setCidade(u.getCidade());
		me.setEstado(u.getEstado());
		me.setPrestador(prestadorConverter.isPrestador(u.getId()));
		me.setFriends(getFriends(u.getFriends()));
		
		return me;
	}
	
	public User convert(MeFacebook me) {
		User u = new User();
		u.setId(Long.valueOf(me.getId()));
		u.setNome(me.getName());
		u.setDdd(me.getDdd());
		u.setCidade(me.getCidade());
		u.setEstado(me.getEstado());
		
		return u;
	}

	public List<FriendFacebook> getFriends(Set<User> friends){
		List<FriendFacebook> ff = new ArrayList<FriendFacebook>();
		for (User u : friends) {
			ff.add(new FriendFacebook(u.getId().toString(),u.getNome()));
		}
		return ff;
	}

//	public org.springframework.security.core.userdetails.User convertUserDetails(User user){
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
//	}


}
