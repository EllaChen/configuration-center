package com.fang.test.configurecenter.vo;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="NAMESPACES")
@DynamicUpdate
public class NameSpace {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable=false)
	private String name;
	
	@Embedded
	private Permissions permissions;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "OWNER_ID")
	private User owner;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "USERGROUP_ID")
	private UserGroup userGroup;

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

	public Permissions getPermissions() {
		return permissions;
	}

	public void setPermissions(Permissions permission) {
		this.permissions = permission;
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
	
	
}
