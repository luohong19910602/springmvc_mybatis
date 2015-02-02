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
<meta charset="UTF-8" />
<title>用户信息</title>
<link
	href="${baseURL}/ligerUI/lib/ligerUI/skins/Aqua/css/ligerui-all.css"
	rel="stylesheet" type="text/css" />

<link href="${baseURL}/ligerUI/lib/ligerUI/skins/ligerui-icons.css"
	rel="stylesheet" type="text/css" />
<script src="${baseURL}/ligerUI/lib/jquery/jquery-1.3.2.min.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/core/base.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerLayout.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/jquery/jquery-1.3.2.min.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/core/base.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/json2.js"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/ligerui.all.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerTab.js"></script>
<script src="${baseURL}/ligerUI/lib/jquery.cookie.js"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerGrid.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerTab.js"></script>
<script
	src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerResizable.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerCheckBox.js"
	type="text/javascript"></script>

<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerForm.js"
	type="text/javascript"></script>
<script
	src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerDateEditor.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerComboBox.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerCheckBox.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerButton.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerDialog.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerRadio.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerSpinner.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerTextBox.js"
	type="text/javascript"></script>
<script src="${baseURL }/ligerUI/lib/ligerUI/js/plugins/ligerDrag.js"
	type="text/javascript"></script>

<style type="text/css">
.l-table-edit-td {
	padding: 4px;
}
</style>

<script>
	var grid = null;

	$(function() {
		grid = $("#maingrid").ligerGrid({
			columns : [ {
				display : 'name',
				name : 'name',
				width : 200,
				align : 'left'
			}, {
				display : 'url',
				name : 'url',
				width : 400,
				align : "left"
			}, {
				display : 'desc',
				width : 300,
				name : 'desc'
			} ],
			dataAction : "server",
			url : "${baseURL}/user//getUserPrivilegeJson.do?userId=${userInfo.id}",
			height : "98%",
			pageSize : 30,
			width : "98%",
			tree : {
				columnName : 'name',
				treeLine : true,
				isExpand : false
			}
		});
		
		
		
		$("#rolegrid").ligerGrid(
				{
					columns : [ {
						display : '姓名',
						name : 'name',
						width : 200,
						align: "left"
					},
					{
						display : 'desc',
						name : 'desc',
						width : 200
					}
					],
					dataAction : "server",
					url : "${baseURL}/user/getUserRoleJson.do?userId=${userInfo.id}",
					height : "98%",
					pageSize : 30,
					width : "98%",
					rownumbers : true,
					checkbox : true,
					tree: { columnName: 'name' }
				});

		$("form").ligerForm();
		
		$("#pageloading").hide();
	});
</script>

<script type="text/javascript">
	
</script>
</head>

<body>
	<div class="l-clear"></div>

	<br>
	<h2>您的基本信息</h2>
	<div>
		<form id="form1" name="form1" method="post" action="#">
			<table cellpadding="0" cellspacing="0" class="l-table-edit">
				<tr>
					<input type="hidden" name="id" value="${userInfo.id }">
					<td align="right" class="l-table-edit-td">名字:</td>
					<td align="left" class="l-table-edit-td"><input name="name"
						value="${userInfo.name }" id="name"></td>
					<td align="left"></td>
					<td align="right" class="l-table-edit-td">登录名:</td>
					<td align="left" class="l-table-edit-td"><input
						name="loginName" value="${userInfo.loginName }" id="loginName"></td>

					<td align="left"></td>
				</tr>

				<tr>
					<td align="right" class="l-table-edit-td">密码:</td>
					<td align="left" class="l-table-edit-td"><input
						name="password" type="password" id="password"></td>
					<td align="left"></td>

					<td align="right" class="l-table-edit-td">邮箱:</td>
					<td align="left" class="l-table-edit-td"><input name="email"
						value="${userInfo.email }" id="email"></td>
					<td align="left"></td>
				</tr>

				<tr>
					<td align="right" class="l-table-edit-td">QQ:</td>
					<td align="left" class="l-table-edit-td"><input name="qq"
						value="${userInfo.qq }" id="qq"></td>
					<td align="left"></td>

					<td align="right" class="l-table-edit-td">电话:</td>
					<td align="left" class="l-table-edit-td"><input name="tel"
						value="${userInfo.tel }" id="tel"></td>
					<td align="left"></td>
				</tr>

				<tr>
					<td align="right" class="l-table-edit-td">生日:</td>
					<td align="left" class="l-table-edit-td"><input
						name="birthday" value="${userInfo.birthday }" ltype="date"
						id="birthday"></td>
					<td align="left"></td>
				</tr>

				<tr>
					<td align="right" class="l-table-edit-td">角色列表:</td>
					<td align="left" class="l-table-edit-td"><textarea cols="80" rows="3"
						name="roleNames" id="roleNames">${userInfo.roleNames }</textarea></td>
					<td align="left"></td>
				</tr>
			</table>
		</form>
	</div>

	<br>
	<h2>您的权限</h2>
	<div id="maingrid"></div>
	<div style="display: none;"></div>
</body>
</html>
