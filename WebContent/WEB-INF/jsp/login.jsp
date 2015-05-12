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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录</title>
<link href="${baseURL}/css/login.css" rel="stylesheet" rev="stylesheet"
	type="text/css" media="all" />
<link href="${baseURL}/css/demo.css" rel="stylesheet" rev="stylesheet"
	type="text/css" media="all" />
	
<script type="text/javascript" src="${baseURL}/scripts/jquery1.42.min.js"></script>
<script type="text/javascript" src="${baseURL}/scripts/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="${baseURL}/scripts/Validform_v5.3.2_min.js"></script>

<script>
	$(function() {

		$(".i-text").focus(function() {
			$(this).addClass('h-light');
		});

		$(".i-text").focusout(function() {
			$(this).removeClass('h-light');
		});

		$("#username").focus(function() {
			var username = $(this).val();
			if (username == '输入账号') {
				$(this).val('');
			}
		});

		$("#username").focusout(function() {
			var username = $(this).val();
			if (username == '') {
				$(this).val('输入账号');
			}
		});

		$("#password").focus(function() {
			var username = $(this).val();
			if (username == '输入密码') {
				$(this).val('');
			}
		});

		$("#yzm").focus(function() {
			var username = $(this).val();
			if (username == '输入验证码') {
				$(this).val('');
			}
		});

		$("#yzm").focusout(function() {
			var username = $(this).val();
			if (username == '') {
				$(this).val('输入验证码');
			}
		});

		$(".registerform").Validform({
			tiptype : function(msg, o, cssctl) {
				var objtip = $(".error-box");
				cssctl(objtip, o.type);
				objtip.text(msg);
			},
			ajaxPost : true
		});

	});
</script>


</head>

<body>


	<div class="header">
		<h1 class="headerLogo">
			<a title="后台管理系统" target="_blank" href="#"><img alt="logo"
				src="${baseURL}/images/login/logo.gif"></a>
		</h1>
		<div class="headerNav">
			<a target="_blank" href="#">华软官网</a> <a target="_blank" href="#">关于华软</a>
			<a target="_blank" href="#">开发团队</a> <a target="_blank" href="#">意见反馈</a>
			<a target="_blank" href="#">帮助</a>
		</div>
	</div>

	<div class="banner">

		<div class="login-aside">
			<div id="o-box-up"></div>
			<div id="o-box-down" style="table-layout: fixed;">
				<div class="error-box"></div>

				<form class="registerform" action="demo/ajax_post.jsp">
					<div class="fm-item">
						<label for="logonId" class="form-label">MISS系统登陆：</label> <input
							type="text" value="输入账号" maxlength="100" id="username"
							class="i-text" ajaxurl="demo/valid.jsp" datatype="s6-18"
							errormsg="用户名至少6个字符,最多18个字符！">
						<div class="ui-form-explain"></div>
					</div>

					<div class="fm-item">
						<label for="logonId" class="form-label">登陆密码：</label> <input
							type="password" value="" maxlength="100" id="password"
							class="i-text">
						<div class="ui-form-explain"></div>
					</div>

					<div class="fm-item pos-r">
						<label for="logonId" class="form-label">验证码</label> <input
							type="text" 
							value="输入验证码" 
							maxlength="100" 
							id="yzm"
							class="i-text yzm">
						<div class="ui-form-explain">
							<img src="${baseURL}/images/login/yzm.jpg" class="yzm-img" />
						</div>
					</div>
					<div class="fm-item">
						<label for="logonId" class="form-label">
						</label> <input
							type="submit" value="" tabindex="4" id="send-btn"
							class="btn-login">
						<div class="ui-form-explain"></div>
					</div>
				</form>

			</div>
		</div>

		<div class="bd">
			<ul>
				<li
					style="background: url(${baseURL}/images/login/theme-pic1.jpg) #CCE1F3 center 0 no-repeat;"><a
					target="_blank" href="#"></a></li>
				<li
					style="background: url(${baseURL}/images/login/theme-pic2.jpg) #BCE0FF center 0 no-repeat;"><a
					target="_blank" href="#"></a></li>
			</ul>
		</div>

		<div class="hd">
			<ul></ul>
		</div>
	</div>
	<script type="text/javascript">
		jQuery(".banner").slide({
			titCell : ".hd ul",
			mainCell : ".bd ul",
			effect : "fold",
			autoPlay : true,
			autoPage : true,
			trigger : "click"
		});
	</script>


	<div class="banner-shadow"></div>

	<div class="footer">
		<p>西安华软 版权所有 Copyright 2012-2013 HUARUAN Corporation, All Rights
			Reserved</p>
	</div>

	<div style="text-align: center;">
		<p>
			来源：<a href="http://www.mycodes.net/" target="_blank">源码之家</a>
		</p>
	</div>

</body>
</html>
