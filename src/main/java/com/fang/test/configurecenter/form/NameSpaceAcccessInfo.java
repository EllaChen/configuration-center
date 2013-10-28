package com.fang.test.configurecenter.form;

import com.fang.test.configurecenter.misc.PermissionUtil;
import com.fang.test.configurecenter.vo.NameSpace;


public class NameSpaceAcccessInfo {

	private Long id;
	private String name;
	private boolean currentReadable;
	private boolean currentWritable;
	
	public NameSpaceAcccessInfo(){
		
	}
	public NameSpaceAcccessInfo(NameSpace ns, Long userId){
		if (ns != null) {
			this.id = ns.getId();
			this.name = ns.getName();
			this.setCurrentReadable(PermissionUtil.isUserReadable(userId, ns.getPermissions(), ns.getOwner(), ns.getUserGroup()));
			this.setCurrentWritable(PermissionUtil.isUserWritable(userId, ns.getPermissions(), ns.getOwner(), ns.getUserGroup()));
		}
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
	public boolean isCurrentReadable() {
		return currentReadable;
	}
	public void setCurrentReadable(boolean currentReadable) {
		this.currentReadable = currentReadable;
	}
	public boolean isCurrentWritable() {
		return currentWritable;
	}
	public void setCurrentWritable(boolean currentWritable) {
		this.currentWritable = currentWritable;
	}
	
}
