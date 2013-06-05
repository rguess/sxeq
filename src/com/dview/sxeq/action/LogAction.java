package com.dview.sxeq.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.dview.sxeq.service.LogManager;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("logAction")
@Scope(value = "prototype")
public class LogAction extends ActionSupport {

	private LogManager logManager;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LogManager getLogManager() {
		return logManager;
	}

	@Autowired
	public void setLogManager(LogManager logManager) {
		this.logManager = logManager;
	}

	public String logList() {
		return "logList";
	}

	public String deleteLog() {

		logManager.deleteLog(id);
		return "logDeleteSuccess";
	}

}
