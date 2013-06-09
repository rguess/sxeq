package com.dview.sxeq.action;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.dview.sxeq.service.LogManager;
import com.dview.sxeq.util.ExportLogUtil;
import com.dview.sxeq.util.TimeTools;
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

	public String exportLog() {

		try {
			Workbook wb = ExportLogUtil.getInputStream(logManager);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/vnd.ms-excel");
			response.addHeader("Content-Disposition",
					"attachment;filename=\"log-"+TimeTools.getCurrentTimeNoSeconds()+".xls" + "\"");
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
