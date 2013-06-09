package com.dview.sxeq.service;

import java.util.List;

import com.dview.sxeq.model.Department;

public interface DepartmentManager {

	public List<Department> departmentList();

	public void addDepartment(Department department);

	public Object checkDepartmentNameIsExit(String name);

	public void deleteDepartment(Long id);

	public Department getDepartmentById(Long id);

}
