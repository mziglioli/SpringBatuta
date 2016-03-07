package com.batuta.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.batuta.model.User;
import com.batuta.model.json.MeFacebook;
import com.batuta.service.UserService;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping(value = "/user")
@PreAuthorize(value="hasRole('ROLE_USER')")
public class UserController extends ControllerDefault<UserService> {

	/**
	 * Teste
	 * 
	 * @author Marcelo Ziglioli
	 * @see ResponseBody
	 * @see RequestMapping Metodo responsavel em gerenciar as chamadas da url "/json/user/friends/{id}". Ira buscar os
	 *      amigos que estiverem no banco, com os ids passado como parametro.
	 * @param ids
	 *            ArraList<Long>
	 * @return List<User>
	 */
	@RequestMapping(value = "/friends/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody List<User> getFriends(@PathVariable("id") ArrayList<Long> ids) {
		log.info("getFriends");
		List<User> users = new ArrayList<User>();
		for (Long id : ids) {
			User u = getService().getRepository().findOne(id);
			if (u != null)
				users.add(u);
		}
		return users;
	}

	/**
	 * @author Marcelo Ziglioli
	 * @see ResponseBody
	 * @see RequestMapping Metodo responsavel em gerenciar as chamadas da url "/json/user/all". Ira retornar todos
	 *      usuarios do db
	 * @return List<User>
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody List<User> getAll() {
		log.info("getAll");
		return getService().getRepository().findAll();
	}

	/**
	 * @author Marcelo Ziglioli
	 * @see ResponseBody
	 * @see RequestMapping Metodo responsavel em gerenciar as chamadas da url "/json/categoria/parent/{id}". Ira
	 *      retornar todas as categorias filhas da categoria passada como parametro no banco de dados.
	 * @param id
	 *            long
	 * @return categorias List<CategoriaJson>
	 */
	@RequestMapping(value = "/isRegister/{id}", method = RequestMethod.GET)
	public @ResponseBody MeFacebook isRegister(@PathVariable("id") String id) {
		log.info("isRegister");
		User user = getService().getRepository().findOne(Long.valueOf(id));
		return getService().convert(user);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody boolean edit(@RequestBody MeFacebook obj) {
		log.info("edit " + obj.toString());
		if (obj != null && obj.getId() != null) {
			return getService().update(obj);
		}
		return false;
	}

	/**
	 * @author Marcelo Ziglioli
	 * @see ResponseBody
	 * @see RequestMapping Metodo responsavel em gerenciar as chamadas da url "/json/user/add". Ira persistir o usuario
	 *      passado como parametro no banco se ele ainda nao esta cadastrado.
	 * @param user
	 *            UserJson
	 * @return boolean
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody MeFacebook add(@RequestBody MeFacebook obj) {
		log.info("add " + obj.toString());
		if (obj != null && obj.getId() != null) {
			return getService().addUser(obj);
		}
		return null;
	}
	
	//TODO 
    //apagar depois, somente para teste
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Collection<User> login() {
        return getService().findAll();
    }

}
