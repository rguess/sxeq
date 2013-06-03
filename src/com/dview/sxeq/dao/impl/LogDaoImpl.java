package com.dview.sxeq.dao.impl;

import com.dview.sxeq.core.ObjectDaoImpl;
import com.dview.sxeq.dao.LogDao;
import com.dview.sxeq.model.Log;

public class LogDaoImpl extends ObjectDaoImpl<Log, Long>
		implements LogDao {

	@SuppressWarnings("unchecked")
	public LogDaoImpl(Class persistentClass) {
		super(persistentClass);
	}



}
