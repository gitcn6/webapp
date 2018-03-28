<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="common/common.jsp"%>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/frm/resource/js/login.js"></script>--%>
	<title>login</title>
</head>
<body style="margin-top: 10%;font-family: '微软雅黑';">
<form class="form-horizontal col-md-4 col-md-offset-4" role="form" method="post" action="/webapp/frm/init/login">
	<div class="form-group">
		<label for="username" class="col-md-2 control-label">用户名</label>
		<div class="col-md-10">
			<input type="text" class="form-control" id="username" name="username"
				   placeholder="username">
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-md-2 control-label">密码</label>
		<div class="col-md-10">
			<input type="password" class="form-control" id="password" name="password"
				   placeholder="password">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label>
					<input type="checkbox" name="rememberMe"> 请记住我
				</label>
			</div>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<button type="submit" id="login" class="btn btn-primary" style="width: 100%;">登录</button>
		</div>
	</div>
</form>
</body>
</html>