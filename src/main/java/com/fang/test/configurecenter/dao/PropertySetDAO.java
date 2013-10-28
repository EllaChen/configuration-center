package com.fang.test.configurecenter.dao;

import java.util.List;

import com.fang.test.configurecenter.vo.PropertySet;

public interface PropertySetDAO {

	void createPropertySet(PropertySet propertySet);
	void deletePropertySet(long id);
	PropertySet getPropertySetById(long id);
	void updatePropertySet(PropertySet prop);
	List<PropertySet> getPropertySetsByNameSpaceId(long nameSpaceId);
}
