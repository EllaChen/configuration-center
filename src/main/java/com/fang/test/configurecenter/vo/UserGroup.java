package com.fang.test.configurecenter.vo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name="USERGROUPS")
@DynamicUpdate()
public class UserGroup {
	
	@Id
	@GeneratedValue()
	private Long id;
	
	@Column(updatable=false)
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "OWNER_ID")
	private User owner;
	
	public Set<GroupItem> getItems() {
		return items;
	}
	public void setItems(Set<GroupItem> items) {
		this.items = items;
	}
	@OneToMany(mappedBy="userGroup",cascade={CascadeType.ALL },orphanRemoval=true)
	private Set<GroupItem> items = new HashSet<GroupItem>();
	
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
	
	public boolean equals(Object obj){
		UserGroup usr = (obj != null && obj instanceof UserGroup? (UserGroup)obj: null);
		//Name can never be null
		if(usr != null && name.equalsIgnoreCase(usr.getName())){
			return true;
		}
		
		return false;
	}
	
	public int hashCode(){
		return name.hashCode();
	}
}
