package com.dview.sxeq.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dview.sxeq.dao.DepartmentDao;
import com.dview.sxeq.dao.LogDao;
import com.dview.sxeq.dao.RightDao;
import com.dview.sxeq.dao.RoleDao;
import com.dview.sxeq.dao.UserDao;
import com.dview.sxeq.model.Department;
import com.dview.sxeq.model.Log;
import com.dview.sxeq.model.Right;
import com.dview.sxeq.model.Role;
import com.dview.sxeq.model.User;
import com.dview.sxeq.util.LogUtil;

public class AllTest {

	static ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath:beans.xml");
	DepartmentDao departmentDao = context.getBean(DepartmentDao.class);
	RightDao rightDao = context.getBean(RightDao.class);
	RoleDao roleDao = context.getBean(RoleDao.class);
	UserDao userDao = context.getBean(UserDao.class);
	static LogDao logDao = context.getBean(LogDao.class);

	@Test
	public void test01() {
		Department department = new Department();
		// department.setId(1);
		department.setDepartmentName("研发部");
		department.setDesciption("经常要写很多代码的");
		departmentDao.add(department);
	}

	@Test
	public void test02() {
		List<Right> rights = new ArrayList<Right>();
		Right right1 = rightDao.get(Long.valueOf("1"));
		System.out.println(right1.getRightStr());
		rights.add(right1);
		Role role = new Role();
		role.setDescription("拥有一些业务权限");
		role.setGenTime(new Date());
		role.setRights(rights);
		role.setRoleName("业务管理员");
		roleDao.add(role);
	}

	@Test
	public void test03() {
		Right right = new Right();
		right.setRightName("删除部门");
		right.setRightStr("/Department_deleteDepartment");
		right.setDescription("删除部门信息权限");
		rightDao.add(right);
	}
	
	@Test
	public void getRightsTest(){
		Right right1 = rightDao.get(Long.valueOf("1"));
		System.out.println(right1.getRightStr());
	}
	
	@Test
	public void addUser(){
		User user = new User();
		Department department = departmentDao.get(Long.valueOf("1"));
		System.out.println(department.getDepartmentName());
		user.setDepartment(department);
		user.setEmail("502876941@qq.com");
		user.setGenTime(new Date());
		user.setLoginId("admin");
		user.setMobile("1523212311");
		user.setPassword(toMD5("admin123"));
		Role role = roleDao.get(Long.valueOf("1"));
		System.out.println(role.getRoleName());
		user.setRole(role);
		user.setUserName("张三");
		userDao.add(user);
	}
	
	@Test
	public void getUser(){
		List list = userDao.list("from User where loginId='admin'");
//		System.out.println(list.size());
//		System.out.println(list.get(1));
		User user = userDao.list("from User where loginId='admin'").get(0);
		System.out.println(user.getPassword());
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
	
	@Test
	public void test05(){
		roleDao.deleteById(Long.valueOf("22"));
	}
	
	@Test
	public void testAddRightToRole(){
		
		List<Right> list = rightDao.list("from Right");
		List<Role>	roles = roleDao.list("from Role");
		for(Role role:roles){
			role.setRights(list);
			roleDao.update(role);
		}
	}

	@Test
	public void test06(){
		System.out.println(LogUtil.getLogContent("asdasd"));
	}
	
	@Test
	public void test07(){
		logDao.delete(logDao.get(Long.valueOf("")));
	}
	
	@Test
	public void test08(){
		
		String str = "userList.action";
		System.out.println(str.lastIndexOf("."));
	}
	
	@Test
	public void test09(){
//		List<Log> list = logDao.getListForPage(0, 5, null, null);
//		System.out.println(logDao.count(null, null));
//		System.out.println(list.size());
		List<Log> list = logDao.getListByHql("from Log", 10, 6);
		System.out.println(list.size());
		System.out.println(logDao.count(null, null));
	}
	
	@Test
	public void test10(){
		System.out.println(logDao.list("form Log where user.id =141").size());
	}
	
	@Test
	public void test11(){
		User user = userDao.get(Long.valueOf("301"));
		Role role = roleDao.get(Long.valueOf("62"));
		System.out.println(role.getRights().size());
		user.setRole(role);
		userDao.update(user);
//		System.out.println(user.getRole().getRights().size());
	}
	
	@Test
	public void test12(){
		List<User> list = userDao.list("from User");
		for(User user : list){
			System.out.println(user.getPassword());
		}
	}
	
	
	
	public static void main(String[] args) {
//		System.out.println(LogUtil.getLogContent("userList"));
		long id = 141;
		System.out.println(logDao.list("from Log where user.id ="+id).size());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
