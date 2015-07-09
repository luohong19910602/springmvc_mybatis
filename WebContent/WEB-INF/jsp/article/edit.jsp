<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>


<link rel="stylesheet" href="${baseURL }/css/main_article.css" />
<link rel="stylesheet" href="${baseURL }/css/style(1).css" />


<link rel="stylesheet" href="${baseURL }/css/style.css" />

<link rel="stylesheet" href="${baseURL }/css/ui.css" />

<link rel="stylesheet" href="${baseURL }/css/write.css" />

<link rel="stylesheet"
	href="${baseURL }/kindeditor/themes/default/default.css" />
<link rel="stylesheet"
	href="${baseURL }/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="${baseURL }/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="${baseURL }/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8"
	src="${baseURL }/kindeditor/plugins/code/prettify.js"></script>
<script>
KindEditor.ready(function(K) {
	var editor1 = K.create('textarea[name="content"]', {
		cssPath : '${baseURL }/kindeditor/plugins/code/prettify.css',
		uploadJson : '${baseURL }/kindeditor/jsp/upload_json.jsp',
		fileManagerJson : '${baseURL }/kindeditor/jsp/file_manager_json.jsp',
		allowFileManager : true,
		afterCreate : function() {
			var self = this;
			K.ctrl(document, 13, function() {
				//self.sync();
				
				$.ajax({
	                cache: true,
	                type: "POST",
	                url:"${baseURL }/article/editSubmit.do",
	                data:$('#example').serialize(),// 你的formid
	                async: false,
	                error: function(request) {
	                },
	                success: function(data) {
	                    dialog.close();  //close the dialog
	        			grid.reload();
	                }
	            });
			});
			
			K.ctrl(self.edit.doc, 13, function() {
				//self.sync();
				$.ajax({
	                cache: true,
	                type: "POST",
	                url:"${baseURL }/article/editSubmit.do",
	                data:$('#example').serialize(),// 你的formid
	                async: false,
	                error: function(request) {
	                },
	                success: function(data) {
	                    dialog.close();  //close the dialog
	        			grid.reload();
	                }
	            });
			});
		}
	});
	prettyPrint();
});
</script>
</head>
<body>
	<div id="wrap">
		<div id="editType" style="display: none">0</div>
		<form id="example" name="example" method="post"
			action="${baseURL }/article/editSubmit.do">
			<p class="subtit">文章标题</p>
			<div class="section">
			    <input type="hidden" name="id" value="${article.id }"/>
			    
				<input type="text" value="${article.title }" id="txtTitle" name="title"
					style="width: 560px; height: 20px; float: left;" maxlength="100">
			</div>

			<p class="subtit">文章简要介绍</p>
			<div class="section">
				<textarea cols="120" rows="5" id="summary" name="summary">${article.summary }</textarea>
			</div>

			<p class="subtit">文章内容</p>

			<div class="section">
				<textarea name="content" 
				    cols="150" rows="50"
					style="width: 900px; height: 600px; visibility: hidden;">
					${article.content }
		        </textarea>
			</div>

			<div id="moreDiv">
				<p class="subtit">
					个人分类 [<a href="/category" target="_blank">编辑分类</a>]
				</p>
				<div>
					<div>
						<div id="tagbox">
							<table id="tagtb" cellspacing="0">
								<tbody>
									<tr>${typeList }
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<p class="subtit"></p>
			</div>

			<div class="section">
				<!-- 
				<input id="btnPublish" type="submit" class="input_btn_1"
					value="发表文章" title="保存并跳转"> <input id="btnCancel"
					type="button" class="input_btn_1" value="舍弃"> <span
					id="sp_note" class="savenote" style="display: none;"></span>
					 -->
				<input type="submit" value="发表文章" title="保存并跳转"> <input
					id="btnCancel" type="reset" value="舍弃">
			</div>
		</form>
		<div class="clear"></div>
	</div>
</body>
</html>