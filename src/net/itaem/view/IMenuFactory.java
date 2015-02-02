package net.itaem.view;

import javax.servlet.http.HttpServletRequest;

/**
 * 工厂类，用来构建后台管理界面的菜单栏json数据
 * 这个方法主要在测试时使用，生成固定的menu
 * 
 * @author luohong
 * @date 2014-12-18
 * @email 846705189@qq.com
 * */
public interface IMenuFactory {
	
	/**
	 * 返回后台菜单的JSON数据
	 * 这个方法使用代码直接生成左边菜单栏的tree json数据
	 * @param req 请求生成菜单的请求
	 * @return
	 * */
    public String createMenu(HttpServletRequest req);
}
