package com.dview.sxeq.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dview.sxeq.model.Right;
import com.dview.sxeq.model.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@SuppressWarnings("serial")
public class RightInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
//		System.out.println(request.getContextPath());
		String servletPath = request.getServletPath();
		String str = "";
		if(-1 == servletPath.lastIndexOf(".")){
			str = servletPath;
		}else{
			str = servletPath.substring(0, servletPath.lastIndexOf("."));
		}
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		boolean flag = false;
		for(Right right : user.getRole().getRights()){
			if(right.getRightStr().equals(str)){
				flag = true;
				break;
			}
		}
		if(!flag){
			return "noRight";
		}
		return invocation.invoke();
	}

}
