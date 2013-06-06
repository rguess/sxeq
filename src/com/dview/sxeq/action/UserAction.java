package com.dview.sxeq.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.dview.sxeq.model.User;
import com.dview.sxeq.service.DepartmentManager;
import com.dview.sxeq.service.RoleManager;
import com.dview.sxeq.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("userAction")
@Scope(value = "prototype")
public class UserAction extends ActionSupport {

	private User user;

	private UserManager userManager;
	
	private DepartmentManager departmentManager;
	
	private RoleManager roleManager;

	private String departmentName;

	private String roleName;
	
	private Long id;

	public String login() {

		String result = this.userManager.login(user);
		if (result.equals("login_fail")) {
			ServletActionContext.getRequest().getSession().setAttribute("msg",
					"账号密码出错,请从新登录！");
		}
		return result;
	}
	
	public String loginOut(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().removeAttribute("user");
		request.removeAttribute("msg");
		request.getSession().removeAttribute("msg");
		return "loginOutSuccess";
		
	}

	public String userList() {
		ServletActionContext.getRequest().setAttribute("list",
				userManager.userList());
		return "userList";
	}

	public String addUser() {

		HttpServletRequest request = ServletActionContext.getRequest();
		if ("GET".equals(request.getMethod())) {
			request.setAttribute("departments", departmentManager.departmentList());
			request.setAttribute("roles", roleManager.roleList());
			return "getAddUserjsp";
		} else {
			userManager.addUser(user, departmentName, roleName);
			return "addUserSuccess";
		}
	}
	
	public String updateUser(){
		userManager.updateUser(user, departmentName, roleName);
		return "addUserSuccess";
	}

	public String deleteUser() {
		
		userManager.deleteUser(id);
		return "userDeleteSuccess";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	@Autowired
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DepartmentManager getDepartmentManager() {
		return departmentManager;
	}

	@Autowired
	public void setDepartmentManager(DepartmentManager departmentManager) {
		this.departmentManager = departmentManager;
	}

	public RoleManager getRoleManager() {
		return roleManager;
	}

	@Autowired
	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}
}
