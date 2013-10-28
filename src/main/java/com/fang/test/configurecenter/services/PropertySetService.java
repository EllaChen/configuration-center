package com.fang.test.configurecenter.services;

import java.util.List;

import com.fang.test.configurecenter.form.PropertySetAcccessInfo;
import com.fang.test.configurecenter.form.PropertySetDetail;
import com.fang.test.configurecenter.form.PropertySetSummary;
import com.fang.test.configurecenter.vo.Property;

public interface PropertySetService {

	void createPropertySet(PropertySetSummary summary);
	void updatePropertySet(PropertySetSummary summary);
	Property addProperty(Property prop);
	Property updateProperty(Property set);
	void deleteProperty(long id);
	List<PropertySetAcccessInfo> getAllPropertySetForUser(long ns,Long id);
	PropertySetDetail getPropertySet(long setId, Long userId);
}
