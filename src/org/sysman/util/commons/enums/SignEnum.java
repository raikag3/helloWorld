package org.sysman.util.commons.enums;

public enum SignEnum {
	
	QUESTION("?"),
	AMPERSAND("&"),
	EQUAL("="),
	DOUBLE_QUOTES("\""),
	TWO_POINTS(":"),
	SPACE(" "),
	START_KEY("{"),
	END_KEY("}"),
	COMMA(",");
	
	private final String value;
	
	private SignEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}