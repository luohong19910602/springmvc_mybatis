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
<html lang="en">
<head>
<!-- 
<title>Bootstrap 101 Template</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${baseURL }/boostrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="${baseURL }/boostrap/css/content.min.css" rel="stylesheet"
	media="screen">
<link href="${baseURL }/boostrap/css/docs.css" rel="stylesheet"
	media="screen">
<link href="${baseURL }/boostrap/css/bootstrap-responsive.css"
	rel="stylesheet" media="screen">
<link
	href="http://cdn.bootcss.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="${baseURL }/boostrap/css/site.min.css"
	rel="stylesheet">

<style>
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>

<script src="${baseURL }/boostrap/js/jquery.js"></script>
<script src="${baseURL }/boostrap/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$("#navigation li").click(function() {
			$(this).siblings().removeClass("active");
			$(this).addClass("active");
		});
	});
</script>
 -->
<title>Bootstrap 101 Template</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${baseURL }/boostrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="${baseURL }/boostrap/css/content.min.css" rel="stylesheet"
	media="screen">
<style>
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
<link href="${baseURL }/boostrap/css/bootstrap-responsive.css"
	rel="stylesheet" media="screen">
<link href="${baseURL }/boostrap/css/docs.css" rel="stylesheet"
	media="screen">
<script src="${baseURL }/boostrap/js/jquery.js"></script>
<script src="${baseURL }/boostrap/js/bootstrap.min.js"></script>

<script>
	    $(document).ready(function(){
            $("#navigation li").click(
			    function(){
				    $(this).siblings().removeClass("active");
					$(this).addClass("active");
				}
			);
        });
	</script>
</head>

<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<div class="nav-collapse collapse">
					<ul class="nav">${nav}</ul>
				</div>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="carousel slide" id="carousel-193625">
				${slide } 
				<a class="left carousel-control" data-slide="prev"
					href="#carousel-193625">&lsaquo;</a> <a
					class="right carousel-control" data-slide="next"
					href="#carousel-193625">&rsaquo;</a>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<div class="well sidebar-nav">
					<ul id="navigation" class="nav nav-list">${type }</ul>
				</div>
			</div>

			<div class="span9">${article }</div>
		</div>
	</div>

	<br>
	<br>
	<hr>
	<footer>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span4">
					<address>
						<strong>公司地址</strong><br /> 795 Folsom Ave, Suite 600<br /> San
						Francisco, CA 94107<br /> <abbr title="Phone">P:</abbr> (123)
						456-7890
					</address>
				</div>
				<div class="span4">
					<p>
						<em>关于我们</em>
					</p>
					<ul class="unstyled inline">
						<li>新闻资讯</li>
						<li>体育竞技</li>
						<li>娱乐八卦</li>
						<li>前沿科技</li>
						<li>环球财经</li>
						<li>天气预报</li>
						<li>房产家居</li>
						<li>网络游戏</li>
					</ul>
				</div>
				<div class="span4">
					<p>
						<em>加入我们</em>
					</p>
					<ul class="unstyled inline">
						<li>新闻资讯</li>
						<li>体育竞技</li>
						<li>娱乐八卦</li>
						<li>前沿科技</li>
						<li>环球财经</li>
						<li>天气预报</li>
						<li>房产家居</li>
						<li>网络游戏</li>
					</ul>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>