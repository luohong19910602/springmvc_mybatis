<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerPanel.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerPortal.js"
	type="text/javascript"></script>
<script src="${baseURL}/ligerUI/lib/ligerUI/js/plugins/ligerDrag.js"></script>
<script type="text/javascript">
        var roleId = "${roleId}";  //角色ID

        var manager;
        $(function ()
        {
            manager = $("#portalMain").ligerPortal({
                draggable: false,
                rows: [ 
                    {
                        columns: [{
                            width : "100%",
                            panels: [{
                                title: '角色的权限',
                                width: '100%',
                                height: 400,
                                url: '${baseURL}/role/getRolePrivilege.do?roleId=${roleId}'
                            }
                            ]
                        }]
                    },
                    {
                        columns: [{
                            width : "100%",
                            panels: [{
                                title: '角色的菜单',
                                width: '100%',
                                height: 400,
                                url: '${baseURL}/role/getRoleMenu.do?roleId=' + roleId
                            }
                            ]
                        }]
                    },
                    {
                        columns: [{
                            width : "100%",
                            panels: [{
                                title: '角色的用户',
                                width: '100%',
                                height: 400,
                                url: '${baseURL}/role/getRoleUser.do?roleId=${roleId}'
                            }
                            ]
                        }]
                    }
                ]
            }); 
            manager.collapseAll();
            //默认情况下关闭一些pannel，只显示基本信息的pannel
            /*
            var panels = manager.getPanels();
            $(panels).each(function (i,o)
            {
                var panel = o.panel; 
                if(i != 0)
                    panel.collapse();
            });
            */
        }); 
    </script>

</head>
<body style="padding: 10px">
	<div style="width: 100%;" id="portalMain"></div>
</body>
</html>
