package com.funcional.business;

import com.funcional.dao.ProfileDao;
import com.funcional.dao.utils.DAOFactory;
import com.funcional.model.Profile;

public class ProfileBusiness {

	private ProfileDao profileDao;

	
	public ProfileBusiness() {
		super();
		setProfileDao(DAOFactory.createProfile());
	}

	private void setProfileDao(ProfileDao profileDao) {
		this.profileDao = profileDao;
	}

	public void save(Profile profile) {
		profileDao.save(profile);
	}
}
// Na linha 9 é definido uma referência a um ProfileDao. 
//Essa referência é “setada” com um objeto ProfileDao no construtor da classe na linha 14.
