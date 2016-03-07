package com.batuta.util;


/**
 * Created by MicheleeMarcelo on 09/08/2015.
 */
public class TelefoneMask {

	private static String removeRegex(String s) {
		s = s.replaceAll("[^A-Za-z0-9]", "");
		return s;
	}

	public static String setFullMaskTelefone(String ddd, String telefone) {
		return addMascaraDDD(ddd) + addMascaraTelefone(telefone);
	}

	public static String setFullMaskTelefoneFromFullTelefone(String fullTelefone) {
		return addMascaraDDD(getDDDFromFullTelefone(fullTelefone)) + addMascaraTelefone(getTelefoneFromFullTelefone(fullTelefone));
	}

	public static String getDDDFromFullTelefone(String telefone) {
		telefone = removeRegex(telefone);
		return telefone.substring(0, 2);
	}

	public static String getTelefoneFromFullTelefone(String telefone) {
		telefone = removeRegex(telefone);
		return telefone.substring(2, telefone.length());
	}

	public static String addMascaraTelefone(String telefone) {
		telefone = removeRegex(telefone);
		int leng = telefone.length();
		String last4Number = telefone.substring(leng - 4, leng);
		String firstNumbers = telefone.substring(0, leng - 4);
		return firstNumbers + "-" + last4Number;
	}

	public static String removeMascaraTelefone(String telefone) {
		return removeRegex(telefone);
	}

	public static String addMascaraDDD(String ddd) {
		return "(" + ddd + ") ";
	}

	public static String removeMascaraDDD(String ddd) {
		return removeRegex(ddd);
	}
}
