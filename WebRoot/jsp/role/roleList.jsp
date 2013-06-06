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
		<title>角色列表</title>
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
			table{
				table-layout:fixed ;
			}
			.sidebar-nav {
				padding: 9px 0;
			}
			td{
				width:60%;
				overflow:hidden;
			    white-space:nowrap;
			    text-overflow:ellipsis;
			}
		</style>
		<script type="text/javascript" src="<%=basePath%>/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/bootstrap.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/bootbox.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/updateRole.js"></script>
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
							<li>
								<a href="User_addUser">添加用户</a>
							</li>
							<li class="nav-header">
								角色管理
							</li>
							<li class="active">
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
						<span><a class="btn btn-success" href="Role_addRole";>
								添加角色 </a> </span>
					</div>
					<br>
					<br>
					<div>
						<table
							class="table table-striped table-bordered table-condensed table-hover">
							<tr>
								<th>
									角色名
								</th>
								<th>
									角色描述
								</th>
								<th>
									拥有权限
								</th>
								<th>
									操作
								</th>
							</tr>

							<s:iterator value="#request.list" id="role">
								<tr>
									<td>
										<s:property value="#role.roleName" />
									</td>
									<td>
										<s:property value="#role.description" />
									</td>
									<td title="<s:iterator value="#role.rights" id="right"><s:property value="#right.rightName"/> </s:iterator>">
										<s:iterator value="#role.rights" id="right">
											<s:property value="#right.rightName"/>
										</s:iterator>
									</td>
									<td>
										<s:a href="Role_deleteRole?id=%{#role.id}">删除</s:a>
										<s:a href="#myModal" data-toggle='modal' onclick="javascript:initModal(%{#role.id})">修改</s:a>
									</td>
								</tr>
							</s:iterator>

						</table>
					</div>
				</div>
				<!--/span-->
			</div>
			
			<!--/span-->
			<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">
						×
					</button>
					<h3 id="myModalLabel">
						修改角色信息
					</h3>
				</div>
				<div class="modal-body">
					<div>
						<form class="form-horizontal" action="Role_updateRole" method="post"
							id="staffform" enctype="multipart/form-data" name="roleForm">
							<input type="hidden" id=MroleId name="role.id">
							<div class="control-group">
								<label class="control-label" for="MRoleName">
									角色名
								</label>
								<div class="controls">
									<input type="text" id="MRoleName" name="role.roleName">
									<span class="help-inline"></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="Mdescription">
									角色描述
								</label>
								<div class="controls">
									<textarea rows="3" id="Mdesciption" name="role.description"></textarea>
									<span class="help-inline"></span>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="rights">
									赋予权限
								</label>
								<div class="controls" id="rights">
									<s:iterator value="#request.rights" id="right">
									<s:checkbox name="rightId" fieldValue="%{#right.id}"></s:checkbox>
									<s:property value="#right.rightName"/>
										<br/>
									</s:iterator>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn" data-dismiss="modal" aria-hidden="true">
						关闭
					</button>
					<button class="btn btn-primary" id="staffsubmit" onclick="javascript:document.roleForm.submit();">
						保存
					</button>
				</div>
			</div>
		</div>
		<hr>
		<footer>
		<p>
			© Company 2012
		</p>
		</footer>
		</div>
	</body>
</html>