package com.dview.sxeq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dview.sxeq.dao.RightDao;
import com.dview.sxeq.dao.RoleDao;
import com.dview.sxeq.model.Right;
import com.dview.sxeq.model.Role;
import com.dview.sxeq.service.RoleManager;

@Component
public class RoleManagerImpl implements RoleManager {
	
	private RoleDao roleDao;
	private RightDao rightDao;
	
	public RightDao getRightDao() {
		return rightDao;
	}

	@Autowired
	public void setRightDao(RightDao rightDao) {
		this.rightDao = rightDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public List<Role> roleList() {
		return roleDao.list("from Role");
	}

	public void deleteRole(Long id) {
		roleDao.deleteById(id);
	}

	public List<Right> getRights() {
		return rightDao.list("from Right");
	}

	public void addRole(Role role) {
		roleDao.add(role);
	}

	public Role getRoleById(Long id) {
		
		return roleDao.get(id);
	}

	public Object checkRoleNameIsExit(String roleName) {
		List<Role> list = roleDao.list("from Role where roleName = '"+roleName+"'");
		if(list.size()>0){
			return true;
		}else{
			return false;
		}
	}

}
