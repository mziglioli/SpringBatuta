package com.batuta.util;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.batuta.model.User;
import com.batuta.model.json.UserDto;
import com.batuta.rest.RestTemplateDefault;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Catalago {

	public static final String BATUTA = "novainteracao";

	public static final String NOVAINTERACAO = "novainteracao";

	public static void main(String[] args) {
		
		

		RestTemplate restTemplate = RestTemplateDefault.getRestTemplate();

		UserDto userDto = new UserDto("653647894734682", FacebookValidate.TOKEN_TEST);
		HttpEntity<UserDto> requestEntity = new HttpEntity<UserDto>(userDto, RestTemplateDefault.getHeaders());
		String url = "http://localhost:8080/ClubeDoBatuta/public/login";
		ResponseEntity<HttpServletResponse> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
				HttpServletResponse.class);
		HttpHeaders headers = responseEntity.getHeaders();
		String cookies = headers.getFirst("Set-Cookie");

		HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Content-Type", "application/json");
        requestHeaders.add("Content-Type", "text/plain");
        requestHeaders.add("Cookie",cookies);
		HttpEntity requestEntityUsers = new HttpEntity<>(requestHeaders);
		String urlUsers = "http://localhost:8080/ClubeDoBatuta/user/all";
		ResponseEntity<List> responseEntityUsers = restTemplate.exchange(urlUsers, HttpMethod.GET, requestEntityUsers,
				List.class);
		
        List<LinkedHashMap> objs = responseEntityUsers.getBody();
        for (LinkedHashMap map : objs ) {
            String mapAsJson;

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                mapAsJson = objectMapper.writeValueAsString(map);
                User user = new ObjectMapper().readValue(mapAsJson, User.class);
                System.out.println("user: " + user.toString());
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		
	}
}
