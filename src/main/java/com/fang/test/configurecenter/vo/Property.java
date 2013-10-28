package com.fang.test.configurecenter.vo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="PROPS")
public class Property {

	@Id
	@GeneratedValue()
	private Long id;
	private String name;
	private String value;
	
	@Version()
	private Long version;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "SET_ID")
	private PropertySet propertySet;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public PropertySet getPropertySet() {
		return propertySet;
	}
	public void setPropertySet(PropertySet propertySet) {
		this.propertySet = propertySet;
	}
	
	
}
