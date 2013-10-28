package com.fang.test.configurecenter.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fang.test.configurecenter.dao.NameSpaceDAO;
import com.fang.test.configurecenter.vo.NameSpace;

@Repository("nameSpaceDAO")
public class HibernateNameSpaceDAO extends AbstractHibernateDAO implements NameSpaceDAO {

	@Override
	public void createNameSpace(NameSpace nameSpace) {
		Long id = (Long) currentSession().save(nameSpace);
		nameSpace.setId(id);
	}

	@Override
	public void deleteNameSpace(long id) {
		NameSpace detail = (NameSpace) currentSession().load(NameSpace.class, id);
		currentSession().delete(detail);
		
	}

	@Override
	public NameSpace getNameSpaceById(long id) {
		
		return (NameSpace) currentSession().get(NameSpace.class, id);
	}

	@Override
	public void updateNameSpace(NameSpace user) {
		currentSession().update(user);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NameSpace> getAllNameSpaces() {
		return currentSession().createCriteria(NameSpace.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NameSpace> getNameSpaces(int index, int length) {
		return currentSession().createQuery("from NameSpace").setFirstResult(index).setMaxResults(length).list();
	}

}
