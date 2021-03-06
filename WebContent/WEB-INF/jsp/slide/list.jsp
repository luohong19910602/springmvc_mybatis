<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	


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
								display : '标题',
								name : 'title',
								width : 200,
								align: 'left'
							}, 
							{
								display : '图片',
								name : 'imgUrl',
								align: 'center',
								width: 210,
								render: function(obj){
									return "<img width='200px' height='200px' src='" + obj.imgUrl + "'/>";
								}
							},
							{
								display : '备注',
								width: 200,
								name : 'desc'
							}
							],
							dataAction : "server",
							url : "${baseURL}/slide/listJson.do",
							height : "98%",
							pageSize : 30,
							width : "98%",
							rowHeight: 204,
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
											click : addSlide,
											icon : 'add'
										},
										{
											line : true
										},
										{
											text : '删除',
											click : deleteSlide,
											img : '${baseURL}/ligerUI/lib/ligerUI/skins/icons/delete.gif'
										} ]
							}
						});

		$("#pageloading").hide();

		function addArticleType() {
			f_open();
		}
		
		function addSlide(){
			$.ligerDialog.open({
				height : 400,
				width : 600,
				title : '添加广告',
				url : '${baseURL}/slide/add.do',
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
		function deleteSlide() {
			var ids = getSelectedRow();
			var url = "${baseURL}/slide/delete.do?ids=" + ids;
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

		function updateArticleTypeById(id){
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
				url : '${baseURL}/articleType/edit.do?id=' + id,
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
		
		function updateArticleType() {
			var id = getSelectedRow();
			updateArticleTypeById(id);
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
