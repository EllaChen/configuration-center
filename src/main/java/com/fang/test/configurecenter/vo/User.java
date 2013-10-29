package com.fang.test.configurecenter.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="USERS")
@DynamicUpdate(true)
public class User implements Serializable, Cloneable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(updatable=false)
	private String name;
	private String password;
	private String email;
	private String tel;
	private String fullName;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public Object clone(){
		User detail =null;
		try {
			detail = (User) super.clone();
		} catch (CloneNotSupportedException e) {
			detail = new User();
			detail.setId(id);
			detail.setName(name);
			detail.setPassword(password);
			detail.setFullName(fullName);
			detail.setTel(tel);
			detail.setEmail(email);
		}
		
		return detail;
	}
	
	public boolean equals(Object obj){
		User usr = (obj != null && obj instanceof User? (User)obj: null);
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
