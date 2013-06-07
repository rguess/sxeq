package com.dview.sxeq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dview.sxeq.dao.RightDao;
import com.dview.sxeq.model.Right;
import com.dview.sxeq.service.RightManager;

@Component
public class RightManagerImpl implements RightManager {
	
	private RightDao rightDao;
	
	public RightDao getRightDao() {
		return rightDao;
	}

	@Autowired
	public void setRightDao(RightDao rightDao) {
		this.rightDao = rightDao;
	}

	public Right getRightById(Long id) {
		return rightDao.get(id);
	}

	public List<Right> rightList() {
		return rightDao.list("from Right order by rightName desc");
	}
	
}
