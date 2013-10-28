package com.fang.test.configurecenter.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fang.test.configurecenter.dao.NameSpaceDAO;
import com.fang.test.configurecenter.dao.UserDAO;
import com.fang.test.configurecenter.dao.UserGroupDAO;
import com.fang.test.configurecenter.form.NameSpaceDetail;
import com.fang.test.configurecenter.form.NameSpaceAcccessInfo;
import com.fang.test.configurecenter.vo.NameSpace;
import com.fang.test.configurecenter.vo.Permissions;
import com.fang.test.configurecenter.vo.User;
import com.fang.test.configurecenter.vo.UserGroup;

@Component("nameSpaceService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class NameSpaceServiceImpl implements NameSpaceService {

	@Inject
	@Named("nameSpaceDAO")
	private NameSpaceDAO nsDAO;
	
	@Inject
	@Named("userDAO")
	private UserDAO userDAO;
	
	
	@Inject
	@Named("userGroupDAO")
	private UserGroupDAO usrGrpDAO;

	@Override
	public List<NameSpaceAcccessInfo> getAllNameSpacesForUser(Long id) {
		List<NameSpaceAcccessInfo> ret = new ArrayList<NameSpaceAcccessInfo>();
		List<NameSpace> nss = nsDAO.getAllNameSpaces();
		for (NameSpace ns : nss) {
			NameSpaceAcccessInfo info = new NameSpaceAcccessInfo(ns, id);
			ret.add(info);
		}
		return ret;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void createNameSpace(NameSpaceDetail detail) {
		NameSpace ns = new NameSpace();
		populateBaseFields(detail, ns);
		User user = userDAO.getUserByName(detail.getOwner());
		if(user == null){
			throw new IllegalArgumentException("Cannot create workspace with a non-existing owner.");
		}
		ns.setOwner(user);
		UserGroup ug= usrGrpDAO.getUserGroupByName(detail.getUserGroup());
		if(ug == null){
			throw new IllegalArgumentException("Cannot create workspace with a non-existing user group.");
		}
		ns.setUserGroup(ug);
		nsDAO.createNameSpace(ns);
		detail.setId(ns.getId());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateNameSpace(NameSpaceDetail detail) {
		NameSpace ns = new NameSpace();
		populateBaseFields(detail, ns);
		User user = userDAO.getUserByName(detail.getOwner());
		if(user == null){
			throw new IllegalArgumentException("Cannot update workspace with a non-existing owner.");
		}
		ns.setOwner(user);
		UserGroup ug= usrGrpDAO.getUserGroupByName(detail.getUserGroup());
		if(ug == null){
			throw new IllegalArgumentException("Cannot update workspace with a non-existing user group.");
		}
		ns.setUserGroup(ug);
		nsDAO.updateNameSpace(ns);
	}
	
	@Override
	public NameSpaceDetail getNameSpace(long id,  Long userId){
		NameSpace ns = nsDAO.getNameSpaceById(id);
		if(ns != null){
			return new NameSpaceDetail(ns, userId);
		}
		return null;
	}

	protected void populateBaseFields(NameSpaceDetail detail, NameSpace ns) {
		
		ns.setId(detail.getId());
		ns.setName(detail.getName());
		ns.setPermissions(new Permissions(detail.isOwnerWritable(), detail
				.isOwnerReadable(), detail.isGroupUserWritable(), detail
				.isGroupUserReadable(), detail.isOthersWritable(), detail
				.isOthersReadable()));
	}

}
