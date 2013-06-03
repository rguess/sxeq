package com.dview.sxeq.dao.impl;

import com.dview.sxeq.core.ObjectDaoImpl;
import com.dview.sxeq.dao.UserDao;
import com.dview.sxeq.model.User;

public class UserDaoImpl extends ObjectDaoImpl<User, Long>
		implements UserDao {

	@SuppressWarnings("unchecked")
	public UserDaoImpl(Class persistentClass) {
		super(persistentClass);
	}



}
