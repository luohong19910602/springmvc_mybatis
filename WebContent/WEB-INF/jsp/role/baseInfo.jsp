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
<title>角色基本信息</title>

<link
	href="${baseURL}/ligerUI/lib/ligerUI/skins/Aqua/css/ligerui-form.css"
	rel="stylesheet" type="text/css">
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

<style type="text/css">
</style>


<script type="text/javascript">
	
</script>

</head>

<body>
	<div></div>
	<form action="#" method="GET">
		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tbody>
				<tr>
					<td align="right" class="l-table-edit-td">名字:</td>
					<td align="left" class="l-table-edit-td"><div class="l-text"
							style="width: 178px;">
							<input disabled="disabled" name="name" type="text" id="name" ltype="text"
								class="l-text-field" value="${role.name }" ligeruiid="name" style="width: 174px;">
							<div class="l-text-l"></div>
							<div class="l-text-r"></div>
						</div></td>
					<td align="left"></td>
				</tr>
				<tr>
				    <td align="right" class="l-table-edit-td">创建人:</td>
					<td align="left" class="l-table-edit-td"><div class="l-text"
							style="width: 178px;">
							<input disabled="disabled" name="creator" type="text" id="creator" ltype="text"
								class="l-text-field" value="${role.creator }" ligeruiid="creator" style="width: 174px;">
							<div class="l-text-l"></div>
							<div class="l-text-r"></div>
						</div></td>
					<td align="left"></td>
				</tr>
				<tr>
				    <td align="right" class="l-table-edit-td">创建时间:</td>
					<td align="left" class="l-table-edit-td"><div class="l-text"
							style="width: 178px;">
							<input disabled="disabled" name="createdTime" type="text" id="createdTime" ltype="text"
								class="l-text-field" value="${role.creator }" ligeruiid="createdTime" style="width: 174px;">
							<div class="l-text-l"></div>
							<div class="l-text-r"></div>
						</div></td>
					<td align="left"></td>
				</tr>
                
			</tbody>
		</table>
	</form>
	<div style="display: none">
		<!--  数据统计代码 -->
	</div>
</body>
</html>
