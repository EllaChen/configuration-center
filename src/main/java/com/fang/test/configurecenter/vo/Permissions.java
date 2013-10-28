package com.fang.test.configurecenter.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Permissions {

	@Column(name = "PERMISSION")
	private byte permissions;
	
	public Permissions(){
		
	}
	
	public Permissions(boolean ownerWrite, boolean ownerRead, boolean groupWrite, boolean groupRead, boolean otherWrite, boolean otherRead){
		if(ownerWrite){
			permissions = (byte)(permissions|0x20);
		}
		
		if(ownerRead){
			permissions = (byte)(permissions|0x10);
		}
		
		if(groupWrite){
			permissions = (byte)(permissions|0x08);
		}
		
		if(groupRead){
			permissions = (byte)(permissions|0x04);
		}
		
		if(otherWrite){
			permissions = (byte)(permissions|0x02);
		}
		
		if(otherRead){
			permissions = (byte)(permissions|0x01);
		}
	}

	public byte getPermissions() {
		return permissions;
	}

	public void setPermissions(byte permissions) {
		this.permissions = permissions;
	}

	public boolean isOwnerWritable() {
		return (permissions & 0x20) > 0;
	}

	public boolean isOwnerReadable() {
		return (permissions & 0x10) > 0;
	}

	public boolean isGroupUserWritable() {
		return (permissions & 0x08) > 0;
	}

	public boolean isGroupUserReadable() {
		return (permissions & 0x04) > 0;
	}

	public boolean isOtherUserWritable() {
		return (permissions & 0x02) > 0;
	}

	public boolean isOtherUserReadable() {
		return (permissions & 0x01) > 0;
	}

}
