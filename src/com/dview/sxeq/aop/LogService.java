package com.dview.sxeq.aop;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import com.dview.sxeq.dao.LogDao;
import com.dview.sxeq.model.Log;
import com.dview.sxeq.model.User;
import com.dview.sxeq.util.LogUtil;

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
		
		String methodName = joinpoint.getSignature().getName();
		Log log = new Log();
		String content = LogUtil.getLogContent(methodName);
		if(null != content && !"".equals(content)){
			log.setContent(content);
			log.setDate(new Date());
			User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
			log.setRemark(user.getUserName()+content);
			log.setUser(user);
			logDao.add(log);
		}
	}
}


//String methodName = joinpoint.getSignature().getName();
//System.out.println("name:---------"+methodName);
//Class clazz = joinpoint.getTarget().getClass();
//try {
//	Method method = clazz.getMethod(methodName);
//	if(null != method.getAnnotation(LogAnnotation.class)){
//		LogAnnotation logAnnotation = method.getAnnotation(LogAnnotation.class);
//		String content = logAnnotation.value();
//		Log log = new Log();
//		log.setContent(content);
//		log.setDate(new Date());
//		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
//		log.setRemark(content);
//		log.setUser(user);
//		logDao.add(log);
//		System.out.println("content:++++++++++"+content);
//	}
//} catch (SecurityException e) {
//	e.printStackTrace();
//} catch (NoSuchMethodException e) {
//	e.printStackTrace();
//}