package com.dview.sxeq.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dview.sxeq.dao.DepartmentDao;
import com.dview.sxeq.dao.RoleDao;
import com.dview.sxeq.dao.UserDao;
import com.dview.sxeq.model.Department;
import com.dview.sxeq.model.Role;
import com.dview.sxeq.model.User;
import com.dview.sxeq.service.UserManager;

@Component
public class UserManagerImpl implements UserManager {

	private UserDao userDao;
	private DepartmentDao departmentDao;
	private RoleDao roleDao;
	
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	@Autowired
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String login(User user) {
		
		List<User> list = userDao.list("from User where loginId ='"+user.getLoginId()+"'");
		if(list.size()>0 && toMD5(user.getPassword()).equals(list.get(0).getPassword())){
			return "login_success";
		}else{
			return "login_fail";
		}
	}

	public static String toMD5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] byteDigest = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < byteDigest.length; offset++) {
				i = byteDigest[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// 32位加密
			return buf.toString();
			// 16位的加密
			// return buf.toString().substring(8, 24);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<User> userList() {
		return userDao.list("from User");
	}

	public void addUser(User user, String departmentName, String roleName) {
		
		Department department = departmentDao.list("from Department where departmentName = '"+departmentName+"'").get(0);
		Role role = roleDao.list("from Role where roleName = '"+roleName+"'").get(0);
		user.setDepartment(department);
		user.setRole(role);
		user.setPassword(toMD5(user.getPassword()));
		user.setGenTime(new Date());
		userDao.add(user);
	}

	public void deleteUser(Long id) {
		User user = userDao.get(id);
		userDao.delete(user);
	}

	public User getUserById(Long id) {
		return userDao.get(id);
	}
}
