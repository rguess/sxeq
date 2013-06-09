package com.dview.sxeq.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckIsAction implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String servletPath = req.getServletPath();
		
		String path = req.getContextPath();
		String basePath = req.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path;
		
		if(servletPath.matches(".*_.*")){
			chain.doFilter(req, response);
		}else{
			resp.sendRedirect(basePath+"/exception.jsp");
		}
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
