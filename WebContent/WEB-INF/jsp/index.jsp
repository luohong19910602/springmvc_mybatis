<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String scheme = request.getScheme();
String serverName = request.getServerName();
String contextPath = request.getContextPath();
int port = request.getServerPort();

//网站的访问跟路径
String baseURL = scheme + "://" + serverName + ":"+ port + contextPath;
request.setAttribute("baseURL", baseURL);

%>
<!DOCTYPE html>
<html>
<head>
<link
	href="${baseURL}/ligerUI/lib/ligerUI/skins/Aqua/css/ligerui-all.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" id="mylink" />
<script src="${baseURL}/ligerUI/lib/jquery/jquery-1.3.2.min.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/ligerui.all.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerTab.js"></script>
<script src="${baseURL}/ligerUI/lib/jquery.cookie.js"></script>
<script src="${baseURL}/ligerUI/lib/json2.js"></script>

<title>欢饮来到后台管理系统</title>

<script type="text/javascript">
 
            var tab = null;
            var accordion = null;
            var tree = null;
            var tabItems = [];
            var addChangePassword = "changePassword";
            $(function ()
            {

                //布局
                $("#layout1").ligerLayout({ leftWidth: 190, height: '100%',heightDiff:-34,space:4, onHeightChanged: f_heightChanged });

                var height = $(".l-layout-center").height();
                
                //Tab
                $("#framecenter").ligerTab({
                    height: height,
                    showSwitchInTab : true,
                    showSwitch: true,
                    onAfterAddTabItem: function (tabdata)
                    {
                        tabItems.push(tabdata);
                        //saveTabStatus();
                    },
                    onAfterRemoveTabItem: function (tabid)
                    { 
                        for (var i = 0; i < tabItems.length; i++)
                        {
                            var o = tabItems[i];
                            if (o.tabid == tabid)
                            {
                                tabItems.splice(i, 1);
                                //saveTabStatus();
                                break;
                            }
                        }
                    },
                    onReload: function (tabdata)
                    {
                        var tabid = tabdata.tabid;
                        addFrameSkinLink(tabid);
                    }
                });
                
                /**
                 * 修改密码
                 */
                $("#changePassword").click(function(){
                	if(tab.isTabItemExist(addChangePassword)){
                	    tab.selectTabItem(addChangePassword);
                	    tab.reload(addChangePassword);
                	}else{
                         f_addTab(addChangePassword, "修改密码", "${baseURL}/user/changePassword.do");
                	}
                });

                //面板
                $("#accordion1").ligerAccordion({
                    height: height - 24, speed: null
                });

                $(".l-link").hover(function ()
                {
                    $(this).addClass("l-link-over");
                }, function ()
                {
                    $(this).removeClass("l-link-over");
                });
                
                //树
                $("#tree1").ligerTree({
                    url: "${baseURL}/user/getUserMenuJson.do",
                    checkbox: false,
                    slide: false,
                    nodeWidth: 120,
                    attribute: ['nodename', 'url'],
                    onSelect: function (node)
                    {
                        if (!node.data.url) return; 
                        var tabid = $(node.target).attr("tabid");
                        if (!tabid)
                        {
                            tabid = new Date().getTime();
                            $(node.target).attr("tabid", tabid);
                            f_addTab(tabid, node.data.text, node.data.url);
                        }else{
                        	if(tab.isTabItemExist(tabid)){
                        	    tab.selectTabItem(tabid);
                        	    tab.reload(tabid);
                        	}else{
                        		 tabid = new Date().getTime();
                                 $(node.target).attr("tabid", tabid);
                                 f_addTab(tabid, node.data.text, node.data.url);
                        	}
                        }
                    }
                });

                tab = liger.get("framecenter");
                accordion = liger.get("accordion1");
                tree = liger.get("tree1");
                $("#pageloading").hide();

                css_init();
                //pages_init();
            });
            
            
            function f_heightChanged(options)
            {  
                if (tab)
                    tab.addHeight(options.diff);
                if (accordion && options.middleHeight - 24 > 0)
                    accordion.setHeight(options.middleHeight - 24);
            }
            
            
            function f_addTab(tabid, text, url)
            {
                tab.addTabItem({
                    tabid: tabid,
                    text: text,
                    url: url,
                    callback: function ()
                    {
                        //addShowCodeBtn(tabid); 
                        addFrameSkinLink(tabid); 
                    }
                });
            }
            
            function addShowCodeBtn(tabid)
            {
                var viewSourceBtn = $('<a class="viewsourcelink" href="javascript:void(0)">查看源码</a>');
                var jiframe = $("#" + tabid);
                viewSourceBtn.insertBefore(jiframe);
                viewSourceBtn.click(function ()
                {
                    showCodeView(jiframe.attr("src"));
                }).hover(function ()
                {
                    viewSourceBtn.addClass("viewsourcelink-over");
                }, function ()
                {
                    viewSourceBtn.removeClass("viewsourcelink-over");
                });
            }
            
            function showCodeView(src)
            {
                $.ligerDialog.open({
                    title : '源码预览',
                    url: 'dotnetdemos/codeView.aspx?src=' + src,
                    width: $(window).width() *0.9,
                    height: $(window).height() * 0.9
                });

            }
            function addFrameSkinLink(tabid)
            {
                var prevHref = getLinkPrevHref(tabid) || "";
                var skin = getQueryString("skin");
                if (!skin) return;
                skin = skin.toLowerCase();
                attachLinkToFrame(tabid, prevHref + skin_links[skin]);
            }
            var skin_links = {
                "aqua": "lib/ligerUI/skins/Aqua/css/ligerui-all.css",
                "gray": "lib/ligerUI/skins/Gray/css/all.css",
                "silvery": "lib/ligerUI/skins/Silvery/css/style.css",
                "gray2014": "lib/ligerUI/skins/gray2014/css/all.css"
            };
            function pages_init()
            {
                var tabJson = $.cookie('liger-home-tab'); 
                if (tabJson)
                { 
                    var tabitems = JSON2.parse(tabJson);
                    for (var i = 0; tabitems && tabitems[i];i++)
                    { 
                        f_addTab(tabitems[i].tabid, tabitems[i].text, tabitems[i].url);
                    } 
                }
            }
            /*
            function saveTabStatus()
            { 
                $.cookie('liger-home-tab', JSON2.stringify(tabItems));
            }
            */
            function css_init()
            {
                var css = $("#mylink").get(0), skin = getQueryString("skin");
                $("#skinSelect").val(skin);
                $("#skinSelect").change(function ()
                { 
                    if (this.value)
                    {
                        location.href = "${baseURL}/ligerUI/index.htm?skin=" + this.value;
                    } else
                    {
                        location.href = "${baseURL}/ligerUI/index.htm";
                    }
                });

               
                if (!css || !skin) return;
                skin = skin.toLowerCase();
                $('body').addClass("body-" + skin); 
                $(css).attr("href", skin_links[skin]); 
            }
            function getQueryString(name)
            {
                var now_url = document.location.search.slice(1), q_array = now_url.split('&');
                for (var i = 0; i < q_array.length; i++)
                {
                    var v_array = q_array[i].split('=');
                    if (v_array[0] == name)
                    {
                        return v_array[1];
                    }
                }
                return false;
            }
            function attachLinkToFrame(iframeId, filename)
            { 
                if(!window.frames[iframeId]) return;
                var head = window.frames[iframeId].document.getElementsByTagName('head').item(0);
                var fileref = window.frames[iframeId].document.createElement("link");
                
                if (!fileref) return;
                fileref.setAttribute("rel", "stylesheet");
                fileref.setAttribute("type", "text/css");
                fileref.setAttribute("href", filename);
                head.appendChild(fileref);
            }
            
            function getLinkPrevHref(iframeId)
            {
                if (!window.frames[iframeId]) return;
                var head = window.frames[iframeId].document.getElementsByTagName('head').item(0);
                var links = $("link:first", head);
                for (var i = 0; links[i]; i++)
                {
                    var href = $(links[i]).attr("href");
                    if (href && href.toLowerCase().indexOf("ligerui") > 0)
                    {
                        return href.substring(0, href.toLowerCase().indexOf("lib") );
                    }
                }
            }
     </script>
<style type="text/css">
body,html {
	height: 100%;
}

body {
	padding: 0px;
	margin: 0;
	overflow: hidden;
}

.l-link {
	display: block;
	height: 26px;
	line-height: 26px;
	padding-left: 10px;
	text-decoration: underline;
	color: #333;
}

.l-link2 {
	text-decoration: underline;
	color: white;
	margin-left: 2px;
	margin-right: 2px;
}

.l-layout-top {
	background: #102A49;
	color: White;
}

.l-layout-bottom {
	background: #E5EDEF;
	text-align: center;
}

#pageloading {
	position: absolute;
	left: 0px;
	top: 0px;
	background: white url('${baseURL}/ligerUI/loading.gif') no-repeat center;
	width: 100%;
	height: 100%;
	z-index: 99999;
}

.l-link {
	display: block;
	line-height: 22px;
	height: 22px;
	padding-left: 16px;
	border: 1px solid white;
	margin: 4px;
}

.l-link-over {
	background: #FFEEAC;
	border: 1px solid #DB9F00;
}

.l-winbar {
	background: #2B5A76;
	height: 30px;
	position: absolute;
	left: 0px;
	bottom: 0px;
	width: 100%;
	z-index: 99999;
}

.space {
	color: #E7E7E7;
}
/* 顶部 */
.l-topmenu {
	margin: 0;
	padding: 0;
	height: 31px;
	line-height: 31px;
	background: url('${baseURL}/ligerUI/lib/images/top.jpg') repeat-x bottom;
	position: relative;
	border-top: 1px solid #1D438B;
}

.l-topmenu-logo {
	color: #E7E7E7;
	padding-left: 35px;
	line-height: 26px;
	background: url('${baseURL}/ligerUI/lib/images/topicon.gif') no-repeat
		10px 5px;
}

.l-topmenu-welcome {
	position: absolute;
	height: 24px;
	line-height: 24px;
	right: 30px;
	top: 2px;
	color: #070A0C;
}

.l-topmenu-welcome a {
	color: #E7E7E7;
	text-decoration: underline
}

.body-gray2014 #framecenter {
	margin-top: 3px;
}

.viewsourcelink {
	background: #B3D9F7;
	display: block;
	position: absolute;
	right: 10px;
	top: 3px;
	padding: 6px 4px;
	color: #333;
	text-decoration: underline;
}

.viewsourcelink-over {
	background: #81C0F2;
}

.l-topmenu-welcome label {
	color: white;
}

#skinSelect {
	margin-right: 6px;
}
</style>
</head>
<body style="padding: 0px; background: #EAEEF5;">
	<div id="pageloading"></div>
	<div id="topmenu" class="l-topmenu">
		<div class="l-topmenu-logo">后台管理界面</div>
		<div class="l-topmenu-welcome">
			<span style="color:white">欢迎:${user.name }</span>
			<span class="space">|</span>
			<a href="${baseURL }/user/logout.do" class="l-link2">退出</a> 
			<span class="space">|</span>
			<a style="cursor:pointer" class="l-link2" id="changePassword">修改密码</a>
		</div>
	</div>

	<div id="layout1"
		style="width: 99.2%; margin: 0 auto; margin-top: 4px;">
		<div position="left" title="主要菜单" id="accordion1">
			<div title="功能列表" class="l-scroll">
				<ul id="tree1" style="margin-top: 3px;">
			</div>
		</div>

		<div position="center" id="framecenter">
			<div tabid="home" title="用户登录信息" style="height: 300px">
				<iframe frameborder="0" name="home" id="home"
					src="${baseURL }/info.jsp"></iframe>
			</div>
		</div>
	</div>

	<div style="height: 32px; line-height: 32px; text-align: center;">
		Copyright © 2011-2014 宏宏</div>
	<div style="display: none"></div>
</body>
</html>
