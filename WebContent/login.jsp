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
		//更换验证码
		$("#changeRandomImage").click(function(){
			var myDate = new Date();
			$(this).attr("src", "${baseURL}/random.jsp?date=" + myDate.getTime());	
		});
		
		$("#form1").submit(function(){
			var username = $("#username").val();
			var password = $("#password").val();
			var rand = $("#randomCode").val();
			if(!username){
				alert("请输入用户名");
			    return false;
			}
			
			if(!password){
				alert("请输入密码");
				return false;
			}
			
			if(!rand){
				alert("请输入验证码");
				return false;
			}
			
			return true;
		});
	});
</script>


</head>

<body>
	<div class="header">
		<h1 class="headerLogo">
			<a title="后台管理系统"><img alt="logo"
				src="${baseURL}/images/login/logo.gif"></a>
		</h1>
	</div>

	<div class="banner">

		<div class="login-aside">
			<div id="o-box-up"></div>
			<div id="o-box-down" style="table-layout: fixed;">
				<div class="error-box"></div>
                  
				<form id="form1"  class="registerform" method="POST" action="${baseURL }/user/login.do">
					<div class="fm-item">
						<label for="logonId" class="form-label">用户名：</label> <input
							type="text" maxlength="100" id="username"
							class="i-text" placeholder="用户名" name="loginName">
						<div class="ui-form-explain"></div>
					</div>

					<div class="fm-item">
						<label for="logonId" class="form-label">登陆密码：</label> <input
							type="password" maxlength="100" id="password"
							class="i-text" placeholder="密码"  name="password">
						<div class="ui-form-explain"></div>
					</div>

					<div class="fm-item pos-r">
						<label for="logonId" class="form-label">验证码</label> <input
							type="text" name="randomCode" maxlength="100" id="randomCode"
							class="i-text" >
							<span style="color:red;font-weight:bold;">${error }</span>
						<div class="ui-form-explain">
							<img src="${baseURL}/random.jsp" id="changeRandomImage" alt="验证码"/>
						</div>
					</div>
					
					<div class="fm-item pos-r">
						<div class="item item-fore3">
							<div class="safe">
								<span> 
								    <input 
								        style="float:none; vertical-align: middle; margin:0 3px 0 0;" id="autoLogin" 
								        name="chkRememberMe" type="checkbox" class="jdcheckbox"> 
									<label style="float:none;color:white; font-size:12px">自动登录</label>
								</span>
								
								<span style="margin-left:60px" class="forget-pw-safe">
								<a	style="color:white;font-size:12px; text-decoration: none;" 
								    href="${baseURL }/user/forgot.do" 
								    target="_blank">忘记密码?</a>
								</span>
							</div>
						</div>
					</div>

					<div class="fm-item">
						<label for="logonId" class="form-label"></label> <input
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
					style="background: url(${baseURL}/images/login/theme-pic2.jpg) #BCE0FF center 0 no-repeat;"></li>
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
		<p>骆宏 版权所有 Copyright 2012-2013</p>
	</div>

	<div style="text-align: center;">
		<p>
			来源：<a>宏宏</a>
		</p>
	</div>

</body>
</html>
