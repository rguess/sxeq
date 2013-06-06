package com.dview.sxeq.service;

import java.util.List;

import com.dview.sxeq.model.User;



public interface UserManager {
	
	public String login(User user);
	public List<User> userList();
	public void addUser(User user,String departmentName,String roleName);
	public void deleteUser(Long id);
	public User getUserById(Long id);
	public boolean checkLoginIsExit(String loginId);
	public void updateUser(User user,String departmentName,String roleName);
}
