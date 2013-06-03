package com.dview.sxeq.aop;

import org.aopalliance.intercept.Joinpoint;
import org.apache.struts2.ServletActionContext;

public class LogService {

	public void logAll(Joinpoint jp){
		System.out.println(222222222);
		ServletActionContext.getRequest();
	}
}
