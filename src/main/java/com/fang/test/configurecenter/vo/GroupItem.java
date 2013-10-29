package com.fang.test.configurecenter.vo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="GROUPITEMS")
public class GroupItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "USERGROUP_ID")
	private UserGroup userGroup;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private User user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserGroup getUserGroup() {
		return userGroup;
	}
	
	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public boolean equals(Object obj){
		GroupItem item = (obj != null && obj instanceof GroupItem? (GroupItem)obj: null);
		//Name can never be null
		if(item != null && user.equals(item.user) && userGroup.equals(item.getUserGroup())){
			return true;
		}
		
		return false;
	}
	
	public int hashCode(){
		return user.hashCode() + 23* userGroup.hashCode();
	}
	
}
