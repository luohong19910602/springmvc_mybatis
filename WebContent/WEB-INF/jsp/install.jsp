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
<title></title>
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

<style type="text/css">
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
		$("#Button1").click(function(){
			
			var database = $("#database").val();
			var username = $("#username").val();
			var password = $("#password").val();
			
			if(!database){
				alert("数据库名字不能为空");
				return;
			}
			
			if(!username){
				alert("用户名不能为空");
				return;
			}
			
			if(!password){
				alert("密码不能为空");
				return;
			}
			
			$.ajax({
                cache: true,
                type: "POST",
                url:"${baseURL}/installSubmit.do",
                data:$('#form1').serialize(),// 你的formid
                async: false,
                error: function(request) {
                },
                success: function(data) {
                	var json = JSON.parse(data);
                	if(json.status == "error"){
                		alert(json.message);
                		return;
                	}
                	
                	alert("恭喜你，安装成功");
                }
            });
		});
	});
</script>

</head>

<body style="text-align: center; margin: 20px">
	<h1>欢迎来到安装界面，请确保数据库为mysql，并且安装数据库名不能已经存在，否则会安装失败</h1>
	<br>
	<div>
		<form id="form1" name="form1" method="post" action="#">
			<table cellpadding="0" cellspacing="0" class="l-table-edit">
				<tr>
					<td align="right" class="l-table-edit-td">数据库名字:</td>
					<td align="left" class="l-table-edit-td"><input
						name="database" type="text" id="database" />
					<td align="left"></td>
				</tr>

				<tr>
					<td align="right" class="l-table-edit-td">用户名:</td>
					<td align="left" class="l-table-edit-td"><input
						name="username" type="text" id="username" /></td>
					<td align="left"></td>
				</tr>

				<tr>
					<td align="right" class="l-table-edit-td">密码:</td>
					<td align="left" class="l-table-edit-td"><input
						name="password" type="password" id="password" /></td>
					<td align="left"></td>
				</tr>
			</table>
			<br /> <input style="margin-left: 40px" type="button" value="安装"
				id="Button1" class="l-button l-button-submit" /> <input
				type="reset" value="重置" class="l-button l-button-reset" />
		</form>
	</div>

	<div style="display: none">
		<!--  数据统计代码 -->
	</div>
</body>
</html>
