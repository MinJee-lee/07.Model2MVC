package com.model2.mvc.framework;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//인사부장 공유할 목적으로 추상 class로 만듬
public abstract class Action {
	
	///Field
	private ServletContext servletContext;
	
	///Constructor
	public Action() {
	}
	
	///Method
	public ServletContext getServletContext() {
		return servletContext;
	}
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public abstract String execute(HttpServletRequest request, HttpServletResponse response) throws Exception ;
}
