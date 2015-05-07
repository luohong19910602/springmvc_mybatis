package net.itaem.base.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.privilege.entity.Privilege;
import net.itaem.privilege.service.IPrivilegeService;
import net.itaem.user.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 检测用户的请求是否具备相关权限
 * 这个权限可以由权限管理人员进行配置
 * 检测步骤：
 * 1检测用户是否已经登录，如果没有，跳转到登录界面
 * 2检车用户是否为超级管理员，如果是，那么用户具备访问全部资源的权限
 * 3查询用户的可访问资源列表，然后校对资源，如果允许访问，那么通过请求，如果不允许，直接终止请求
 * @author luohong
 * @email 846705189@qq.com
 * @date 2014-12-25
 * */
public class CheckRequestPermission implements HandlerInterceptor {
	
	@Autowired
	private IPrivilegeService privilegeService;
	
	@Override
	public void afterCompletion(HttpServletRequest req,
			HttpServletResponse resp, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object arg2) throws Exception {
		
		//登录
		if(!isLogin(req)){
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return false;
		}
		
		//超级用户
		if(isSuperUser(req)){
			return true;
		}
		
		//判断用户是否具备访问权限
		if(canAccess(req)){
			return true;
		}else{
			req.getRequestDispatcher("/noPrivilegeToAccess.jsp").forward(req, resp);
			return false;
		}
	}

	/**
	 * 判断用户的请求是否合法
	 * 这里会获取出用户可以访问的全部权限，然后逐一比较每一个权限，
	 * 由于权限使用了类别来归类，所以这里会遍历每个权限的子权限，
	 * 但是不需要使用递归，因为权限的嵌套关系最多为两层
	 * */
	private boolean canAccess(HttpServletRequest req) {
		User u = (User) req.getSession().getAttribute("user");
		if(u == null) return false;
		
		List<Privilege> privilegeList =privilegeService.listByUserId(u.getId());
		String reqUri = req.getRequestURL().toString();
		
		for(Privilege privilege: privilegeList){
			if(privilege.getChildren() != null && privilege.getChildren().size() > 0){
				for(Privilege child: privilege.getChildren()){
					if(child.getUrl().equalsIgnoreCase(reqUri)){
						return true;
					}
				}
			}
			
			if(privilege.getUrl() == null || "".equals(privilege.getUrl())) continue;
			
			if(privilege.getUrl().equalsIgnoreCase(reqUri)){
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断请求的用户是否是超级用户
	 * */
	private boolean isSuperUser(HttpServletRequest req) {
		User u = (User) req.getSession().getAttribute("user");
		return u != null && u.getSuperUserFlag() == User.SUPER_USER;
	}

	/**
	 * 判断用户是否已经登录
	 * */
	private boolean isLogin(HttpServletRequest req) {
		User u = (User) req.getSession().getAttribute("user");
		return u != null;
	}
}
