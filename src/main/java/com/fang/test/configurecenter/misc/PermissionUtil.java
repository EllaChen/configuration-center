package com.fang.test.configurecenter.misc;

import com.fang.test.configurecenter.vo.GroupItem;
import com.fang.test.configurecenter.vo.Permissions;
import com.fang.test.configurecenter.vo.User;
import com.fang.test.configurecenter.vo.UserGroup;

public class PermissionUtil {

	public static boolean isUserReadable(Long userId, Permissions pem,
			User owner, UserGroup userGroup) {
		boolean readable = false;
		if (pem.isOtherUserReadable()) {
			readable = true;
		}else if (userId != null) {
			if (owner.getId() == userId && pem.isOwnerReadable()) {
				readable = true;
			} else {
				if (userGroup != null && pem.isGroupUserReadable()) {
					for (GroupItem item : userGroup.getItems()) {
						if (item.getUser().getId() == userId) {
							readable = true;
							break;
						}
					}
				}
			}
		}
		return readable;
	}

	public static boolean isUserWritable(Long userId, Permissions pem,
			User owner, UserGroup userGroup) {
		boolean writable = false;
		if (pem.isOtherUserWritable()) {
			writable = true;
		}else if (userId != null) {
			if (owner.getId() == userId && pem.isOwnerWritable()) {
				writable = true;
			} else {
				if (userGroup != null && pem.isGroupUserWritable()) {
					for (GroupItem item : userGroup.getItems()) {
						if (item.getUser().getId() == userId) {
							writable = true;
							break;
						}
					}
				}
			}
		}
		return writable;
	}
}
