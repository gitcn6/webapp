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
            <div class="col-md-3"><input type="text" class="form-control" id="username" value="zhangsan"></div>
            <div class="col-md-1"><button class="btn btn-primary pull-right" id="select">查询</button></div>
            <div class="col-md-1"><button class="btn btn-primary pull-right" id="add">新增</button></div>
            <div class="col-md-1"><button class="btn btn-primary pull-right" id="del">删除</button></div>
        </div>
        <hr style="background-color: #1E9FFF;height: 1px;margin: 10px 0px;">
        <div class="row">
            <div class="col-md-12">
                <table id="table"></table>
            </div>
        </div>

    </div>
</body>
</html>