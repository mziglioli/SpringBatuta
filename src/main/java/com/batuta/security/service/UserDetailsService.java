package com.batuta.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import com.batuta.model.User;
import com.batuta.model.json.MeFacebookGraph;
import com.batuta.repository.UserRepository;
import com.batuta.rest.RestTemplateDefault;
import com.batuta.util.FacebookValidate;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	private final AccountStatusUserDetailsChecker detailsChecker;

	public UserDetailsService() {
		this.detailsChecker = new AccountStatusUserDetailsChecker();
	}

	public void authenticaFacebookToken(User user) {
		User userDB = userRepository.findByUsername(user.getUsername());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		try {			
			if (userDB.isFacebookAuthenticado()) {
				RestTemplate restTemplate = RestTemplateDefault.getRestTemplate();
				HttpEntity requestEntity = new HttpEntity(RestTemplateDefault.getHeaders());
				String url = FacebookValidate.URL + user.getPassword();
				ResponseEntity<MeFacebookGraph> responseEntity = restTemplate.exchange(url, HttpMethod.GET,
						requestEntity, MeFacebookGraph.class);

				MeFacebookGraph me = responseEntity.getBody();
				
				if (me != null && Long.valueOf(me.getId()).equals(userDB.getId())) {
					userDB.setPassword(encoder.encode(user.getPassword()));
				} else {
					userDB.setPassword(encoder.encode(FacebookValidate.FACEBOOK_WRONG_PASSWORD));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			user.setPassword(encoder.encode(FacebookValidate.FACEBOOK_WRONG_PASSWORD));
		}
		userRepository.save(userDB);
	}

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		}

		detailsChecker.check(user);
		return user;
	}
}
