package com.batuta.util;

public class ChatUtil {

	public static final String DOMINIO = "@ihandson.com";

	public static String removeDominio(String s) {
		s = s.replaceAll(DOMINIO, "");
		return s;
	}
}
