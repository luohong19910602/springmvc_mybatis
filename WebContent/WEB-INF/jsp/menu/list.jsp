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
<title></title>
<link
	href="${baseURL}/ligerUI/lib/ligerUI/skins/Aqua/css/ligerui-all.css"
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
</style>

<script type="text/javascript">
	var menu = null;
	var actionNodeId = null; //选中的menu id
	var tab = null;
	var actionNodeName = null; //选中menu name
	var addSubMenuTabId = new Date().getTime(); //添加子menu时的tab id
	var tree = null;

	function itemclick(item, i) {
		alert(actionNodeID + " | " + item.text);
	}

	$(function() {
		//当用户点击右键时的事件
		menu = $.ligerMenu({
			top : 100,
			left : 100,
			width : 120,
			items : [ {
				text : '增加子菜单',
				click : addMenu,
				icon : 'add'
			}, {
				text : '增加新菜单',
				click : addSiblingMenu,
				icon : 'add'
			}, {
				text : '修改菜单',
				click : itemclick
			}, {
				text : '删除菜单',
				click : deleteMenu,
				icon : 'delete'
			}, {
				line : true
			} ]
		});

		//将树的数据展示出来
		tree = $("#tree1").ligerTree({
			onContextmenu : function(node, e) {
				actionNodeId = node.data.id; //补货menu id
				actionNodeName = node.data.text;
				menu.show({
					top : e.pageY,
					left : e.pageX
				});
				return false;
			},
			onSelect : openResource,
			idFieldName : 'id',
			checkbox : false,
			isExpand : true,
			url : "${baseURL}/menu/listJson.do"
		});

		//liger tab
		$("#framecenter").ligerTab({
			height : "100%",
			showSwitchInTab : true,
			showSwitch : true,
			contextmenu : true
		});

		tab = liger.get("framecenter");

		//添加子菜单
		function addMenu(menu) {
			var url = "${baseURL}/menu/add.do?parentId=" + actionNodeId;
			$.ligerDialog.open({
				height : 400,
				width : 600,
				title : '添加子菜单',
				url : url,
				showMax : false,
				showToggle : true,
				showMin : false,
				isResize : true,
				slide : false,
				data : {
					//这里是自定义传递的参数
					"tree" : tree
				}
			});
		}

		//添加兄弟菜单
		function addSiblingMenu() {
			var url = "${baseURL}/menu/add.do";
			$.ligerDialog.open({
				height : 800,
				width : 600,
				title : '添加新菜单',
				url : url,
				showMax : false,
				showToggle : true,
				showMin : false,
				isResize : true,
				slide : false,
				data : {
					//这里是自定义传递的参数
					"tree" : tree
				}
			});
		}

		//删除menu
		function deleteMenu(menu) {
			alert("确定删除该菜单吗？");
			var url = "${baseURL}/menu/delete.do?menuId=" + actionNodeId;
            
			$.ajax({
				cache : true,
				type : "POST",
				url : url,
				async : false,
				error : function(request) {
				},
				success : function(data) {
					tree.reload();
					$.ligerDialog.tip( //show delete success tip
					{
						title : '提示信息',
						content : '记录已经删除！'
					});
				}
			});
		}

		//打开菜单的url资源
		function openResource(menu) {
			var menuId = menu.data.id; //获取menu id
			var url = "${baseURL}/resource/openResource.do?menuId=" + menuId;

			var tabid = $(menu.target).attr("tabid");
			var flag = tab.isTabItemExist(tabid);

			if (!flag) { //add a new tab
				tabid = new Date().getTime();
				$(menu.target).attr("tabid", tabid);
				addTab(tabid, menu.data.text, url);
			} else { //refresh the tab
				selectTab(tabid);
				refreshTab(tabid);
			}
		}

		function refreshTab(tabid) {
			tab.reload(tabid);
		}

		function selectTab(tabid) {
			tab.selectTabItem(tabid);
		}

		//layout the page
		$("#layout1").ligerLayout({
			leftWidth : 200
		});
	});

	//add a new tab
	function addTab(tabid, text, url) {
		tab.addTabItem({
			tabid : tabid,
			text : text,
			url : url,
			callback : function() {
				//addShowCodeBtn(tabid); 
				addFrameSkinLink(tabid);
			}
		});
	}

	function addFrameSkinLink(tabid) {
		var prevHref = getLinkPrevHref(tabid) || "";
		var skin = getQueryString("skin");
		if (!skin)
			return;
		skin = skin.toLowerCase();
		attachLinkToFrame(tabid, prevHref + skin_links[skin]);
	}

	function getLinkPrevHref(iframeId) {
		if (!window.frames[iframeId])
			return;

		var head = window.frames[iframeId].document
				.getElementsByTagName('head').item(0);
		var links = $("link:first", head);

		for (var i = 0; links[i]; i++) {
			var href = $(links[i]).attr("href");
			if (href && href.toLowerCase().indexOf("ligerui") > 0) {
				return href.substring(0, href.toLowerCase().indexOf("lib"));
			}
		}
	}

	function getQueryString(name) {
		var now_url = document.location.search.slice(1), q_array = now_url
				.split('&');
		for (var i = 0; i < q_array.length; i++) {
			var v_array = q_array[i].split('=');
			if (v_array[0] == name) {
				return v_array[1];
			}
		}
		return false;
	}

	function attachLinkToFrame(iframeId, filename) {
		if (!window.frames[iframeId])
			return;

		var head = window.frames[iframeId].document
				.getElementsByTagName('head').item(0);
		var fileref = window.frames[iframeId].document.createElement("link");
		if (!fileref)
			return;

		fileref.setAttribute("rel", "stylesheet");
		fileref.setAttribute("type", "text/css");
		fileref.setAttribute("href", filename);

		head.appendChild(fileref);
	}
</script>
<style type="text/css">
body {
	padding: 10px;
	margin: 0;
}

#layout1 {
	width: 100%;
	margin: 40px;
	height: 400px;
	margin: 0;
	padding: 0;
}

#accordion1 {
	height: 270px;
}

h4 {
	margin: 20px;
}

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
</head>
<body style="padding: 10px">
	<div id="layout1">
		<div position="left" title="菜单列表">
			<ul id="tree1" style="margin-top: 3px;"></ul>
		</div>

		<div position="center" title="菜单资源列表" id="framecenter">
			<div tabid="home" title="操作手册" style="width: 100%; height: 100%">
				<div style="margin-left:20px; margin-top:10px;">
				    <p>菜单主要是设置该菜单下面的可访问url，这里面的url集合已经在权限管理模块配置好，直接选择即可</p>
				    <br>
				    <p style="font-weight:bold">操作步骤</p>
				    <br>
				    <p>第一步：点击左侧的菜单，选中需要管理的菜单</p>
				    <br>
				    <p>第二步：操作右侧的url管理界面</p>
				</div>	
			</div>
		</div>
	</div>
	<div style="display: none;"></div>
</body>
</html>
