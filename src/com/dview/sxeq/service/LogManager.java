package com.dview.sxeq.service;

import java.util.List;

import com.dview.sxeq.model.Log;

public interface LogManager {

	List<Log> logList();

	void deleteLog(Long id);
	
	
}
