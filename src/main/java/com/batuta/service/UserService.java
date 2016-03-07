package com.batuta.service;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batuta.converter.UserConverter;
import com.batuta.model.User;
import com.batuta.model.json.FriendFacebook;
import com.batuta.model.json.MeFacebook;
import com.batuta.model.tipo.Authorities;
import com.batuta.repository.UserRepository;
import com.batuta.security.user.UserAuthority;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class UserService extends ServiceDefault<User, UserRepository> {

	@Autowired
	private MetricaAcessoService metricaAcessoService;
	
	@Autowired
	private UserConverter userConverter;

	public User findByUsername(String username) {
		return getRepository().findByUsername(username);
	}

	public boolean update(MeFacebook obj) {
		User user = getRepository().findOne(Long.valueOf(obj.getId()));
		if (user != null) {
			user.setCidade(obj.getCidade());
			user.setEstado(obj.getEstado());
			user.setDdd(obj.getDdd());
			user.setPassword(obj.getPassword());
			update(user);
			return true;
		}
		return false;
	}

	public MeFacebook addUser(MeFacebook obj) {
		User user = getRepository().findOne(Long.valueOf(obj.getId()));
		if (user == null) {
			user = userConverter.convert(obj);
//			Collection<String> authorities = new HashSet<>(); 
//    		authorities.add(Authorities.USER.getRole());
//			user.setRoles(authorities);
			Collection<UserAuthority> authorities = new HashSet<>(); 
    		authorities.add(new UserAuthority(Authorities.USER.getRole()));
			user.setAuthorities(authorities);
			save(user);
		}
		metricaAcessoService.addMetricaAcessoByUser(user);
		addFriends(user, obj);

		return convert(user);
	}
	
	public MeFacebook convert(User user){
		return userConverter.convert(user);
	}

	public void addFriends(User user, MeFacebook obj) {
		if (user != null) {
			log.info("user friends: " + obj.getFriends());
			if (obj.getFriends() != null && obj.getFriends().size() > 0) {
				for (FriendFacebook ff : obj.getFriends()) {
					log.info("salvar " + ff.toString());
					User userFriend = getRepository().findOne(Long.valueOf(ff.getId()));
					if (userFriend != null) {
						log.info("achou amigo: " + userFriend);
						if (!user.getFriends().contains(userFriend)) {
							user.getFriends().add(userFriend);
							log.info("adicionou amigo: " + userFriend.toString());
							update(user);
						} else {
							log.info("ja estava na lista o amigo: " + userFriend.toString());
						}
					}
				}
			} else {
				log.info("no friends");
			}
			log.info("user friends: " + user.getFriends());
		}
	}
	
	public Long getQtdUsers(){
		return getRepository().count();
	}

}
