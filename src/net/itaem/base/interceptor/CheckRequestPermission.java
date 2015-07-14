package net.itaem.base.interceptor;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.common.RequestUtil;
import net.itaem.privilege.entity.Privilege;
import net.itaem.privilege.service.IPrivilegeService;
import net.itaem.user.entity.User;
import net.itaem.user.service.IUserService;

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

	@Autowired
	private IUserService userService;

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
		if(req.getSession().getServletContext().getAttribute("baseURL") == null){
			req.getSession().getServletContext().setAttribute("baseURL", RequestUtil.contxtPath(req));
		}

		return check(req, resp);
	}

	private boolean check(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//登录
		if(!isLogin(req)){
			//cookie验证
			Cookie[] cookies = req.getCookies();
			String[] cooks = null;  
			String loginName = null;
			String password = null;

			if (cookies != null) {
				System.out.println(cookies);
				for (Cookie coo : cookies) {
					if(coo.getName().equals("user")){
						String aa = coo.getValue();
						cooks = aa.split("==", -1); 
						if (cooks.length == 2) {  
							loginName = cooks[0];  
							password = cooks[1];

							User user = new User();
							user.setLoginName(loginName);
							user.setPassword(password);
							user = userService.exists(user);
							if(user != null && user.getId() != null && !"".equals(user.getId())){
								req.getSession().setAttribute("user", user);
								System.out.println("has been login");
								req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
								return true;
							}
						}  	
					}
				}  
			}

			resp.sendRedirect(RequestUtil.contxtPath(req));
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
	 * 
	 * 这里面会缓存登陆用户的所有权限信息，只要该用户登陆过一次，那么系统就将权限信息设置到session中
	 * */
	@SuppressWarnings("unchecked")
	private boolean canAccess(HttpServletRequest req) {
		User u = (User) req.getSession().getAttribute("user");
		if(u == null) return false;


		List<Privilege> privilegeList = null;
		privilegeList = (List<Privilege>) req.getSession().getAttribute("privilegeList");

		if(privilegeList == null){
			//设置权限信息到session中...
			privilegeList = privilegeService.listByUserId(u.getId());
			req.getSession().setAttribute("privilegeList", privilegeList);
		}

		String reqUri = req.getRequestURL().toString();

		/**
		 * 由于获取到的用户权限是由类别来组织的，所以这里面需要使用两层循环
		 * */
		for(Privilege privilege: privilegeList){
			if(privilege.getChildren() != null && privilege.getChildren().size() > 0){
				for(Privilege child: privilege.getChildren()){
					if(reqUri.lastIndexOf(child.getUrl()) != -1){
						return true;
					}
				}
			}

			//该权限是权限类别，所以直接continue
			if(privilege.getUrl() == null || "".equals(privilege.getUrl())) continue;

			if(privilege.getUrl().lastIndexOf(reqUri) != -1){
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
