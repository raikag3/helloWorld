/*
* NumberUtility
*
* 1.0
*
* 12/08/2016
*
* Copyright Stefanini Sysman
*/
package org.sysman.util;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import org.sysman.exception.SysmanException;
import org.sysman.util.commons.enums.NumberEnum;


 
/**
 * @author Erwin Jose Tirado Baldovino
 * 
 * @version 1.0
 * 
 * Clase utilitaria que permite hacer conversiones a tipos numericos.
 */
public class NumberUtility {

	/*
	 * public static boolean isInteger(String inputNumber) { return
	 * Pattern.compile("^(-)?([0-9]){1,10}$").matcher(inputNumber).find(); }
	 * 
	 * public static boolean isLong(String inputNumber) { return
	 * Pattern.compile("^(-)?([0-9]){1,19}$").matcher(inputNumber).find(); }
	 */

	/**
	 * Valida si una cadena de caracteres (String) posee un
	 * patron numerico para ser convertido en dicho tipo.
	 */
	public static boolean isInteger(String inputNumber) {
		if ("0".equals(inputNumber)) {
			return true;
		}
		return Pattern.compile("^(-)?([1-9])+([0-9])*$").matcher(inputNumber).find();
	}

	/**
	 * Valida si una cadena de caracteres (String) posee un
	 * patron numerico decimal para ser convertido en dicho tipo.
	 */
	public static boolean isDecimal(String inputNumber) {
		return Pattern.compile("^(-)?([0-9\\.,])*$").matcher(inputNumber).find();
	}

	/**
	 * Convierte una cadena de caracteres (String) en un tipo numerico entero,
	 * que depemdiendo del tamano puede llegar a convertirse en un Integer, Long 
	 * o BigInteger.
	 */
	public static Object toInteger(String inputNumber) throws SysmanException {
		if (StringUtility.isNullOrEmpty(inputNumber)) {
			throw new SysmanException("El objeto es nulo");
		}

		if (inputNumber.length() <= NumberEnum.INTEGER.getValue()) {
			return StringUtility.toInteger(inputNumber);
		} else if (inputNumber.length() > NumberEnum.INTEGER.getValue()) {
			return StringUtility.toLong(inputNumber);
		} else {
			return StringUtility.toBigInteger(inputNumber);
		}
	}

	/**
	 * Convierte una cadena de caracteres (String) en un tipo numerico decimal,
	 * que depemdiendo del tamano puede llegar a convertirse en un Float, Double
	 * o un BigDecimal.
	 */
	public static Object toDecimal(String inputNumber) throws SysmanException {
		if (StringUtility.isNullOrEmpty(inputNumber)) {
			throw new SysmanException("El objeto es nulo");
		}

		if (inputNumber.length() <= NumberEnum.DOUBLE.getValue()) {
			return StringUtility.toFloat(inputNumber);
		} else if (inputNumber.length() > NumberEnum.DOUBLE.getValue()) {
			return StringUtility.toDouble(inputNumber);
		} else {
			return StringUtility.toBigDecimal(inputNumber);
		}
	}

	public static void main(String... s) {
		// System.out.println("El valor es: " +b1);
		// System.out.println("El valor es: " +c);
		/*
		 * System.out.println("Es un numero :" +
		 * isDecimal("-123......1111222.123")); BigDecimal x = new
		 * BigDecimal("-123000.00"); System.out.println("Escribir : " + x);
		 * String str = "-123.111.122.2.123"; str = str.replaceAll(",", "\\.");
		 * System.out.println("Escribir : " + str); int pos =
		 * str.lastIndexOf("."); String decimal = str.substring(pos,
		 * str.length()); String entero = str.substring(0, pos);
		 * System.out.println("entero: " + entero); System.out.println(
		 * "decimal: " + decimal); entero = entero.replaceAll("\\.", "");
		 * System.out.println(entero + decimal);
		 */
		String str = "-00";
		boolean b = isDecimal("00001,00");
		Double d = Double.parseDouble("00001054.00");
		System.out.println("El valor es: " + d);
	}
}
