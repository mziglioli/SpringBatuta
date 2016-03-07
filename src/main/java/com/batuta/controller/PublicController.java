package com.batuta.controller;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.batuta.model.User;
import com.batuta.model.tipo.Authorities;
import com.batuta.security.user.UserAuthority;
import com.batuta.service.UserService;

@RestController
@RequestMapping(value = "/public", produces = MediaType.APPLICATION_JSON_VALUE)
public class PublicController {

//	@Autowired
//    TokenAuthenticationService tokenAuthenticationService;
//
//    @Autowired
//    AuthenticationService authenticationService;
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public Boolean login(@RequestBody UserDto userDto, HttpServletResponse response) {
//        tokenAuthenticationService.addAuthentication(response, authenticationService.loadUserByUsername(userDto.getUsername()));
//        return true;
//    }
    
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/start/auth", method = RequestMethod.GET)
    public Collection<User> auth() {
    	Collection<User> users = userService.findAll();
    	for (User user : users) {
    		Collection<UserAuthority> authorities = new HashSet<>(); 
    		authorities.add(new UserAuthority(Authorities.USER.getRole()));
			if(user.getId() > 0 && user.getId() < 5){
				authorities.add(new UserAuthority(Authorities.PROFISSIONAL.getRole()));
				authorities.add(new UserAuthority(Authorities.ADMIN.getRole()));
				user.setFacebookAuthenticado(false);
			}else{
				user.setFacebookAuthenticado(true);
			}
			user.setAuthorities(authorities);
			
//    		Collection<String> authorities = new HashSet<>(); 
//    		authorities.add(Authorities.USER.getRole());
//			if(user.getId() > 0 && user.getId() < 5){
//				authorities.add(Authorities.PROFISSIONAL.getRole());
//				authorities.add(Authorities.ADMIN.getRole());
//			}
//			user.setRoles(authorities);
			userService.save(user);
		}
    	return users;
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Collection<User> findAll(){
    	return userService.findAll();
    }
	
}
