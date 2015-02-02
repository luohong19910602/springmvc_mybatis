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
	
	var dialog = frameElement.dialog; //调用页面的dialog对象(ligerui对象)
    var data = dialog.get('data');  //获取参数
	var grid = data["grid"];  //获得list界面的grid对象，关闭dialog时，刷新数据
    
	//设置menuId到表单中
	$(function() {
		
		$("#roleNames").ligerComboBox({
            resize: true,
            width: 500,
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
                url:"${baseURL }/user/addSubmit.do",
                data:$('#form1').serialize(),// 你的formid
                async: false,
                error: function(request) {
                    alert("网络错误，请重试");
                },
                success: function(data) {
                	var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
                	if(obj.status == "error"){
                		alert(obj.message);
                		dialog.close();  //close the dialog
                	}else if(obj.status == "success"){
                		dialog.close();  //close the dialog
                		grid.reload();	
                	}
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
		<div></div>
		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tr>
				<td align="right" class="l-table-edit-td">名字:</td>
				<td align="left" class="l-table-edit-td"><input name="name"
					id="name"></td>
				<td align="left"></td>
				<td align="right" class="l-table-edit-td">登录名:</td>
				<td align="left" class="l-table-edit-td"><input
					name="loginName" id="loginName"></td>
				<td align="left"></td>
			</tr>

			<tr>
				<td align="right" class="l-table-edit-td">密码:</td>
				<td align="left" class="l-table-edit-td"><input name="password"
					type="password" id="password"></td>
				<td align="left"></td>

				<td align="right" class="l-table-edit-td">邮箱:</td>
				<td align="left" class="l-table-edit-td"><input name="email"
					id="email"></td>
				<td align="left"></td>
			</tr>

			<tr>
				<td align="right" class="l-table-edit-td">QQ:</td>
				<td align="left" class="l-table-edit-td"><input name="qq"
					id="qq"></td>
				<td align="left"></td>

				<td align="right" class="l-table-edit-td">电话:</td>
				<td align="left" class="l-table-edit-td"><input name="tel"
					id="tel"></td>
				<td align="left"></td>
			</tr>

			<tr>
				<td align="right" class="l-table-edit-td">生日:</td>
				<td align="left" class="l-table-edit-td"><input name="birthday"
					type="text" ltype="date" id="birthday"></td>
				<td align="left"></td>
			</tr>

			<tr>
				<td align="right" class="l-table-edit-td">现居地址:</td>
				<td align="left" class="l-table-edit-td"><textarea
						name="currentAddress" name="currentAddress" cols="70" rows="2"></textarea></td>
				<td align="left"></td>
			</tr>

			<tr>
				<td align="right" class="l-table-edit-td">出生地址:</td>
				<td align="left" class="l-table-edit-td"><textarea
						name="address" id="address" cols="70" rows="2"></textarea></td>
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
		<br /> <input style="margin-left: 40px" type="submit" value="提交"
			id="Button1" class="l-button l-button-submit" /> <input type="reset"
			value="重置" class="l-button l-button-reset" />
	</form>
	<div style="display: none">
		<!--  数据统计代码 -->
	</div>
</body>
</html>
