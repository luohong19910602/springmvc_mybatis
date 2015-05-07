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

<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>添加文章</title>
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
			var editor1 = K.create('textarea[name="content1"]', {
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
			                url:"${baseURL }/article/addSubmit.do",
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
			                url:"${baseURL }/article/addSubmit.do",
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
	<form id="example" name="example" method="post"
		action="${baseURL }/article/addSubmit.do">
		<div>
			<select id="selType"><option value="0">请选择</option>
				<option value="1">原创</option>
				<option value="2">转载</option>
				<option value="4">翻译</option></select> <input type="text" id="txtTitle"
				style="width: 560px; height: 20px; float: left;" maxlength="100">
			<span style="display: inline-block; padding: 4px 0 0 10px;">*只有原创和翻译文章才能推荐到首页</span>
		</div>
		
		<textarea name="content1" cols="100" rows="8"
			style="width: 700px; height: 200px; visibility: hidden;">
		</textarea>
        
        <div class="btn_area_1">
            <input id="btnPublish" type="submit" class="input_btn_1" value="发表文章" title="保存并跳转">
        </div>
	</form>
</body>
</html>

<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>