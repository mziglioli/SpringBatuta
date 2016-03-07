package com.batuta.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Marcelo Ziglioli
 * @class HashMd5
 * Classe responsvael em transformar uma string em um hash md5 utilizando o MessageDigest MD5.
 * 
 * */
public class HashMd5 {

	public static String md5(String str) {
		MessageDigest m = null;
		String md5hash = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		if (m != null) {
			m.update(str.getBytes(), 0, str.length());
			BigInteger i = new BigInteger(1, m.digest());
			md5hash = String.format("%1$032x", i);
		}
		return md5hash;
	}
	
	public static void main(String[] args) {
		HashMd5 md5 = new HashMd5();
		System.out.println(md5.md5("novaint2015"));
	}

//	public static void main(String[] args) {
//
//		        HttpHeaders requestHeaders = new HttpHeaders();
//		        requestHeaders.add("Content-Type", "application/json");
//		        requestHeaders.add("Content-Type", "text/plain");
//
//		        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
//		        converters.add(new MappingJackson2HttpMessageConverter());
//		        converters.add(new StringHttpMessageConverter());
//
//		        RestTemplate restTemplate = new RestTemplate();
//		        restTemplate.setMessageConverters(converters);
//		        
//        HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);
//
//        ResponseEntity<List> responseEntity = restTemplate.exchange("http://localhost:8080/NovaIntegracaoWS/json/prestador/prestadorByCategoria/{id}", HttpMethod.GET, requestEntity, List.class,5);
//        List<LinkedHashMap> objs = responseEntity.getBody();
//
//        System.out.println("response: " + responseEntity.getBody());
//        if (responseEntity.getBody() != null){
//            
//        	List<Prestador> pt = new ArrayList<Prestador>();
//			for (LinkedHashMap map : objs ) {
//				String mapAsJson;
//				try {
//					mapAsJson = new ObjectMapper().writeValueAsString(map);
//					Prestador obj = new ObjectMapper().readValue(mapAsJson, Prestador.class);
//					pt.add(obj);
//				} catch (JsonProcessingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
//			
//        }
        
        
        
     		//System.out.println(md5("123"));
//		 ObjectMapper objectMapper = new ObjectMapper();
//		 objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//	        try {
//	            List<Prestador> prestadores = objectMapper.readValue(,objectMapper.getTypeFactory().constructCollectionType(List.class, Prestador.class));
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	         }
//        }
//	}

}
