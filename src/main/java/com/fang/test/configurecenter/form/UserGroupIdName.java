package com.fang.test.configurecenter.form;

import com.fang.test.configurecenter.vo.UserGroup;

public class UserGroupIdName {

	private Long id;
	private String name;
	
	
	public UserGroupIdName(){
		
	}
	
	public UserGroupIdName(UserGroup userGroup){
		id = userGroup.getId();
		name = userGroup.getName();
	}

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

}
