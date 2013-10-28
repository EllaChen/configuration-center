package com.fang.test.configurecenter.dao.hibernate;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.fang.test.configurecenter.dao.PropertyDAO;
import com.fang.test.configurecenter.vo.Property;

@Repository("propertyDAO")
public class HibernatePropertyDAO extends AbstractHibernateDAO implements
		PropertyDAO {

	@Override
	public void createProperty(Property prop) {
		Long id = (Long) currentSession().save(prop);
		prop.setId(id);
	}

	@Override
	public void deleteProperty(long id) {
		Property p = (Property) currentSession().load(Property.class, id);
		currentSession().delete(p);

	}

	@Override
	public Property getPropertyById(long id) {
		return (Property) currentSession().get(Property.class, id);
	}

	@Override
	public void updateProperty(Property prop) {
		Session session = currentSession();
		
		Property newProp = new Property();
		session.load(newProp, prop.getId());//load it to get the @version work
		newProp.setValue(prop.getValue());
		
		currentSession().update(newProp);

	}

}
