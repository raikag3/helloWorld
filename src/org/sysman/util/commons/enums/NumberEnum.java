/*
* NumberEnum
*
* 1.0
*
* 12/08/2016
*
* Copyright Stefanini Sysman
*/
package org.sysman.util.commons.enums;
 
/**
 * @author Erwin Jose Tirado Baldovino
 * 
 * @version 1.0
 * 
 * Enumeracion que permite clasificar el tamanos de los tipos de datos.
 */
public enum NumberEnum {
	
	INTEGER(9),
	DOUBLE(39);
	
	private final int value;
	
	private NumberEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
