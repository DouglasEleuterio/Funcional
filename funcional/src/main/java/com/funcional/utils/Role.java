package com.funcional.utils;

public enum Role {

	ROLE_ADMIN ("ROLE_ADMIN"),
	ROLE_COMMOM ("ROLE_COMMON");
	
	private String value;
	
	private Role (String value) {
		this.value = value;
	}
	
	public String getValue () {
		return value;
	}
}
