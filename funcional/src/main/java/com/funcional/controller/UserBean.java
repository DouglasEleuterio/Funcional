package com.funcional.controller;

import java.security.Provider.Service;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.funcional.security.*;
import com.funcional.utils.GeneratedValidation;
import com.funcional.utils.ManipulateDate;
import com.funcional.utils.SimpleRegistrationService;
import com.funcional.business.ProfileBusiness;
import com.funcional.model.Profile;
import com.funcional.model.User;


@ManagedBean (name="user")
@RequestScoped
public class UserBean {

	private User user = null;
	private Profile profile = null;
	
	private int day = 0;
	private int month = 0;
	private int year = 0;
	
	@PostConstruct
	public void init() {
		user = new User();
		profile = new Profile();
	}
		
	public String save () {
		
		ProfileBusiness profileBusines = new ProfileBusiness();
		user.setPassword(GeneratedMD5.generate(user.getPassword()));
		user.setValidation(GeneratedValidation.keyValidation());
		user.getPermissions().add(com.funcional.utils.Role.ROLE_COMMOM.getValue());
		user.setActive(false);
		
		profile.setUser(user);
		profile.setBirth(ManipulateDate.getDate(year,month,day));
		profileBusines.save(profile);
		
		/*
		 * Enviar o Email para o usuario no ato do cadastro para validação.
		 */
		SimpleRegistrationService mail = (SimpleRegistrationService) ServiceFinder.findBean("registrationService");
		mail.registrer(profile);
		
		return "/public/feedback_login";
	}

	public Map<String, Object> getMonths(){
		return ManipulateDate.getMonths();
	}
	
	public Map<String, Object> getYears(){
		return ManipulateDate.getYears();
	}
	
	public Map<String, Object> getDays(){
		return ManipulateDate.getDays();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
	
}
