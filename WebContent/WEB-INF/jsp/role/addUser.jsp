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
<title>添加用户到角色中</title>
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
	
	var dialog = frameElement.dialog; //调用页面的dialog对象(ligerui对象)
    var data = dialog.get('data');  //获取参数
	var grid = data["grid"];  //获得list界面的grid对象，关闭dialog时，刷新数据
    
	var roleId = "${roleId}";
	
	//设置menuId到表单中
	$(function() {
		$("#userIds").ligerComboBox({
            resize: true,
            width: 400,
            height: 30,
            selectBoxWidth: 400, selectBoxHeight:300,
            valueFieldID: "userIdList",  //隐藏id字段
            valueField: "id",  //
            textField: 'name',
			grid:{
					columns : [ {
						display : '姓名',
						name : 'name',
						width : 80
					},
					{
					    display: 'qq',
					    name: 'qq',
					    width: 80
					},
					
					{
					    display: '手机号码',
					    name: 'tel',
					    width: 100
					},
					{
					    display: '生日',
					    name: 'birthday',
					    width: 120
					},
					{
						display: '登录名',
						name: 'loginName',
						width: 120,
					}
					
					],
					dataAction : "server",
					url : "${baseURL}/user/listJson.do",
					pageSize : 30,
					width : "98%",
					rownumbers : true,
					checkbox : true
				}
				 
		});
		
		
		$("#userNames").ligerComboBox({
            resize: true,
            width: 400,
            height: 30,
            selectBoxWidth: 500, selectBoxHeight:400,
            onBeforeOpen: f_selectContact
		});
		
		$("#Button1").click(function(){
			//验证表单数据是否填写
			$.ajax({
                cache: true,
                type: "POST",
                url:"${baseURL }/role/addUserSubmit.do",
                data:$('#form1').serialize(),// 你的formid
                async: false,
                error: function(request) {
                },
                success: function(data) {
                    dialog.close();  //close the dialog
        			grid.reload();
                }
            });
		});
	});
	
	function f_selectContact()
    {
        $.ligerDialog.open({ title: '选择用户', 
        	name:'winselector', 
        	width: 500, height: 400, 
        	url: '${baseURL}/user/selectUser.do', 
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
        
        var userNameStr = "";
        var userIdStr = "";
        
        for(var i=0; i<nodes.length; i++){
        	if(i == nodes.length-1){
        		userNameStr += nodes[i].name;
        		userIdStr += nodes[i].id;
        	}else{
        		userNameStr += nodes[i].name + ",";
        		userIdStr += nodes[i].id + ",";
        	}
        }
        
        $("#userNames").val(userNameStr);
        $("#userList").val(userIdStr);
        
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

		<input type="hidden" id="roleId" name="roleId" value="${roleId}">

		<table cellpadding="0" cellspacing="0" class="l-table-edit">
			<tr>
				<td align="right" class="l-table-edit-td">用户列表:</td>
				<td align="left" class="l-table-edit-td"><input
					name="userNames" id="userNames"> 
					<input name="userList"
					id="userList" type="hidden" /></td>
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
