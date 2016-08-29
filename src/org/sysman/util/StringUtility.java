/*
* StringUtility
*
* 1.0
*
* 12/08/2016
*
* Copyright Stefanini Sysman
*/
package org.sysman.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.sysman.exception.SysmanException;
import org.sysman.util.commons.enums.DateFormatEnum;


 
/**
 * @author Erwin Jose Tirado Baldovino
 * 
 * @version 1.0
 * 
 * Clase utilitaria que permite convertir cadenasde caracteres (String) a otros tipos de datos.
 */
public class StringUtility {
	
	private static final String VACIO = "";
	
	/**
	 * Valida si un String es diferente de nulo o vac�o
	 */
	public static boolean isNullOrEmpty(String s) {
		if (s == null || s.equals(VACIO)) {
			return true;
		}
		return false;
	}

	/**
	 * Valida si el contenido de un String es equivalente a un Boolean
	 */
	public static boolean isBoolean(String s) {
		if (!isNullOrEmpty(s)) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(s) || Boolean.FALSE.toString().equalsIgnoreCase(s)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Convierte un tipo de dato String a uno Integer
	 */
	public static Integer toInteger(String s) throws NumberFormatException {
		if (!isNullOrEmpty(s)) {
			return Integer.parseInt(s);
		}
		return null;
	}
	
	/**
	 * Convierte un tipo de dato String a uno Long
	 */
	public static Long toLong(String s) throws NumberFormatException {
		if (!isNullOrEmpty(s)) {
			return Long.parseLong(s);
		}
		return null;
	}
	
	/**
	 * Convierte un tipo de dato String a uno BigInteger
	 */
	public static BigInteger toBigInteger(String s) throws NumberFormatException {
		if (!isNullOrEmpty(s)) {
			return new BigInteger(s);
		}
		return null;
	}
	
	/**
	 * Convierte un tipo de dato String a uno Float
	 */
	public static Float toFloat(String s) throws NumberFormatException {
		if (!isNullOrEmpty(s)) {
			return Float.parseFloat(s);
		}
		return null;
	}
	
	/**
	 * Convierte un tipo de dato String a uno Double
	 */
	public static Double toDouble(String s) throws NumberFormatException {
		if (!isNullOrEmpty(s)) {
			return Double.parseDouble(s);
		}
		return null;
	}
	
	/**
	 * Convierte un tipo de dato String a uno BigDecimal
	 */
	public static BigDecimal toBigDecimal(String s) throws NumberFormatException {
		if (!isNullOrEmpty(s)) {
			return new BigDecimal(s);
		}
		return null;
	}
	
	/**
	 * Convierte un tipo de dato String a uno Date, 
	 * de acuerdo al formato especificado (DateFormatEnum)
	 */
	public static Date toDate(String s, DateFormatEnum dfe) throws SysmanException {
		if (!isNullOrEmpty(s)) {
			DateFormat formatter = new SimpleDateFormat(dfe.getFormat());
			try {
				return formatter.parse(s);
			} catch (ParseException e) {
				throw new SysmanException(e.getMessage());
			}
		}
		return null;
	}
	
	/*public static void main(String...s) {
		String formato = "dd/MM/yyyy HH:mm:ss a";
		DateFormat formatter = new SimpleDateFormat(formato);
		Date d = new Date();
		System.out.println("Fecha :" +d);
		String fecha   = "10/10/2016 12:30:25"; //formatter.format(d);
		try {
			toDate(fecha, DateFormatEnum.DEFAULT);
			System.out.println("Es boolean : " +isBoolean("tRUE"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
