<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!Doctype html>
<html>
	<head>
		<title>添加用户</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<!-- Le styles -->
		<link href="<%=basePath%>/css/bootstrap.css" rel="stylesheet">
		<link href="<%=basePath%>/css/bootstrap-responsive.css"
			rel="stylesheet">
		<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}
</style>
		<script type="text/javascript" src="<%=basePath%>/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/addUser.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/checkRight.js"></script>
	</head>
	<body>
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container-fluid">
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> </a>
					<a class="brand" href="#">管理子系统</a>
					<div class="nav-collapse collapse">
						<p class="navbar-text pull-right">
							欢迎，
							<s:property value="#session.user.userName" />
							&nbsp&nbsp&nbsp
							<a href="User_loginOut">login out</a>
						</p>
						<ul class="nav">
							<li class="active">
								<a href="#">Home</a>
							</li>
							<li>
								<a href="#">About</a>
							</li>
							<li>
								<a href="#">Contact</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span3">
					<div class="well sidebar-nav">
						<ul class="nav nav-list">
							<li class="nav-header">
								用户管理
							</li>
							<li>
								<a href="User_userList">用户列表</a>
							</li>
							<li class="active">
								<a href="User_addUser">添加用户</a>
							</li>
							<li class="nav-header">
								角色管理
							</li>
							<li>
								<a href="Role_roleList">角色列表</a>
							</li>
							<li>
								<a href="Role_addRole">添加角色</a>
							</li>
							<li class="nav-header">
								权限管理
							</li>
							<li>
								<a href="Right_rightList">权限信息列表</a>
							</li>
							<li class="nav-header">
								部门管理
							</li>
							<li>
								<a href="Department_departmentList">部门列表</a>
							</li>
							<li>
								<a href="Department_addDepartment">添加部门</a>
							</li>
							<li class="nav-header">
								日志管理
							</li>
							<li>
								<a href="Log_logList">日志信息列表</a>
							</li>
						</ul>
					</div>
					<!--/.well -->
				</div>
				<!--/span-->
				<div class="span9">
					<div>
						<h3>
							添加员工信息
						</h3>
						<form class="form-horizontal" action="User_addUser" method="post"
							id="userForm" onsubmit="javascript:return formValidate();">
							<div class="control-group">
								<label class="control-label" for="staffName">
									姓名
								</label>
								<div class="controls">
									<input type="text" id="userName" name="user.userName"
										placeholder="姓名" height="50px"
										onblur="javascript:checkUserName(this);">
									<span class="help-inline"></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="loginId">
									登录名
								</label>
								<div class="controls">
									<input type="text" id="loginId" name="user.loginId"
										placeholder="loginId" onblur="javascript:checkLoginId(this);">
									<span class="help-inline"></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="password">
									登录密码
								</label>
								<div class="controls">
									<input type="password" id="password" name="user.password"
										placeholder="密码" onblur="javascript:checkPassword(this);">
									<span class="help-inline"></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="repassword">
									重复密码
								</label>
								<div class="controls">
									<input type="password" id="repassword" name="repassword"
										placeholder="重复密码" onblur="javascript:checkRePassword(this);">
									<span class="help-inline"></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="department">
									部门
								</label>
								<div class="controls">
									<select id="department" name="departmentName">
										<s:iterator value="#request.departments" id="department">
											<option>
												<s:property value="#department.departmentName" />
											</option>
										</s:iterator>
									</select>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="role">
									角色
								</label>
								<div class="controls">
									<select id="role" name="roleName">
										<s:iterator value="#request.roles" id="role">
											<option>
												<s:property value="#role.roleName" />
											</option>
										</s:iterator>
									</select>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="phone">
									联系方式(手机)
								</label>
								<div class="controls">
									<input type="text" id="phone" name="user.mobile"
										placeholder="phone" onblur="javascript:checkPhone(this);">
									<span class="help-inline"></span>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="email">
									邮箱
								</label>
								<div class="controls">
									<input type="text" id="email" name="user.email"
										placeholder="email" onblur="javascript:checkEmail(this);">
									<span class="help-inline"></span>
								</div>
							</div>

							<div class="control-group">
								<div class="controls">
									<button type="submit" class="btn btn-primary " id="staffsubmit">
										提交
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>

				<!--/span-->
			</div>
			<!--/row-->
			<hr>
			<footer>
			<p>
				© Company 2012
			</p>
			</footer>
		</div>
	</body>
</html>