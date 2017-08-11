package com.funcional.dao;

import com.funcional.model.User;

public interface UserDao {

	public boolean existValidation(String validation);
	public void save (User user);
}
