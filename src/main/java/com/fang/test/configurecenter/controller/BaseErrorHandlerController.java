package com.fang.test.configurecenter.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class BaseErrorHandlerController {

	@ExceptionHandler(CannotCreateTransactionException.class)
	public ModelAndView handleDBConnectionException(CannotCreateTransactionException ex) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("error", "Could not connect to database. Please contact support.");
		
		return new ModelAndView("errorView", model);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ModelAndView handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("error", "Could not create duplicate data.");
		
		return new ModelAndView("errorView", model);
	}
	
	@ExceptionHandler(IllegalStateException.class)
	public ModelAndView handleIllegalStateException(IllegalStateException ex) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("error", ex.getLocalizedMessage());
		return new ModelAndView("errorView", model);
	}
}
