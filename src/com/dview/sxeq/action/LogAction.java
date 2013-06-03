package com.dview.sxeq.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.dview.sxeq.model.User;
import com.dview.sxeq.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("logAction")
@Scope(value = "prototype")
public class LogAction extends ActionSupport {

	private User user;

	private UserManager userManager;

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

	public String userList() {
		ServletActionContext.getRequest().setAttribute("list",
				userManager.userList());
		return "userList";
	}

	public String addUser() {

		HttpServletRequest request = ServletActionContext.getRequest();
		if ("GET".equals(request.getMethod())) {
			return "getAddjsp";
		} else {
			userManager.addUser(user, departmentName, roleName);
			return "addUserSuccess";
		}
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
}
