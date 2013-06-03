package com.dview.sxeq.service;

import java.util.List;

import com.dview.sxeq.model.Right;
import com.dview.sxeq.model.Role;

public interface RoleManager {
	
	public List<Role> roleList();

	public void deleteRole(Long id);

	public List<Right> getRights();

	public void addRole(Role role);

	public Role getRoleById(Long id);
	
}
