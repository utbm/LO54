package com.mycompany.sp4.webapp.infrastructure.exceptions;

import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;

public class CustomMappingExceptionResolver extends SimpleMappingExceptionResolver {

	public CustomMappingExceptionResolver() {
		setDefaultErrorView("error");
		setExceptionAttribute("ex");
		setWarnLogCategory("com.mycompany.sp4.MvcLogger");
	}

	@Override
	public String buildLogMessage(Exception e, HttpServletRequest req) {
		return "MVC exception for " + req.getRequestURL() + ": " + e.getLocalizedMessage();
	}
}
