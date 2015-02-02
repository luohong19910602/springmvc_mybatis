package net.itaem.view.ligerui;

import javax.servlet.http.HttpServletRequest;

import net.itaem.view.IMenuFactory;
import net.itaem.view.ITree;
import net.sf.json.JSONArray;

/**
 * 工厂类，生成liger ui menu 菜单的json字符串
 * 这个类主要用来测试...在具体工程中，不适用
 * @author luohong
 * @email 846705189@qq.com
 * @date 2015-01-15
 * 
 * */
public class LigerUiMenuFactory implements IMenuFactory {
    
	private static LigerUiMenuFactory factory = new LigerUiMenuFactory();
    
    private LigerUiMenuFactory(){
    	
    }
    
    public static LigerUiMenuFactory getInstance(){
    	return factory;
    }
    
	@Override
	public String createMenu(HttpServletRequest req) {
		ITree menuManager = new LigerUiTree();  
		menuManager.setId("1");
		menuManager.setName("菜单管理");
        
		ITree menuList = new LigerUiTree();
        menuList.setId("2");
        
        menuList.setUrl(createRequestURL(req, "/menu/list.do"));
        
        menuList.setName("菜单列表");
        menuManager.addSubTree(menuList);
        JSONArray tree = new JSONArray();
		
        System.out.println(menuManager.toTreeJson());
        
        tree.add(menuManager.toTreeJson());
		return tree.toString();
	}
	  
	/**
	 * 生成用户请求的url
	 * */
	private String createRequestURL(HttpServletRequest req, String uri){
		String scheme = req.getScheme();
		String serverName = req.getServerName();
		String contextPath = req.getContextPath();
		int port = req.getServerPort();
		String baseURL = scheme + "://" + serverName + ":"+ port + contextPath;
		return baseURL + uri;
	}
}
