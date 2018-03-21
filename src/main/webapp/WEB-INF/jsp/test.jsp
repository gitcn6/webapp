<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	公司名称：${pageContext.request.contextPath}
	邮箱地址:${addr }<br>
	用户邮箱：${user.mailAddr }
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/my.js"/>
</body>
</html>