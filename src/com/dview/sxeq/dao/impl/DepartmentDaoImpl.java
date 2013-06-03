package com.dview.sxeq.dao.impl;

import org.springframework.stereotype.Component;

import com.dview.sxeq.core.ObjectDaoImpl;
import com.dview.sxeq.dao.DepartmentDao;
import com.dview.sxeq.model.Department;

@Component("departmentDao")
public class DepartmentDaoImpl extends ObjectDaoImpl<Department, Long>
		implements DepartmentDao {

	@SuppressWarnings("unchecked")
	public DepartmentDaoImpl(Class persistentClass) {
		super(persistentClass);
	}



}
