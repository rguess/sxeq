package com.dview.sxeq.dao.impl;

import com.dview.sxeq.core.ObjectDaoImpl;
import com.dview.sxeq.dao.RoleDao;
import com.dview.sxeq.model.Role;

public class RoleDaoImpl extends ObjectDaoImpl<Role, Long>
		implements RoleDao {

	@SuppressWarnings("unchecked")
	public RoleDaoImpl(Class persistentClass) {
		super(persistentClass);
	}



}
