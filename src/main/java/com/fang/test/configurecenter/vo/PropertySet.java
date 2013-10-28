package com.fang.test.configurecenter.vo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PROPERTYSETS")
public class PropertySet {

	@Id
	@GeneratedValue()
	private Long id;
	
	@Column(updatable=false)
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "OWNER_ID")
	private User owner;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "USERGROUP_ID")
	private UserGroup userGroup;
	
	@Embedded
	private Permissions permissions;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "NAMESPACE_ID")
	private NameSpace nameSpace;
	
	@OneToMany(mappedBy="propertySet",cascade={CascadeType.ALL },orphanRemoval=true)
	private Set<Property> props = new HashSet<Property>();

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

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	public Permissions getPermissions() {
		return permissions;
	}

	public void setPermissions(Permissions permissions) {
		this.permissions = permissions;
	}


	public NameSpace getNameSpace() {
		return nameSpace;
	}

	public void setNameSpace(NameSpace nameSpace) {
		this.nameSpace = nameSpace;
	}

	public Set<Property> getProps() {
		return props;
	}

	public void setProps(Set<Property> props) {
		this.props = props;
	}
	
}
