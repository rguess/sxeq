<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!Doctype html>
<html lang="en">
	<head>
		<title>登录</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link href="css/bootstrap.css" rel="stylesheet">
		
		<link href="css/bootstrap-responsive.css" rel="stylesheet">
		
		<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
	
		<%--<script type="text/javascript" src="js/login.js"></script>--%>

	</head>
	<body style="background-image: url('image/bg1.jpg');">
		<div class="container">
			<div class="row-fluid">
				<div class="span6"></div>
				<div class="span6" id="loginDiv" style="margin-top: 200px">
					<form class="form-horizontal" action="User_login" method="post">
						<div class="control-group">
							<label class="control-label" for="inputLoginId">
								用户名
							</label>
							<div class="controls">
								<input type="text" id="loginId" name="user.loginId" placeholder="loginId">
								<span class="help-inline"></span>
							</div>

						</div>
						<div class="control-group">
							<label class="control-label" for="inputPassword">
								密码
							</label>
							<div class="controls">
								<input type="password" id="password" name="user.password"
									placeholder="password">
								<span class="help-inline"></span>
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<input type="submit" class="btn btn-primary" value="登录">
							</div>
						</div>
						<span style="color:red">${msg}</span>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>