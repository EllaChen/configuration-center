package com.fang.test.configurecenter.form;

import java.util.HashSet;
import java.util.Set;

import com.fang.test.configurecenter.vo.Property;
import com.fang.test.configurecenter.vo.PropertySet;

public class PropertySetDetail extends PropertySetSummary implements Cloneable{

	private Set<Property> properties = new HashSet<Property>();
	
	public PropertySetDetail(){
		super();
	}
	
	public PropertySetDetail(PropertySet set, Long userId){
		super(set, userId);
		this.properties.addAll(set.getProps());
	}

	public Set<Property> getProperties() {
		return properties;
	}

	public void setProperties(Set<Property> properties) {
		this.properties = properties;
	}
	
}
