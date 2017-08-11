package com.funcional.controller.initial;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class Index {
	
	@PostConstruct
	public void initi () {
		System.out.println("Bean Executado!");
		System.out.println("Metodo PostContruct");	
	}
	
	public String getMessage() {
		return "Hello word JSF";
	}
	
	public String register() {
		return "/public/register.xhtml";
	}
	
}
