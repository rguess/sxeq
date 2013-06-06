package com.dview.sxeq.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.dview.sxeq.model.Right;
import com.dview.sxeq.model.Role;
import com.dview.sxeq.service.RightManager;
import com.dview.sxeq.service.RoleManager;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("roleAction")
@Scope(value = "prototype")
public class RoleAction extends ActionSupport {

	private Role role;

	private RoleManager roleManager;
	
	private RightManager rightManager;

	private Long id;
	
	private List<String> rightId;
	
	public RightManager getRightManager() {
		return rightManager;
	}
	
	@Autowired
	public void setRightManager(RightManager rightManager) {
		this.rightManager = rightManager;
	}

	public List<String> getRightId() {
		return rightId;
	}

	public void setRightId(List<String> rightId) {
		this.rightId = rightId;
	}

	public String roleList() {
		ServletActionContext.getRequest().setAttribute("list",
				roleManager.roleList());
		ServletActionContext.getRequest().setAttribute("rights", rightManager.rightList());
		return "roleList";
	}
	
	public String addRole(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		if ("GET".equals(request.getMethod())) {
			List<Right> rights = roleManager.getRights();
			ServletActionContext.getRequest().setAttribute("rights", rights);
			return "getAddRolejsp";
		} else {
			List<Right> rights = new ArrayList<Right>();
			for (String id:rightId) {
				rights.add(rightManager.getRightById(Long.valueOf(id)));
			}
			role.setRights(rights);
			role.setGenTime(new Date());
			roleManager.addRole(role);
			return "addRoleSuccess";
		}
	}
	
	public String updateRole(){
		List<Right> rights = new ArrayList<Right>();
		for (String id:rightId) {
			rights.add(rightManager.getRightById(Long.valueOf(id)));
		}
		role.setRights(rights);
		Role r = roleManager.getRoleById(role.getId());
		role.setGenTime(r.getGenTime());
		roleManager.addRole(role);
		return "addRoleSuccess";
	}
	
	public String deleteRole(){
		
		roleManager.deleteRole(id);
		return "roleDeleteSuccess";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleManager getRoleManager() {
		return roleManager;
	}

	@Autowired
	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
