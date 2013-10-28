package com.fang.test.configurecenter.controller;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fang.test.configurecenter.form.PropertySetDetail;
import com.fang.test.configurecenter.form.PropertySetSummary;
import com.fang.test.configurecenter.form.PropertySetAcccessInfo;
import com.fang.test.configurecenter.services.PropertySetService;
import com.fang.test.configurecenter.vo.Property;
import com.fang.test.configurecenter.vo.PropertySet;

@Controller
public class PropertySetController extends BaseErrorHandlerController {

	@Inject
	@Named("userAuthUtils")
	private UserAuthUtils utils;

	@Inject
	@Named("propertySetService")
	private PropertySetService psService;

	@RequestMapping(value = { "/createPropertySet" }, method = RequestMethod.GET)
	public String showCreatePage(@RequestParam("id") long id, ModelMap model, HttpServletRequest request) {
		PropertySetDetail detail = new PropertySetDetail();
		if (utils.getUser(request) != null) {
			detail.setOwner(utils.getUser(request).getUsername());
		}
		detail.setNameSpaceId(id);
		model.put("propertySet", detail);
		model.put("act", "create");
		return "editPropertySet";
	}
	
	@RequestMapping(value = { "/editPropertySet" }, params = "act=create", method = RequestMethod.POST)
	public String creatNameSpace(PropertySetDetail detail,
			HttpServletRequest request, ModelMap model) {
		psService.createPropertySet(detail);
		model.put("propertySet", detail);
		model.put("act", "update");
		model.put("message", "Property set has been created sucessfully! Please refresh page to get it shown on the left.");
		return "editPropertySet";
	}
	
	@RequestMapping(value = { "/editPropertySet" }, params = "act=update", method = RequestMethod.POST)
	public String updatePropertySet(PropertySetSummary detail,
			HttpServletRequest request, ModelMap model) {
		psService.updatePropertySet(detail);
		model.put("propertySet", detail);
		model.put("act", "update");
		model.put("message", "Property set has been created sucessfully! Please refresh page to get it shown on the left.");
		return "editPropertySetProfile";
	}
	
	@RequestMapping(value = { "/viewPropertySet" }, method ={RequestMethod.POST,RequestMethod.GET})
	public String showViewPropertySet(@RequestParam("id") long id,
			HttpServletRequest request, ModelMap model) {
		PropertySetDetail detail = psService.getPropertySet(id, utils.getUserId(request));
		if(detail == null){
			throw new RuntimeException("Could not find property set: " + id);
		}
		model.put("propertySet", detail);
		if(detail.isCurrentWritable()){
			model.put("act", "update");
			return "editPropertySet";
		}else{
			return "viewPropertySet";
		}
	}
	
	
	@RequestMapping(value = { "/editProperty" }, params = "act=update", method = RequestMethod.POST)
	public @ResponseBody Property updateProperty(Property detail,@RequestParam(value="propertySetId", required=true) long id, 
			HttpServletRequest request, ModelMap model) {
		PropertySet ps = new PropertySet();
		ps.setId(id);
		detail.setPropertySet(ps);
		Property p = psService.updateProperty(detail);
		return p;
	}
	
	@RequestMapping(value = { "/editProperty" }, params = "act=create", method = RequestMethod.POST)
	public @ResponseBody Property createProperty(Property detail,@RequestParam(value="propertySetId", required=true) long id,
			HttpServletRequest request, ModelMap model) {
		PropertySet ps = new PropertySet();
		ps.setId(id);
		detail.setPropertySet(ps);
		Property p = psService.addProperty(detail);
		return p;
	}
	
	@RequestMapping(value = { "/deleteProperty" },method = RequestMethod.POST)
	public @ResponseBody String createProperty(long id,
			HttpServletRequest request, ModelMap model) {
		psService.deleteProperty(id);
		return "Property has been deleted successfully!";
	}
	
	@RequestMapping(value = { "/listPropertySets" }, method = RequestMethod.GET)
	public @ResponseBody List<PropertySetAcccessInfo> listPropertySets(@RequestParam("id") long id, ModelMap model, HttpServletRequest request) {
		List<PropertySetAcccessInfo> list = psService.getAllPropertySetForUser(id, utils.getUserId(request));
		return list;
	}

}
