package com.fang.test.configurecenter.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.fang.test.configurecenter.dao.PropertySetDAO;
import com.fang.test.configurecenter.vo.PropertySet;

@Repository("propertySetDAO")
public class HibernatePropertySetDAO extends AbstractHibernateDAO implements
		PropertySetDAO {

	@Override
	public void createPropertySet(PropertySet propertySet) {
		Long id = (Long) currentSession().save(propertySet);
		propertySet.setId(id);

	}

	@Override
	public void deletePropertySet(long id) {
		PropertySet detail = (PropertySet) currentSession().load(PropertySet.class, id);
		currentSession().delete(detail);

	}

	@Override
	public PropertySet getPropertySetById(long id) {
		return (PropertySet) currentSession().get(PropertySet.class, id);
	}

	@Override
	public void updatePropertySet(PropertySet prop) {
		currentSession().save(prop);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PropertySet> getPropertySetsByNameSpaceId(
			long nameSpaceId) {
		Criteria criteria = currentSession().createCriteria(PropertySet.class);
		
			criteria.add(Restrictions.eq("nameSpace.id", nameSpaceId));
		return criteria.list();
	}

}
