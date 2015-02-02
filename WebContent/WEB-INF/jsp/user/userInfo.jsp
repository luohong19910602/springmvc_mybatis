<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<title></title>

<link
	href="${baseURL}/ligerUI/lib/ligerUI/skins/Aqua/css/ligerui-all.css"
	rel="stylesheet" type="text/css" />
<script src="${baseURL}/ligerUI/lib/jquery/jquery-1.3.2.min.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/core/base.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerGrid.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerTab.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerDrag.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerTab.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("#navtab1").ligerTab();
	});
</script>
<style type="text/css">
.l-table-edit {
	
}

.l-table-edit-td {
	padding: 4px;
}

.l-button-submit,.l-button-reset {
	width: 80px;
	float: left;
	margin-left: 10px;
	padding-bottom: 2px;
}
</style>

</head>

<body style="padding: 10px">
	<div id="navtab1"
		style="width: 750px; overflow: hidden; border: 1px solid #A3C0E8;">
		<div tabid="home" title="${userInfo.name }的基本信息" lselected="true" style="height: 380px">
			<iframe frameborder="0" name="showmessage"
				src="${baseURL }/user/edit.do?userId=${userInfo.id}"></iframe>
		</div>
		<div title="${userInfo.name }的权限" showClose="true"  style="height: 380px">
			<iframe frameborder="0" name="showmessage"
				src="${baseURL }/user/getUserPrivilege.do?userId=${userInfo.id}"></iframe>
		</div>
		<div title="${userInfo.name }的菜单" showClose="true" style="height: 380px">
			<iframe frameborder="0" name="showmessage"
				src="${baseURL }/user/getUserMenu.do?userId=${userInfo.id}"></iframe>
		</div>
		<div title="${userInfo.name }的角色" showClose="true" style="height: 380px">
			<iframe frameborder="0" name="showmessage"
				src="${baseURL }/user/getUserRole.do?userId=${userInfo.id}"></iframe>
		</div>
		
	</div>
</body>
</html>
