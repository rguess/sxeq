package com.dview.sxeq.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.dview.sxeq.model.Department;
import com.dview.sxeq.service.DepartmentManager;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("departmentAction")
@Scope(value = "prototype")
public class DepartmentAction extends ActionSupport {
	
	private Department department;
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	private DepartmentManager departmentManager;

	public DepartmentManager getDepartmentManager() {
		return departmentManager;
	}

	@Autowired
	public void setDepartmentManager(DepartmentManager departmentManager) {
		this.departmentManager = departmentManager;
	}

	public String departmentList() {

		ServletActionContext.getRequest().setAttribute("departments",
				departmentManager.departmentList());
		return "deparList";
	}
	
	public String addDepartment() {

		HttpServletRequest request = ServletActionContext.getRequest();
		if ("GET".equals(request.getMethod())) {
			return "getAddDepartmentjsp";
		} else {
			departmentManager.addDepartment(department);
			return "addDepartmentSuccess";
		}
	}
	
	public String deleteDepartment(){
		
		departmentManager.deleteDepartment(department.getId());
		return "departmentDeleteSuccess";
	}
}
