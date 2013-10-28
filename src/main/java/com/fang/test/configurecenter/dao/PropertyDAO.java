package com.fang.test.configurecenter.dao;

import java.util.List;

import com.fang.test.configurecenter.vo.Property;
import com.fang.test.configurecenter.vo.PropertySet;

public interface PropertyDAO {

	void createProperty(Property prop);
	void deleteProperty(long id);
	Property getPropertyById(long id);
	void updateProperty(Property prop);
}
