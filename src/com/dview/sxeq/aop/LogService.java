package com.dview.sxeq.aop;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.dview.sxeq.dao.LogDao;
import com.dview.sxeq.model.User;

public class LogService {
	
	private LogDao logDao;
	
	public LogDao getLogDao() {
		return logDao;
	}

	@Autowired
	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}

	public void logAll(JoinPoint joinpoint) {
//		System.out.println("方法：++++++++++++++++"
//				+ joinpoint.getSignature().getName());
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute(
				"user");
//		System.out.println(user.getEmail());
	}
}
