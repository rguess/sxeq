package com.dview.sxeq.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dview.sxeq.dao.LogDao;
import com.dview.sxeq.model.Log;
import com.dview.sxeq.service.LogManager;

@Component
public class LogManagerImpl implements LogManager {

	private LogDao logDao;

	public LogDao getLogDao() {
		return logDao;
	}

	@Autowired
	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}

	public List<Log> logList() {
		return logDao.list("from Log as log order by log.date desc");
	}

	public void deleteLog(Long id) {
		Log log = logDao.get(id);
		logDao.delete(log);
	}

	public List<Log> ListForPage(int offset, int length,
			Map<String, String> equalCondition,
			final Map<String, String> likeCondition) {
		return logDao.getListForPage(offset, length, equalCondition,
				likeCondition);
	}

	public long count(Map<String, String> equalCondition,
			Map<String, String> likeCondition) {
		
		return logDao.count(equalCondition, likeCondition);
	}

}
