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
<meta charset="UTF-8"/>
<title>文章类别</title>
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
<script src="${baseURL }/ligerUI/lib/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>

<style type="text/css">
</style>

<script type="text/javascript">
	var grid = null;
	
	$(function() {
		grid = $("#maingrid")
				.ligerGrid(
						{
							columns : [ {
								display : '名字',
								name : 'name',
								width : 200,
								align: 'left'
							}, {
								display : '备注',
								width: 200,
								name : 'desc'
							}, {
								display : '排序',
								width: 200,
								name : 'sortFlag'
							}
							],
							dataAction : "server",
							url : "${baseURL}/navigation/listJson.do",
							height : "98%",
							pageSize : 30,
							width : "98%",
							rownumbers : true,
							checkbox : true,
							autoCheckChildren: false,
							tree: { 
								columnName: 'name',
								treeLine:true,
								isExpand:false
							},
							toolbar : {
								items : [
										{
											text : '增加',
											click : addNavigation,
											icon : 'add'
										},
										{
											line : true
										},
										{
											text : '修改',
											click : updateNavigation,
											icon : 'modify'
										},
										{
											line : true
										},
										{
											text : '删除',
											click : deleteNavigation,
											img : '${baseURL}/ligerUI/lib/ligerUI/skins/icons/delete.gif'
										} ]
							}
						});

		$("#pageloading").hide();

		function addArticleType() {
			f_open();
		}
		
		function addNavigation(){
			$.ligerDialog.open({
				height : 400,
				width : 600,
				title : '添加文章',
				url : '${baseURL}/navigation/add.do',
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

		function f_open() {
			$.ligerDialog.open({
				height : 400,
				width : 600,
				title : '添加文章类别',
				url : '${baseURL}/articleType/add.do',
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
		function deleteNavigation() {
			var ids = getSelectedRow();
			
			var url = "${baseURL}/navigation/delete.do?ids=" + ids;
			
			$.ajax({
				type : "POST",
				url : url,
				error : function(request) {
					alert("error");
				},
				success : function(data) {
					grid.reload(); //reload grid data
					$.ligerDialog.tip( //show delete success tip
					{
						title : '提示信息',
						content : '记录已经删除！'
					});
				}
			});
		}

		//get selected row id
		function getSelectedRow() {
			var selectedRows = grid.getSelectedRows();
			var ids = "";
			for ( var row in selectedRows) {
				ids += "," + selectedRows[row].id;
			}
			ids = ids.substring(1, ids.length);
			
			return ids;
		}
		
		function updateNavigation() {
			var id = getSelectedRow();
			if(id.indexOf(",") != -1){
				alert("不能同时更新多个文章类别");
				return;
			}
			
			if(!id || id.length==0){
				alert("请选择要更新的文章类别");
				return;
			}
			
			$.ligerDialog.open({
				height : 400,
				width : 600,
				title : '更新文章类别',
				url : '${baseURL}/navigation/update.do?id=' + id,
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
	});
	
</script>
</head>

<body>
	<div class="l-loading" style="display: block" id="pageloading"></div>

	<div class="l-clear"></div>

	<div id="maingrid"></div>

	<div style="display: none;"></div>
</body>
</html>
