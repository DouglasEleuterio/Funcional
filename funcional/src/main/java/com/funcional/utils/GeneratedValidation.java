package com.funcional.utils;

import java.util.Date;
import java.util.UUID;

public class GeneratedValidation {

	
	public static String keyValidation() {
		
		UUID uuid = UUID.randomUUID();
		return uuid.toString().toUpperCase().replace('_','X')
				+ String.valueOf((new Date()).getTime());
	}
}
