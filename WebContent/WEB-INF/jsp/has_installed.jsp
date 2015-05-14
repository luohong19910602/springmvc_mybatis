<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String scheme = request.getScheme();
	String serverName = request.getServerName();
	String contextPath = request.getContextPath();
	int port = request.getServerPort();

	//网站的访问跟路径
	String baseURL = scheme + "://" + serverName + ":" + port
			+ contextPath;
	request.setAttribute("baseURL", baseURL);
%>

<!DOCTYPE html>
<html>
<head>
    <title>该系统已经被安装</title>
</head>
 
<body>
    <h1>该系统已安装，请直接访问首页</h1>
    <a href="${baseURL }">首页</a>
</body>
</html>
