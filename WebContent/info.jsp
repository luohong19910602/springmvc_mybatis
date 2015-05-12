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
<title>登录用户信息</title>
<link
	href="${baseURL}/ligerUI/lib/ligerUI/skins/Aqua/css/ligerui-all.css"
	rel="stylesheet" type="text/css" />
<link href="${baseURL}/ligerUI/lib/ligerUI/skins/Silvery/css/style.css"
	rel="stylesheet" type="text/css" />
<script src="${baseURL}/ligerUI/lib/jquery/jquery-1.3.2.min.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/core/base.js"
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
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerTip.js"
	type="text/javascript"></script>
<script
	src="${baseURL}/ligerUI/lib/jquery-validation/jquery.validate.min.js"
	type="text/javascript"></script>
<script
	src="${baseURL}/ligerUI/lib/jquery-validation/jquery.metadata.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/jquery-validation/messages_cn.js"
	type="text/javascript"></script>

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


<script type="text/javascript">
	//设置menuId到表单中
	$(function() {
		$("#form1").ligerForm();
	});
</script>

</head>

<body style="margin:10px">
	<p>用户基本信息</p>
	<br/>
	<form id="form1" name="form1" method="post" action="#">
		<div></div>
		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tr>
				<td align="right" class="l-table-edit-td">名字:</td>
				<td align="left" class="l-table-edit-td"><input name="name"
					id="name" value="${user.name }" disabled="disabled"></td>
				<td align="left"></td>
				<td align="right" class="l-table-edit-td">登录名:</td>
				<td align="left" class="l-table-edit-td"><input
					name="loginName" id="loginName" disabled="disabled" value="${user.loginName }"></td>
				<td align="left"></td>
			</tr>

			<tr>
				<td align="right" class="l-table-edit-td">邮箱:</td>
				<td align="left" class="l-table-edit-td"><input name="email"
					id="email" disabled="disabled" value="${user.email}"></td>
				<td align="left"></td>

				<td align="right" class="l-table-edit-td">QQ:</td>
				<td align="left" class="l-table-edit-td"><input name="qq"
					id="qq" disabled="disabled" value="${user.qq}"></td>
				<td align="left"></td>
			</tr>

			<tr>

				<td align="right" class="l-table-edit-td">电话:</td>
				<td align="left" class="l-table-edit-td"><input disabled="disabled" value="${user.tel}" name="tel"
					id="tel"></td>
				<td align="left"></td>
			
				<td align="right" class="l-table-edit-td">生日:</td>
				<td align="left" class="l-table-edit-td"><input name="birthday"
					type="text" ltype="date" id="birthday" disabled="disabled" value="${user.birthday}"> </td>
				<td align="left"></td>
			</tr>
			
			<tr>
				<td align="right" class="l-table-edit-td">博客:</td>
				<td align="left" class="l-table-edit-td"><input name="blog"
					type="text" id="birthday" maxlength="200" disabled="disabled" value="${user.blog }"></td>
				<td align="left"></td>
				
			</tr>

			<tr>
				<td align="right" class="l-table-edit-td">现居地址:</td>
				<td align="left" class="l-table-edit-td"><textarea
						name="currentAddress" disabled="disabled" name="currentAddress" cols="50" rows="2">${user.currentAddress}</textarea></td>
				<td align="left"></td>
			
				<td align="right" class="l-table-edit-td">出生地址:</td>
				<td align="left" class="l-table-edit-td"><textarea
						name="address" disabled="disabled" id="address" cols="50" rows="2">${user.address }</textarea></td>
				<td align="left"></td>
			</tr>
		</table>
	</form>
	<br/>
	
	
	<p>用户角色</p>
	<br/>
	<div>${user.roleNames }</div>
	
	<br/>
	<p>用户权限</p>
	<br/>
	<div>${user.roleNames }</div>
	
	<div style="display: none">
		<!--  数据统计代码 -->
	</div>
</body>
</html>
