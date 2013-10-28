package com.fang.test.configurecenter.dao.hibernate;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractHibernateDAO {

	@Inject
	@Named("sessionFactory")
	private SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}
}
