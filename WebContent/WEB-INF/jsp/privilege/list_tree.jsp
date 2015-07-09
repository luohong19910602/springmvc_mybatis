<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

<script type="text/javascript">
	//var grid = null;
	var tree = null;
	var menu = null;
	actionNodeId = null;
	actionNodeName = null;
	
	$(function() {
		menu = $.ligerMenu({
			top : 100,
			left : 100,
			width : 120,
			items : [ {
				text : '增加新类别',
				click : addPrivilegeType,
				icon : 'add'
			},
			{
				text : '增加链接',
				click : addPrivilege,
				icon : 'add'
			}
			,
			{
				text : '删除菜单',
				click : deletePrivilege,
				icon : 'delete'
			}, {
				line : true
			} ]
		});
		
		tree = $("#maintree").ligerTree({
			url : "${baseURL}/privilege/listTreeJson.do",
			onContextmenu : function(node, e) {
				actionNodeId = node.data.id; 
				actionNodeName = node.data.text;
				menu.show({
					top : e.pageY,
					left : e.pageX
				});
				return false;
			},
		});
		
		$("#pageloading").hide();
		
		//添加权限
		function addPrivilege(menu) {
			$.ligerDialog.open({
				height : 400,
				width : 600,
				title : '添加子模块权限',
				url : '${baseURL}/privilege/addChild.do?parentId='+actionNodeId,
				showMax : false,
				showToggle : true,
				showMin : false,
				isResize : true,
				slide : false,
				data : {
					"tree" : tree
				}
			});
		}
		
		//添加权限类别
		function addPrivilegeType(menu) {
			$.ligerDialog.open({
				height : 400,
				width : 600,
				title : '添加权限类别',
				url : '${baseURL}/privilege/add.do',
				showMax : false,
				showToggle : true,
				showMin : false,
				isResize : true,
				slide : false,
				data : {
					"tree" : tree
				}
			});
		}
		
		/**
		删除一个权限
		*/
		function deletePrivilege(menu){
            var url = "${baseURL}/privilege/delete.do?idsStr=" + actionNodeId;
			$.ajax({
				type : "POST",
				url : url,
				error : function(request) {
					alert("error");
				},
				success : function(data) {
					tree.reload(); //reload grid data
					$.ligerDialog.tip( //show delete success tip
					{
						title : '提示信息',
						content : '记录已经删除！'
					});
				}
			});
		}
	});
	
</script>
</head>

<body>
	<div class="l-loading" style="display: block" id="pageloading"></div>

	<div class="l-clear"></div>

	<div id="maintree"></div>

	<div style="display: none;"></div>
</body>
</html>
