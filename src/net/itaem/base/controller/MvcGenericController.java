package net.itaem.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.DispatcherServlet;

/**
 * 集成spring mvc，然后覆盖其中几个方法
 * 该类的主要目标就是让spring mvc自动跳转到一些界面，
 * 比如
 * /user/list.do跳转到/WEB-INF/jsp/user/list.jsp
 * /menu/list.do跳转到/WEB-INF/jsp/menu/list.jsp
 * /user/add.do跳转到/WEB-INFO/jsp/user/add.jsp
 * /user/update.do跳转到/WEB-INFO/jsp/user/edit.jsp
 * 
 *  这个类的主要作用就是简化其他controller的开发
 * */
public class MvcGenericController extends DispatcherServlet {

	@Override
	protected String getDefaultViewName(HttpServletRequest request)
			throws Exception {
		// TODO Auto-generated method stub
		return super.getDefaultViewName(request);
	}
    
}
