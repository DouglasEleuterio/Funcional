package com.funcional.dao.utils;

import com.funcional.dao.ProfileDao;
import com.funcional.dao.ProfileImpl;
import com.funcional.dao.UserDao;
import com.funcional.dao.UserImpl;

public class DAOFactory {
	
	public static ProfileDao createProfile() {
		ProfileImpl profileDaoImpl = new ProfileImpl();
		profileDaoImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return profileDaoImpl;
	}
	
	 public static UserDao createUser(){
	        UserImpl userImpl = new UserImpl();
	        userImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
	        return userImpl;
	    }
}
