package com.fang.test.configurecenter.form;

import com.fang.test.configurecenter.misc.PermissionUtil;
import com.fang.test.configurecenter.vo.PropertySet;

public class PropertySetAcccessInfo {
	private long nameSpaceId;
	private Long id;
	private String name;
	private boolean currentReadable;
	private boolean currentWritable;

	public PropertySetAcccessInfo() {

	}
	
	public PropertySetAcccessInfo(PropertySet ps, Long userId) {
		if (ps != null) {
			this.id = ps.getId();
			this.name = ps.getName();
			this.nameSpaceId = ps.getNameSpace().getId();
			this.setCurrentReadable(PermissionUtil.isUserReadable(userId, ps.getPermissions(), ps.getOwner(), ps.getUserGroup()));
			this.setCurrentWritable(PermissionUtil.isUserWritable(userId, ps.getPermissions(), ps.getOwner(), ps.getUserGroup()));
		}
	}

	public long getNameSpaceId() {
		return nameSpaceId;
	}

	public void setNameSpaceId(long nameSpaceId) {
		this.nameSpaceId = nameSpaceId;
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
