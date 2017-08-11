package com.funcional.dao;

import org.hibernate.Session;

import com.funcional.model.Profile;

public class ProfileImpl implements ProfileDao {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void save(Profile profile) {
		this.session.saveOrUpdate(profile);
	}

}
