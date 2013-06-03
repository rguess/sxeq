package com.dview.sxeq.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TestAction extends ActionSupport{

	
	@Override
	public String execute() throws Exception {
		
		ServletActionContext.getRequest().setAttribute("hello", "sxeq");
		return "test";
	}
}
