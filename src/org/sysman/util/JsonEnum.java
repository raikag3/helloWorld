package org.sysman.util;

public enum JsonEnum {
	
DEFAULT("elementos","elemento");
	
	private final String base;
	private final String container;
	
	private JsonEnum(String base, String container) {
		this.base       = base;
		this.container = container;
	}

	public String getBase() {
		return base;
	}

	public String getContainer() {
		return container;
	}
}
