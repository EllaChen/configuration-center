package com.fang.test.configurecenter.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fang.test.configurecenter.dao.NameSpaceDAO;
import com.fang.test.configurecenter.dao.PropertyDAO;
import com.fang.test.configurecenter.dao.PropertySetDAO;
import com.fang.test.configurecenter.dao.UserDAO;
import com.fang.test.configurecenter.dao.UserGroupDAO;
import com.fang.test.configurecenter.form.PropertySetDetail;
import com.fang.test.configurecenter.form.PropertySetSummary;
import com.fang.test.configurecenter.form.PropertySetAcccessInfo;
import com.fang.test.configurecenter.vo.NameSpace;
import com.fang.test.configurecenter.vo.Permissions;
import com.fang.test.configurecenter.vo.Property;
import com.fang.test.configurecenter.vo.PropertySet;
import com.fang.test.configurecenter.vo.User;
import com.fang.test.configurecenter.vo.UserGroup;

@Component("propertySetService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class PropertySetServiceImpl implements PropertySetService {

	@Inject
	@Named("propertySetDAO")
	private PropertySetDAO psDAO;
	
	@Inject
	@Named("nameSpaceDAO")
	private NameSpaceDAO nsDAO;
	
	@Inject
	@Named("userGroupDAO")
	private UserGroupDAO ugDAO;
	
	@Inject
	@Named("userDAO")
	private UserDAO userDAO;
	
	@Inject
	@Named("propertyDAO")
	private PropertyDAO pDAO;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void createPropertySet(PropertySetSummary summary) {
		PropertySet ps = new PropertySet();
		this.populateBaseFields(summary, ps);
		User user = userDAO.getUserByName(summary.getOwner());
		if(user == null){
			throw new IllegalArgumentException("Cannot create property set with a non-existing owner.");
		}
		ps.setOwner(user);
		UserGroup ug= ugDAO.getUserGroupByName(summary.getUserGroup());
		if(ug == null){
			throw new IllegalArgumentException("Cannot create property set with a non-existing user group.");
		}
		ps.setUserGroup(ug);
		NameSpace ns = new NameSpace();
		ns.setId(summary.getNameSpaceId());
		ps.setNameSpace(ns);
		psDAO.createPropertySet(ps);
		summary.setId(ps.getId());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updatePropertySet(PropertySetSummary summary) {
		PropertySet ps = new PropertySet();
		this.populateBaseFields(summary, ps);
		User user = userDAO.getUserByName(summary.getOwner());
		if(user == null){
			throw new IllegalArgumentException("Cannot update property set with a non-existing owner.");
		}
		ps.setOwner(user);
		UserGroup ug= ugDAO.getUserGroupByName(summary.getUserGroup());
		if(ug == null){
			throw new IllegalArgumentException("Cannot update property set with a non-existing user group.");
		}
		ps.setUserGroup(ug);
		NameSpace ns = new NameSpace();
		ns.setId(summary.getNameSpaceId());
		ps.setNameSpace(ns);
		psDAO.updatePropertySet(ps);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Property addProperty(Property prop) {
		pDAO.createProperty(prop);
		return prop;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Property updateProperty(Property prop) {
		pDAO.updateProperty(prop);
		return prop;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteProperty(long id) {
		pDAO.deleteProperty(id);

	}

	protected void populateBaseFields(PropertySetSummary summary, PropertySet ps) {

		ps.setId(summary.getId());
		ps.setName(summary.getName());
		ps.setPermissions(new Permissions(summary.isOwnerWritable(), summary
				.isOwnerReadable(), summary.isGroupUserWritable(), summary
				.isGroupUserReadable(), summary.isOthersWritable(), summary
				.isOthersReadable()));
	}

	@Override
	public List<PropertySetAcccessInfo> getAllPropertySetForUser(long ns,
			Long id) {
		List<PropertySetAcccessInfo> ret = new ArrayList<PropertySetAcccessInfo>();
		List<PropertySet> pss = psDAO.getPropertySetsByNameSpaceId(ns);
		for(PropertySet ps: pss){
			PropertySetAcccessInfo info = new PropertySetAcccessInfo(ps, id);
			ret.add(info);
		}
		return ret;
	}

	@Override
	public PropertySetDetail getPropertySet(long setId, Long userId) {
		PropertySet ps = psDAO.getPropertySetById(setId);
		if(ps != null){
			return new PropertySetDetail(ps, userId);
		}
		return null;
	}

}
