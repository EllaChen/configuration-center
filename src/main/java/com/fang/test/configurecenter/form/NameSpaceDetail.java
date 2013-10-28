package com.fang.test.configurecenter.form;

import com.fang.test.configurecenter.vo.NameSpace;

public class NameSpaceDetail extends NameSpaceAcccessInfo {

	private String owner;
	private String userGroup;
	private boolean ownerWritable;
	private boolean ownerReadable;
	private boolean groupUserWritable;
	private boolean groupUserReadable;
	private boolean othersWritable;
	private boolean othersReadable;

	public NameSpaceDetail() {

	}

	public NameSpaceDetail(NameSpace ns, Long userId) {
		super(ns, userId);
		if (ns != null) {
			this.owner = ns.getOwner().getName();
			this.userGroup = ns.getUserGroup().getName();

			this.ownerWritable = ns.getPermissions().isOwnerWritable();
			this.ownerReadable = ns.getPermissions().isOwnerReadable();

			this.groupUserWritable = ns.getPermissions().isGroupUserWritable();
			this.groupUserReadable = ns.getPermissions().isGroupUserReadable();

			this.othersWritable = ns.getPermissions().isOtherUserWritable();
			this.othersReadable = ns.getPermissions().isOtherUserReadable();
		}

	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public boolean isOwnerWritable() {
		return ownerWritable;
	}

	public void setOwnerWritable(boolean ownerWritable) {
		this.ownerWritable = ownerWritable;
	}

	public boolean isOwnerReadable() {
		return ownerReadable;
	}

	public void setOwnerReadable(boolean ownerReadable) {
		this.ownerReadable = ownerReadable;
	}

	public boolean isGroupUserWritable() {
		return groupUserWritable;
	}

	public void setGroupUserWritable(boolean groupUserWritable) {
		this.groupUserWritable = groupUserWritable;
	}

	public boolean isGroupUserReadable() {
		return groupUserReadable;
	}

	public void setGroupUserReadable(boolean groupUserReadable) {
		this.groupUserReadable = groupUserReadable;
	}

	public boolean isOthersWritable() {
		return othersWritable;
	}

	public void setOthersWritable(boolean othersWritable) {
		this.othersWritable = othersWritable;
	}

	public boolean isOthersReadable() {
		return othersReadable;
	}

	public void setOthersReadable(boolean othersReadable) {
		this.othersReadable = othersReadable;
	}

}
