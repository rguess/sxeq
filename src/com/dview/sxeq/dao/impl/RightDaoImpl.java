package com.dview.sxeq.dao.impl;

import com.dview.sxeq.core.ObjectDaoImpl;
import com.dview.sxeq.dao.RightDao;
import com.dview.sxeq.model.Right;

public class RightDaoImpl extends ObjectDaoImpl<Right, Long>
		implements RightDao {

	@SuppressWarnings("unchecked")
	public RightDaoImpl(Class persistentClass) {
		super(persistentClass);
	}



}
