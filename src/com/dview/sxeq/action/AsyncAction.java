package com.dview.sxeq.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.dview.sxeq.model.Department;
import com.dview.sxeq.model.Role;
import com.dview.sxeq.model.User;
import com.dview.sxeq.service.DepartmentManager;
import com.dview.sxeq.service.LogManager;
import com.dview.sxeq.service.RightManager;
import com.dview.sxeq.service.RoleManager;
import com.dview.sxeq.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 系统需要异步功能处理类
 * @author renzp
 *
 */
@SuppressWarnings("serial")
@Component("asyncAction")
@Scope(value = "prototype")
public class AsyncAction extends ActionSupport {

	private User user;

	private UserManager userManager;
	
	private DepartmentManager departmentManager;
	
	private RoleManager roleManager;

	private String departmentName;

	private String roleName;
	
	private Long id;
	
	private Map<String, Object> dataMap = new HashMap<String, Object>();

	private RightManager rightManager;
	
	private LogManager logManager;
	
	private int offset;
	
	private int length;
	
	/*
	 * 根据ID删除日志
	 */
	public String deleteLogById(){
		dataMap.clear();
		logManager.deleteLog(id);
		dataMap.put("message", "删除成功");
		return "success";
	}
	
	/*
	 * 获取某用户的权限
	 */
	
	public String userRightList(){
		dataMap.clear();
		Role role = roleManager.getRoleById(id);
		if(null != role){
			dataMap.put("rights", role.getRights());
		}else{
			dataMap.put("rights", "no");
		}
		return "success";
	}
	
	/*
	 * loginId是否存在,存在为true，不存在为false
	 */
	public String loginIdIsExit(){
		dataMap.clear();
		dataMap.put("isExit", userManager.checkLoginIsExit(user.getLoginId()));
		return "success";
	}
	
	/*
	 * 日志条数
	 */
	public String getLogCount(){
		dataMap.clear();
		dataMap.put("count", logManager.count(null, null));
		return "success";
	}	
	
	/*
	 * 获取日志内容(分页)
	 */
	public String getLogs(){
		dataMap.clear();
		dataMap.put("logs", logManager.listForPageByHql("from Log",offset,length));
		return "success";
	}
	
	/*
	 * 根据ID获取用户
	 */
	public String getUserById() {
		
		dataMap.clear();
		User user = userManager.getUserById(id);
		dataMap.put("user", user);
		return "success";
	}
	
	/*
	 * 根据ID获取角色
	 */
	public String getRoleById(){
		
		dataMap.clear();
		Role role = roleManager.getRoleById(id);
		dataMap.put("role", role);
		return "success";
	}
	
	/*
	 * 获取部门信息
	 */
	public String departmentList(){
		
		dataMap.clear();
		List<Department> departments = departmentManager.departmentList();
		dataMap.put("departments", departments);
		return "success";
	}
	
	/*
	 * 获取角色信息
	 */
	public String roleList(){
		dataMap.clear();
		dataMap.put("roles", roleManager.roleList());
		return "success";
	}
	
	/*
	 * 获取权限信息
	 */
	public String rightList(){
		dataMap.clear();
		dataMap.put("rights", rightManager.rightList());
		return "success";
	}

	
	public RightManager getRightManager() {
		return rightManager;
	}

	@Autowired
	public void setRightManager(RightManager rightManager) {
		this.rightManager = rightManager;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public LogManager getLogManager() {
		return logManager;
	}

	@Autowired
	public void setLogManager(LogManager logManager) {
		this.logManager = logManager;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
}
