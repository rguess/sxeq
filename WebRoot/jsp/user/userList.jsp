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
		<title>用户列表</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<!-- Le styles -->
		<link href="<%=basePath%>/css/bootstrap.css" rel="stylesheet">
		<%--<link href="css/bootstrap-responsive.css" rel="stylesheet">--%>
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
		<script type="text/javascript" src="<%=basePath%>/js/bootstrap.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/bootbox.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/userList.js"></script>
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
							<a href="User_loginOut">退出</a>
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
							<li class="active">
								<a href="User_userList">用户列表</a>
							</li>
							<li>
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
						<span><a class="btn btn-success" href="User_addUser";>
								添加用户 </a> </span>
					</div>
					<br>
					<br>
					<div>
						<table
							class="table table-striped table-bordered table-condensed table-hover">
							<thead>
								<tr>
									<th>
										姓名
									</th>
									<th>
										登录名
									</th>
									<th>
										部门
									</th>
									<th>
										角色名
									</th>
									<th>
										手机
									</th>
									<th>
										邮箱
									</th>
									<th>
										操作
									</th>
								</tr>
							</thead>
							<s:iterator value="#request.list" id="us">
								<tr>
									<td>
										<s:property value="#us.userName" />
									</td>
									<td>
										<s:property value="#us.loginId" />
									</td>
									<td>
										<s:property value="#us.department.departmentName" />
									</td>
									<td>
										<s:property value="#us.role.roleName" />
									</td>
									<td>
										<s:property value="#us.mobile" />
									</td>
									<td>
										<s:property value="#us.email" />
									</td>
									<td>
										<s:a href="User_deleteUser?id=%{#us.id}">删除</s:a>
										<s:a href="javascript:void(0)"
											onclick="initModal(%{#us.id})">修改</s:a>
									</td>
								</tr>
							</s:iterator>

						</table>
					</div>
				</div>
				<!--/span-->
			</div>

			<!--/row-->
			<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">
						×
					</button>
					<h3 id="myModalLabel">
						修改用户信息
					</h3>
				</div>
				<div class="modal-body">
					<div>
						<form class="form-horizontal" action="User_updateUser"
							method="post" id="staffform" enctype="multipart/form-data"
							name="userForm" onsubmit="return formValidate();">
							<input type="hidden" id="MUserId" name="user.id">
							<div class="control-group">
								<label class="control-label" for="MUserName">
									姓名
								</label>
								<div class="controls">
									<input type="text" id="MUserName" name="user.userName" onblur="javascript:checkUserName(this);">
									<span class="help-inline"></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="MloginId">
									登录名
								</label>
								<div class="controls">
									<input type="text" id="MloginId" name="user.loginId"
										readonly="readonly">
									<span class="help-inline"></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="Mpassword">
									登录密码
								</label>
								<div class="controls">
									<input type="password" id="Mpassword" name="user.password"
										placeholder="密码" onblur="javascript:checkPassword(this);"s>
									<span class="help-inline"></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="Mrepassword">
									重复密码
								</label>
								<div class="controls">
									<input type="password" id="Mrepassword" name="repassword"
										placeholder="重复密码" onblur="javascript:checkRePassword(this);">
									<span class="help-inline"></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="Mdepartment">
									部门
								</label>
								<div class="controls">
									<select id="Mdepartment" name="departmentName">

									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="Mrole">
									角色
								</label>
								<div class="controls">
									<select id="Mrole" name="roleName">

									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="Mphone">
									联系方式(手机)
								</label>
								<div class="controls">
									<input type="text" id="Mphone" name="user.mobile"
										placeholder="phone" onblur="javascript:checkPhone(this);">
									<span class="help-inline"></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="Memail">
									邮箱
								</label>
								<div class="controls">
									<input type="text" id="Memail" name="user.email"
										placeholder="email" onblur="javascript:checkEmail(this);">
									<span class="help-inline"></span>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn" data-dismiss="modal" aria-hidden="true">
						关闭
					</button>
					<button class="btn btn-primary" id="staffsubmit"
						onclick="javascript:userFormSubmit();">
						保存
					</button>
				</div>
			</div>
			<!--/span-->
		</div>
	</body>
	<hr>
		<footer>
		<p>
			© 数字空间2013
		</p>
		</footer>
</html>