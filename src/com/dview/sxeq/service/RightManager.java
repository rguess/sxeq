package com.dview.sxeq.service;

import java.util.List;

import com.dview.sxeq.model.Right;

public interface RightManager {
	
	public Right getRightById(Long id);

	public List<Right> rightList();
}
