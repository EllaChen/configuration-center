package com.fang.test.configurecenter.services;

import java.util.List;

import com.fang.test.configurecenter.form.NameSpaceDetail;
import com.fang.test.configurecenter.form.NameSpaceAcccessInfo;

public interface NameSpaceService {

	List<NameSpaceAcccessInfo> getAllNameSpacesForUser(Long id);
	void createNameSpace(NameSpaceDetail ns);
	void updateNameSpace(NameSpaceDetail ns);
	NameSpaceDetail getNameSpace(long id, Long userId);
}
