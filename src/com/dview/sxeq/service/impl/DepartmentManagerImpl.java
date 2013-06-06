package com.dview.sxeq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dview.sxeq.dao.DepartmentDao;
import com.dview.sxeq.model.Department;
import com.dview.sxeq.service.DepartmentManager;

@Component
public class DepartmentManagerImpl implements DepartmentManager {
	
	private DepartmentDao departmentDao;
	
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}
	
	@Autowired
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public List<Department> departmentList() {
		
		return departmentDao.list("from Department");
	}

	public void addDepartment(Department department) {
		departmentDao.add(department);
	}

}
