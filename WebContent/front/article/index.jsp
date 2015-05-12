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
<html lang="en">
  <head>
    <title>Bootstrap 101 Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="${baseURL }/boostrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="${baseURL }/boostrap/css/content.min.css" rel="stylesheet" media="screen">
	<link href="${baseURL }/boostrap/css/docs.css" rel="stylesheet" media="screen">
	
	<style>
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }

      @media (max-width: 980px) {
        /* Enable use of floated navbar text */
        .navbar-text.pull-right {
          float: none;
          padding-left: 5px;
          padding-right: 5px;
        }
      }
    
	</style>
	<link href="${baseURL }/boostrap/css/bootstrap-responsive.css" rel="stylesheet" media="screen">
	
	<script src="${baseURL }/boostrap/js/jquery.js"></script>
	<script src="${baseURL }/boostrap/js/bootstrap.min.js"></script>
	
	<script src="${baseURL }/boostrap/js/bootstrap-transition.js"></script>
	<script src="${baseURL }/boostrap/js/bootstrap-alert.js"></script>
	<script src="${baseURL }/boostrap/js/bootstrap-modal.js"></script>
	<script src="${baseURL }/boostrap/js/bootstrap-dropdown.js"></script>
	<script src="${baseURL }/boostrap/js/bootstrap-scrollspy.js"></script>
	<script src="${baseURL }/boostrap/js/bootstrap-tab.js"></script>
	<script src="${baseURL }/boostrap/js/bootstrap-tooltip.js"></script>
	<script src="${baseURL }/boostrap/js/bootstrap-popover.js"></script>
	<script src="${baseURL }/boostrap/js/bootstrap-collapse.js"></script>
	<script src="${baseURL }/boostrap/js/bootstrap-carousel.js"></script>
	<script src="${baseURL }/boostrap/js/bootstrap-typeahead.js"></script>
	<script src="${baseURL }/boostrap/js/bootstrap-button.js"></script>
	<script src="${baseURL }/boostrap/js/bootstrap-transition.js"></script>
	
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
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">Project name</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
	
	<div class="container-fluid">
      <div class="row-fluid">
        <div class="span3">
          <div class="well sidebar-nav">
            <ul id="navigation" class="nav nav-list">
              <li class="nav-header">文章类别</li>
              ${type }
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
        
        <div class="span9">
            ${article }
        </div><!--/span-->
      </div><!--/row-->

      <hr>

<!-- 
      <footer>
        <p>? Company 2013</p>
      </footer>
 -->
    </div>
	
  </body>
</html>