package com.funcional.controller;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "activation")
@RequestScoped
public class Activation {

	@ManagedProperty(value = "#{param.key}")
	private String key;

	public boolean valid = false;

	@PostConstruct
	public void init() {
		UserBusines userBusines = new UserBusines();
		if (userBusiness.existsValidation(getKey())) {
			setValid(true);
		}
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
