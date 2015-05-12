package net.itaem.article.controller.user;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.itaem.base.controller.BaseController;
import net.itaem.resource.service.IResourceService;
import net.itaem.user.entity.User;
import net.itaem.user.entity.UserMenu;
import net.itaem.user.service.IUserService;
import net.itaem.util.DateUtil;
import net.itaem.util.JsonUtil;
import net.itaem.util.MD5Util;
import net.itaem.util.ResponseUtil;
import net.itaem.util.UUIDUtil;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户注册
 * 这个接口是移动端使用的
 * 
 * 默认给用户两个菜单，菜单为日志管理，日志类别管理
 * */
@Controller
public class UserRegisterController extends BaseController {

	@Autowired
	IUserService userService;
	

	@Autowired
	private IResourceService resourceService;

	@RequestMapping("/user/registerByAndroid.do")
	public void register(User user, HttpServletResponse resp) throws IOException{
		//valid the input user info
		if(user.getLoginName() == null 
				|| user.getPassword() == null
				|| user.getLoginName().equals("") || user.getPassword().equals("")){
			println(resp, JsonUtil.createJson("error", "添加用户失败，角色登录名、密码不能为空"));
			return;
		}

		/** 
		 * 不允许重复注册用户
		 * */
		if(userService.hasRegisted(user.getLoginName())){
			println(resp, JsonUtil.createJson("error", "该用户名已经被注册"));
			return;
		}
        
		user.setCreatedTime(DateUtil.getNowDate(null));
		user.setId(UUIDUtil.uuid());
		//加密密码
		user.setPassword(MD5Util.strToMD5(user.getPassword()));
		userService.add(user);
		
		String resourceList = "682e1227_fb67_4009_bc2c_aa404dcd72a3;6a0fee19_edaf_4ec4_a2e8_bbc574544f07";
		
		//给每个用户设置菜单，菜单为日志管理，日志类别管理
		if(resourceList != null){
			String[] resourceIds = resourceList.split(";");
			UserMenu[] userMenus = createUserMenus(resourceIds, user.getId());

			for(UserMenu userMenu: userMenus){
				userService.addUserMenu(userMenu);
			}
		}
		
		JSONObject json = new JSONObject();
		json.put("status", "success");
		json.put("userId", user.getId());
		
		ResponseUtil.println(resp, json.toString());
	}
	
	/**
	 * 创建role menu对象
	 * */
	private UserMenu[] createUserMenus(String[] resourceIds, String userId) {
		if(resourceIds == null) return null;

		UserMenu[] userMenus = new UserMenu[resourceIds.length];
		int index = 0;

		//这部分内容需要放在service层
		for(String resourceId: resourceIds){
			UserMenu userMenu = new UserMenu();
			userMenu.setId(UUIDUtil.uuid());
			userMenu.setUserId(userId);
			userMenu.setResourceId(resourceId);

			//这里取出这个resource所属的menu
			net.itaem.resource.entity.Resource res = resourceService.findBy(resourceId);                

			if(res != null)
				userMenu.setMenuId(res.getMenuId());

			userMenus[index++] = userMenu;
		}
		return userMenus;

	}


}
