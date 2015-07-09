<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8"/>
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
								display : 'title',
								name : 'title',
								width : 200,
								align: 'left',
								render:function(obj){
									return "<a target=_blank href=${baseURL}/article/front/detail.do?navIndex=0&index=0&id=" + obj.id + ">" + obj.title+ "</a>";
								}
							}, 
							{
								display : '简介',
								name : 'summary',
								width : 400,
								align:"left"
							},
							{
								display : '是否置顶',
								name : 'top',
								width : 100,
								align:"center",
								render:function(obj){
									if(obj.top == 1){
										return "<span style='color:red;font-weight:bold;'>是</a>";
									}else{
										return "否";
									}
								}
							},
							
							{
								display : '操作',
								name : 'id',
								width : 100,
								align:"center",
								render:function(obj){
									var result = "<a target=_blank href=${baseURL}/article/edit.do?id=" + obj.id + ">" + "更新" + "</a>";
								    return result;
								}
							}
							],
							
							dataAction : "server",
							url : "${baseURL}/article/listJson.do",
							height : "98%",
							pageSize : 30,
							width : "98%",
							rownumbers : true,
							checkbox : true,
							groupColumnName:'typeName',
							autoCheckChildren: false,
							tree: { 
								columnName: 'name',
								treeLine:true,
								isExpand:false
							},
							toolbar : {
								items : [
										{
											text : "<a href=${baseURL}/article/add.do target=blank'>添加文章</a>",
											icon : 'add'
										},
										{
											line : true
										},
										{
											text : "置顶",
											click : topArticle,
											icon : 'add'
										},
										{
											text : "取消置顶",
											click : cancelTopArticle,
											icon : 'add'
										},
										
										{
											line : true
										},
										{
											text : '删除',
											click : deleteArticle,
											img : '${baseURL}/ligerUI/lib/ligerUI/skins/icons/delete.gif'
										} ]
							}
						});

		$("#pageloading").hide();
		
		function addChildResource(){
			var selectedRows = grid.getSelectedRows();
			if(selectedRows.length > 1){
				alert("不能同时选择多个父亲节点");
				return;
			}
			
            var parentId = selectedRows[0].id;
            
			if(!parentId){
				alert("请选择要添加的父亲结点");
				return;
			}
			
			if(parentId.indexOf(",") != -1){
				alert("不能同时选择多个父亲节点");
				return;
			}
			
			
			
			$.ligerDialog.open({
				height : 400,
				width : 600,
				title : '添加子模块权限',
				url : '${baseURL}/privilege/addChild.do?parentId='+parentId,
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
				title : '添加权限类别',
				url : '${baseURL}/privilege/add.do',
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
		function deleteArticle() {
			var ids = getSelectedRow();
			
			var url = "${baseURL}/article/delete.do?ids=" + ids;
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

		function updateArticleById(id){
			if(!id || id.length==0){
				alert("请选择要更新的文章");
				return;
			}
			window.open("${baseURL}/article/detail.do?id=" + id, "hello", false);
		}
		
		function cancelTopArticle(){
			var selectedRows = grid.getSelectedRows();
			var ids = "";
			var articleTypeIds = "";
			for ( var row in selectedRows) {
				ids += "," + selectedRows[row].id;
				articleTypeIds += "," + selectedRows[row].typeId;
			}
			var id = ids.substring(1, ids.length);
			var articleTypeId = articleTypeIds.substring(1, ids.length);
			
			if(id.indexOf(",") != -1){
				alert("不能同时取消置顶多个文章");
				return;
			}
			
			if(!id || id.length==0){
				alert("请选择要取消置顶的文章");
				return;
			}
			
			$.ajax({
				type : "POST",
				url : "${baseURL}/article/cancelTop.do?articleTypeId="+ articleTypeId +"&id=" + id,
				error : function(request) {
					alert("error");
				},
				success : function(data) {
					grid.reload(); //reload grid data
					$.ligerDialog.tip( //show delete success tip
					{
						title : '提示信息',
						content : '取消置顶成功'
					});
				}
			});
		}
		
		function topArticle() {
			var selectedRows = grid.getSelectedRows();
			var ids = "";
			var articleTypeIds = "";
			for ( var row in selectedRows) {
				ids += "," + selectedRows[row].id;
				articleTypeIds += "," + selectedRows[row].typeId;
			}
			var id = ids.substring(1, ids.length);
			var articleTypeId = articleTypeIds.substring(1, ids.length);
			
			if(id.indexOf(",") != -1){
				alert("不能同时置顶多个文章");
				return;
			}
			
			if(!id || id.length==0){
				alert("请选择要置顶的文章");
				return;
			}
			
			$.ajax({
				type : "POST",
				url : "${baseURL}/article/top.do?articleTypeId="+ articleTypeId +"&id=" + id,
				error : function(request) {
					alert("error");
				},
				success : function(data) {
					grid.reload(); //reload grid data
					$.ligerDialog.tip( //show delete success tip
					{
						title : '提示信息',
						content : '置顶成功'
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

	<div id="maingrid"></div>

	<div style="display: none;"></div>
</body>
</html>
