package com.fang.test.configurecenter.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.fang.test.configurecenter.dao.UserDAO;
import com.fang.test.configurecenter.vo.User;

@Repository("userDAO")
public class HibernateUserDAO extends AbstractHibernateDAO implements UserDAO {

	@Override
	public void createUser(User user) {
		Long id = (Long) currentSession().save(user);
		user.setId(id);
	}

	@Override
	public void deleteUserById(long id) {
		User detail = (User) currentSession().load(User.class, id);
		currentSession().delete(detail);

	}

	@Override
	public User getUserById(long id) {
		return (User) currentSession().get(User.class, id);
	}

	@Override
	public void updateUser(User user) {
		currentSession().update(user);

	}

	@Override
	public User getUserByName(String id) {
		Criteria criteria = currentSession().createCriteria(User.class);
		User user = (User) criteria.add(Restrictions.eq("name", id))
				.setReadOnly(true).uniqueResult();

		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllUserNames() {
		return currentSession().createCriteria(User.class)
				.setProjection(Projections.property("name")).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> searchUserNames(String match) {

		return currentSession().createCriteria(User.class)
				.setProjection(Projections.property("name"))
				.add(Restrictions.ilike("name", match, MatchMode.ANYWHERE))
				.list();
	}

}
