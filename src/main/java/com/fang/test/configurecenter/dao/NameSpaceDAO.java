package com.fang.test.configurecenter.dao;

import java.util.List;

import com.fang.test.configurecenter.vo.NameSpace;

public interface NameSpaceDAO {

	void createNameSpace(NameSpace customer);
	void deleteNameSpace(long id);
	NameSpace getNameSpaceById(long id);
	void updateNameSpace(NameSpace user);
	List<NameSpace> getAllNameSpaces();
	List<NameSpace> getNameSpaces(int index, int length);
}
