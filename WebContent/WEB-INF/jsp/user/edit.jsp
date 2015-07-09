<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<title>添加角色权限</title>
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
		$("#roleNames").ligerComboBox({
            resize: true,
            width: 400,
            height: 30,
            selectBoxWidth: 600, selectBoxHeight:300,
            onBeforeOpen: f_selectContact
		});
		
		$("form").ligerForm();
		
		//提交表单
		$("#Button1").click(function(){
			//验证表单数据是否填写
			
			$.ajax({
                cache: true,
                type: "POST",
                url:"${baseURL }/user/editSubmit.do",
                data:$('#form1').serialize(),// 你的formid
                async: false,
                error: function(request) {
                },
                success: function(data) {
                    alert("更新用户信息成功");
                    
                }
            });
		});
	});
	
	function f_selectContact()
    {
        $.ligerDialog.open({ title: '选择角色', 
        	name:'winselector', 
        	width: 700, height: 300, 
        	url: '${baseURL}/role/listByTree.do', 
        	buttons: [
                { text: '确定', onclick: f_selectContactOK },
                { text: '取消', onclick: f_selectContactCancel }
            ]
        });
        return false;
    }
	
	//确定选择
	function f_selectContactOK(item, dialog) {
        var selectNode = dialog.frame.selectNode || dialog.frame.window.selectNode; 
        var nodes = selectNode();   //获取选中的id
        //alert(data);
        
        if (!nodes || nodes.length == 0){
            alert('请选择行!');
            return;
        }
        
        var roleNameStr = "";
        var roleIdStr = "";
        
        for(var i=0; i<nodes.length; i++){
        	if(i == nodes.length-1){
        		roleNameStr += nodes[i].name;
        		roleIdStr += nodes[i].id;
        	}else{
        		roleNameStr += nodes[i].name + ",";
        		roleIdStr += nodes[i].id + ",";
        	}
        }
        
        $("#roleNames").val(roleNameStr);
        $("#roleIdList").val(roleIdStr);
        dialog.close();
    }
	
	//取消选择
    function f_selectContactCancel(item, dialog)
    {
        dialog.close();
    }
</script>

</head>

<body>
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
				<td align="left" class="l-table-edit-td"><input name="password"
					type="password" id="password"></td>
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
				<td align="left" class="l-table-edit-td"><input name="birthday"
					value="${userInfo.birthday }" ltype="date" id="birthday"></td>
				<td align="left"></td>
				
				<td align="right" class="l-table-edit-td">博客:</td>
				<td align="left" class="l-table-edit-td"><input name="blog"
					type="text" id="birthday" value="${userInfo.blog }"></td>
				<td align="left"></td>
				
			</tr>

            <tr>
				<td align="right" class="l-table-edit-td">现居地址:</td>
				<td align="left" class="l-table-edit-td"><textarea
						name="currentAddress" name="currentAddress" cols="50" rows="3">${userInfo.currentAddress }</textarea></td>
				<td align="left"></td>
			</tr>

			<tr>
				<td align="right" class="l-table-edit-td">出生地址:</td>
				<td align="left" class="l-table-edit-td"><textarea
						name="address" id="address" cols="50" rows="3">${userInfo.address }</textarea></td>
				<td align="left"></td>
			</tr>
			
			<tr>
				<td align="right" class="l-table-edit-td">角色列表:</td>
				<td align="left" class="l-table-edit-td"><input
					name="roleNames" id="roleNames"> <input name="roleIdList"
					id="roleIdList" type="hidden" /></td>
				<td align="left"></td>
			</tr>
		</table>
		<br /> <input style="margin-left: 40px" type="submit" value="更新"
			id="Button1" class="l-button l-button-submit" /> <input type="reset"
			value="重置" class="l-button l-button-reset" />
	</form>
	<div style="display: none">
		<!--  数据统计代码 -->
	</div>
</body>
</html>
