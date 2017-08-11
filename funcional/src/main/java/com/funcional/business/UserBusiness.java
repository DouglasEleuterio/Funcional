package com.funcional.business;

import com.funcional.dao.UserDao;
import com.funcional.dao.utils.DAOFactory;

public class UserBusiness {

	private UserDao userDao;
	
	public UserBusiness() {
		super();
		setUserDao(DAOFactory.createUser());
	}
	
	public boolean existValidation(String validation) {
		return userDao.existValidation(validation);
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		
	}
}
