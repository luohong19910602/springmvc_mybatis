<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String scheme = request.getScheme();
String serverName = request.getServerName();
String contextPath = request.getContextPath();
int port = request.getServerPort();

//网站的访问跟路径
String baseURL = scheme + "://" + serverName + ":"+ port + contextPath;
request.setAttribute("baseURL", baseURL);

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无权访问</title>
<link rel="stylesheet" type="text/css" href="${baseURL }/css/main.css">
</head>

<body>
	<div id="main">
		<header id="header">
			<h1>
				<span class="icon">!</span>sorry<span class="sub">您没有权限访问</span>
			</h1>
		</header>
		<div id="content">
			<h2>您没有访问权限呢</h2>
			<p>如果您想要访问，请联系管理员</p>
		</div>
	</div>
</html>