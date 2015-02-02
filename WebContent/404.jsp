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
<title>404</title>
<link rel="stylesheet" type="text/css" href="${baseURL }/css/main.css">
</head>

<body>
	<div id="main">
		<header id="header">
			<h1>
				<span class="icon">!</span>sorry<span class="sub">抱歉，该请求找不到</span>
			</h1>
		</header>
		<div id="content">
			<h2>该界面不存在</h2>
			<p>请检查url连接</p>
		</div>
	</div>
</html>