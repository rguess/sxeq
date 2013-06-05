package com.dview.sxeq.service;

import java.util.List;
import java.util.Map;

import com.dview.sxeq.model.Log;

public interface LogManager {

	List<Log> logList();

	void deleteLog(Long id);
	
	List<Log> ListForPage(int offset, int length,
			Map<String, String> equalCondition,
			final Map<String, String> likeCondition);
	
	long count(final Map<String,String> equalCondition, final Map<String,String> likeCondition);
	
	List<Log> listForPageByHql(String queryStr,int offset,int length);
	
	
}
