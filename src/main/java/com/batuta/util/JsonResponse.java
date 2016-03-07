package com.batuta.util;

import java.io.IOException;

import com.batuta.model.json.PrestadorJson;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
 * 
 * Class for test only
 * 
 * 
 * */
public class JsonResponse {
	private String status = "";
	private String errorMessage = "";

	public JsonResponse(String status, String errorMessage) {
		this.status = status;
		this.errorMessage = errorMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public static void main(String[] args) {
		String json = "{\"id\":1,\"bairro\":\"Bairro 1\",\"cidade\":\"Curitiba\",\"enable\":true,\"estado\":\"Paraná\",\"nome\":\"Chunda\",\"status\":\"ATIVO\\t\",\"telefones\":[\"99082677\"]}";
		ObjectMapper objectMapper = new ObjectMapper();
        try {
            PrestadorJson prestador = objectMapper.readValue(json,objectMapper.getTypeFactory().constructType(PrestadorJson.class));
            System.out.println("prestador: " + prestador.toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("pau");
        }
	}
}
