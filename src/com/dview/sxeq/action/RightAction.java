package com.dview.sxeq.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.dview.sxeq.service.RightManager;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("rightAction")
@Scope(value = "prototype")
public class RightAction extends ActionSupport {

	private RightManager rightManager;

	public RightManager getRightManager() {
		return rightManager;
	}

	@Autowired
	public void setRightManager(RightManager rightManager) {
		this.rightManager = rightManager;
	}
	
	public String rightList(){
		ServletActionContext.getRequest().setAttribute("rights", rightManager.rightList());
		return "rightList";
	}
}
