<%@ page language="java" contentType="text/html; charset=utf-8"
				pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="../common/common.jsp"%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/frm/resource/js/userManager.js"></script>
	<title>Insert title here</title>
    <style type="text/css">
        .breadcrumb{background-color: #fff;}
        .container{}
        .breadcrumb > li + li:before {
            color: #CCCCCC;
            content: ">";
            padding: 0 5px;
        }
        .btn{padding: 3px 12px;}
        .form-control{
            padding:1px 12px;
            height: 30px;}
    </style>
</head>
<body>
	<div class="container">
        <ol class="breadcrumb" style="margin-bottom: 0px;padding-left: 0px;">
            <li><a href="javascript:void(0);">系统管理</a></li>
            <li class="active">用户管理</li>
        </ol>
        <hr style="background-color: #1E9FFF;height: 1px;margin: 0px 0px 10px;">
        <div class="row">
            <div class="col-md-6" style="text-align:right;">用户名</div>
            <div class="col-md-3"><input type="text" class="form-control" id="username"></div>
            <div class="col-md-1"><button class="btn btn-primary pull-right" id="btn_sel">查询</button></div>
            <div class="col-md-1"><button class="btn btn-primary pull-right" id="btn_add" data-toggle="modal" data-target="#myModal">新增</button></div>
            <div class="col-md-1"><button class="btn btn-primary pull-right" id="btn_del">删除</button></div>
        </div>
        <hr style="background-color: #1E9FFF;height: 1px;margin: 10px 0px;">
        <div class="row">
            <div class="col-md-12">
                <table id="table"></table>
            </div>
        </div>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">新增用户</h4>
		            </div>
		            <div class="modal-body">
		            	<form class="form-horizontal" role="form" id="user_form">
		            		<div class="form-group">
								<label for="username" class="col-sm-2 control-label">名字</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="name" name="name" placeholder="请输入名字" style="width: 200px;">
							    </div>
							</div>
							<div class="form-group">
								<label for="username" class="col-sm-2 control-label">密码</label>
							    <div class="col-sm-10">
							      <input type="password" class="form-control" id="password" name="password" style="width: 200px;">
							    </div>
							</div>
							<div class="form-group">
								<label for="age" class="col-sm-2 control-label">年龄</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="age" name="age" style="width: 200px;">
							    </div>
							</div>
							<div class="form-group">
								<label for="mailAddr" class="col-sm-2 control-label">邮箱</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="mailAddr" name="mailAddr" style="width: 200px;">
							    </div>
							</div>
		            	</form>
		            </div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-primary" id="btn_save">保存</button>
		                <button type="button" class="btn btn-primary" data-dismiss="modal" id="btn_cancel">关闭</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
    </div>
</body>
</html>