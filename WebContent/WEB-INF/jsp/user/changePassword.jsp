<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<title>添加角色权限</title>
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
		$("form").ligerForm();
		//提交表单
		$("#Button1").click(function(){
			var oldPassword = $("#oldPassword").val();
			var newPassword = $("#newPassword").val();
			var confirmPassword = $("#confirmPassword").val();
			
			if(!oldPassword){
				alert("请输入旧密码");
				return;
			}
			if(!newPassword){
				alert("请输入新密码");
				return;
			}
			if(!confirmPassword){
				alert("请输入确认密码");
				return;
			}
			
			if(newPassword != confirmPassword){
				alert("新密码不一致");
				return;
			}
			
			//验证表单数据是否填写
			$.ajax({
                cache: true,
                type: "POST",
                url:"${baseURL }/user/changePasswordSubmit.do",
                data:$('#form1').serialize(),// 你的formid
                async: false,
                error: function(request) {
                    alert("网络错误，请重试");
                },
                success: function(data) {
                    var json = JSON.parse(data);
                    if(json.status == "success"){
                    	alert(json.message);
                    }else{
                    	alert(json.message);
                    }
                }
            });
		});
	});
</script>

</head>

<body style="margin:10px">
	<form id="form1" name="form1" method="post">
		<div></div>
		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tr>
				<td align="right" class="l-table-edit-td">旧密码:</td>
				<td align="left" class="l-table-edit-td">
				<input name="oldPassword"
					id="oldPassword" type="password"></td>
				<td align="left"></td>
			</tr>

			<tr>
				<td align="right" class="l-table-edit-td">新密码:</td>
				<td align="left" class="l-table-edit-td"><input name="newPassword"
					type="password" id="newPassword"></td>
				<td align="left"></td>
			</tr>

			<tr>
				<td align="right" class="l-table-edit-td">确认密码:</td>
				<td align="left" class="l-table-edit-td"><input name="confirmPassword"
					type="password" id="confirmPassword"></td>
				<td align="left"></td>
			</tr>
		</table>
		<br /> <input style="margin-left: 40px" type="button" value="提交"
			id="Button1" class="l-button l-button-submit" /> 
			<input type="reset"
			value="重置" class="l-button l-button-reset" />
	</form>
	<div style="display: none">
		<!--  数据统计代码 -->
	</div>
</body>
</html>
