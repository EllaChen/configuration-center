package com.fang.test.configurecenter.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.fang.test.configurecenter.dao.UserGroupDAO;
import com.fang.test.configurecenter.vo.UserGroup;

@Repository("userGroupDAO")
public class HibernateUserGroupDAO extends AbstractHibernateDAO implements
		UserGroupDAO {

	@Override
	public void createUserGroup(UserGroup customer) {
		Long id = (Long) currentSession().save(customer);
		customer.setId(id);

	}

	@Override
	public void deleteUserGroup(long id) {
		UserGroup g = (UserGroup) currentSession().load(UserGroup.class, id);
		currentSession().delete(g);

	}

	@Override
	public UserGroup getUserGroupById(long id) {
		Session session = currentSession();
		UserGroup ret = (UserGroup) session.get(UserGroup.class, id);
		return ret;
	}

	@Override
	public void updateUserGroup(UserGroup user) {
		currentSession().update(user);

	}

	@Override
	public List<UserGroup> getAllUserGroups() {
		return getUserGroupsByOwner(null);
	}

	@Override
	public List<UserGroup> getAllUserGroups(int index, int maxLength) {
		return getUserGroupsByOwner(null, index, maxLength);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserGroup> getUserGroupsByOwner(Long owner) {
		Criteria criteria = currentSession().createCriteria(UserGroup.class);
		if (owner != null) {
			criteria.add(Restrictions.eq("owner.id", owner));
		}
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserGroup> getUserGroupsByOwner(Long owner, int index,
			int maxLength) {
		Criteria criteria = currentSession().createCriteria(UserGroup.class);
		if (owner != null) {
			criteria.add(Restrictions.eq("owner.id", owner));
		}
		criteria.setFirstResult(index);
		criteria.setMaxResults(maxLength);
		return criteria.list();
	}

	@Override
	public UserGroup getUserGroupByName(String name) {
		Criteria criteria = currentSession().createCriteria(UserGroup.class);
		criteria.add(Restrictions.eq("name", name));
		return (UserGroup) criteria.uniqueResult();
	}

}
