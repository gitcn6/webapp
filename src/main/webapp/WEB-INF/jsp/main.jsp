<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="common/common.jsp"%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/frm/resource/js/login.js"></script>
	<title>Insert title here</title>
	<style type="text/css">
		#main_content{
			border: 1px solid #fff;
			height: 500px;
			box-shadow: 2px 2px 5px #c5c5c5;
		}
	</style>
</head>
<body style="background-color: #ebebeb;">
<nav class="navbar navbar-inverse" role="navigation" style="border-radius: 0px;margin-bottom: 35px;">
	<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">通用框架</a>
	</div>
	<div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">合同管理</a></li>
			<li><a href="#">订单管理</a></li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					系统管理 <b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<!-- javascript:void(0);阻止浏览器默认行为 -->
					<li><a href="javascript:void(0);" onclick="addContent('/webapp/frm/user/toIndex')">用户管理</a></li>
					<li><a href="javascript:void(0);">角色管理</a></li>
					<li><a href="javascript:void(0);">权限管理</a></li>
					<li><a href="javascript:void(0);">用户角色管理</a></li>
					<li><a href="javascript:void(0);">角色权限管理</a></li>
				</ul>
			</li>
		</ul>
	</div>
	</div>
</nav>
<div class="col-md-10 col-md-offset-1">
	<iframe id="main_content" src="${pageContext.request.contextPath}/frm/user/toIndex" width="100%"></iframe>
</div>
</body>
</html>