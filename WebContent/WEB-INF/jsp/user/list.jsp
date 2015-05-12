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
<title>资源列表</title>
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
</style>

<script type='text/javascipt'>
    alert("用户名或者密码不能为空");
</script>

<script type="text/javascript">
	var grid = null;

	$(function() {
		grid = $("#maingrid")
				.ligerGrid(
						{
							columns : [ {
								display : '姓名',
								name : 'name',
								width : 100
							},
							{
							    display: 'qq',
							    name: 'qq',
							    width: 100
							},
							{
							    display: '博客地址',
							    name: 'blog',
							    width: 100
							},
							
							{
							    display: '手机号码',
							    name: 'tel',
							    width: 100
							},
							{
							    display: '出生地址',
							    name: 'address',
							    width: 100
							},{
							    display: '生日',
							    name: 'birthday',
							    width: 100
							},
							{
								display: '登录名',
								name: 'loginName',
								width: 100,
							},
							{
								display: '居住地址',
								name: 'currentAddress',
								width: 100,
							}
							],
							dataAction : "server",
							url : "${baseURL}/user/listJson.do",
							height : "98%",
							page:"1",
							pageSize : "10",
							width : "98%",
							usePage: true,
							rownumbers : true,
							checkbox : true,
							toolbar : {
								items : [
										{
											text : '增加',
											click : addUser,
											icon : 'add'
										},
										{
											line : true
										},
										{
											text : '编辑',
											click : updateUser,
											icon : 'update',
											icon : 'modify'
										},
										{
											line : true
										},
										{
											text : '删除',
											click : deleteUser,
											img : '${baseURL}/ligerUI/lib/ligerUI/skins/icons/delete.gif'
										} ]
							}
						});

		$("#pageloading").hide();

		//添加角色菜单
		function addUser() {
			
			$.ligerDialog.open({
				height : 500,
				width : 800,
				title : '添加用户',
				url : '${baseURL}/user/add.do',
				showMax : false,
				showToggle : true,
				showMin : false,
				isResize : true,
				slide : false,
				data : {
					"grid" : grid
				}
			});
		}
		
		function updateUser(){
			var userId = getSelectedRow();
			if(!userId) {
				alert("请选择要编辑的用户");
			    return;
			}
			if(userId.indexOf(",") != -1){
				alert("对不起，不可同时编辑两个用户");
				return;
			}
			
			$.ligerDialog.open({
				height : 500,
				width : 800,
				title : '编辑用户',
				url : '${baseURL}/user/getUserInfo.do?userId=' + userId,
				showMax : false,
				showToggle : true,
				showMin : false,
				isResize : true,
				slide : false,
				data : {
					"grid" : grid
				}
			});
		}

		//delete selected row
		function deleteUser() {
			var ids = getSelectedRow();
			
			var url = "${baseURL}/user/delete.do?ids=" + ids;
			
			$.ajax({
				type : "POST",
				url : url,
				error : function(request) {
					alert("error");
				},
				success : function(data) {
					var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
                	if(obj.status == "error"){
                		alert(obj.message);
                	}else if(obj.status == "success"){
                		grid.reload(); //reload grid data
    					$.ligerDialog.tip( //show delete success tip
    					{
    						title : '提示信息',
    						content : '记录已经删除！'
    					});	
                	}
					
					
				}
			});
		}

		//获取选中的菜单id
		//这里需要结合角色id
		//然后才能删除中间表的数据
		function getSelectedRow() {
			var selectedRows = grid.getSelectedRows();
			var ids = "";
			for ( var row in selectedRows) {
				ids += "," + selectedRows[row].id;
			}
			ids = ids.substring(1, ids.length);
			return ids;
		}
		
	});
	
	function f_search(){
		grid.setParm("loginName", "hong");
		grid.reload();
	}
	
</script>
</head>

<body>
	<div class="l-loading" style="display: block" id="pageloading"></div>
	<div class="l-clear"></div>
	<div id="maingrid"></div>
	<div style="display: none;"></div>
</body>
</html>
