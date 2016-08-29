/*
* DateUtility
*
* 1.0
*
* 12/08/2016
*
* Copyright Stefanini Sysman
*/
package org.sysman.util;

import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.sysman.util.commons.enums.DateFormatEnum;
 
/**
 * @author Erwin Jose Tirado Baldovino
 * 
 * @version 1.0
 * 
 * Clase utilitaria que permite hacer validaciones, conversiones y formateo de fechas.
 */
public class DateUtility {
	
	/**
	 * Formatea una fecha suministrada para ser convertida de acuerdo al Timezone origen y
	 * al Timezone de destino que se haya suminisitrado. Dicho todo toma en cuenta no
	 * solo la zona horaria sino el cambio de horario de las mismas.
	 */
	public static Date toDateByTimezone(Date date, TimeZone source , TimeZone target) {  
		System.out.println("Current Date is: " +date);
        long sourceDst = 0;  
        if(source.inDaylightTime(date)) {  
            sourceDst = source.getDSTSavings();  
        }  
  
        long sourceOffset = source.getRawOffset() + sourceDst;  
  
        long targetDst = 0;  
        if(target.inDaylightTime(date)) {  
            targetDst = target.getDSTSavings();  
        }  
        long targetOffset = target.getRawOffset() + targetDst;  
  
        return new Date(date.getTime() + (targetOffset - sourceOffset));  
    }
	
	/**
	 * Valida si la cadena de caracteres (String) suministrado cumple con un 
	 * patron de fecha especificado en el segundo parametro (DateFormatEnum)
	 */
	public static boolean isDate(String inputDate, DateFormatEnum dfe) {
		Matcher m = Pattern.compile(dfe.getRegExp()).matcher(inputDate);
		if (m.matches()) {
			return true;
		}
		return false;
	}
	
	public static void main(String... s) {
		//Date date = toDateByTimezone(new Date(), TimeZone.getTimeZone("America/Bogota"), TimeZone.getTimeZone("Europe/Paris"));
		System.out.println("La fecha es:  " +isDate("31/11/2016 12:30:25 a", DateFormatEnum.DEFAULT));
	}
}
