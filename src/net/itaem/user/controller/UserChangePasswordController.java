package net.itaem.user.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.autogeneratecode.privilege.GeneratePrivilege;
import net.itaem.base.controller.BaseController;
import net.itaem.user.entity.User;
import net.itaem.user.service.IUserService;
import net.itaem.util.JsonUtil;
import net.itaem.util.MD5Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 修改密码Controller
 * @author 骆宏 15013336884@qq.com
 * */
@Controller
public class UserChangePasswordController extends BaseController {
    @Autowired
    IUserService userService;
    
    /**
     * 跳转到修改密码界面
     * 
     * */
    @GeneratePrivilege(name="跳转到修改密码界面",type="用户管理", uri="/user/changePassword.do", desc="无")
	
    @RequestMapping("/user/changePassword.do")
    public String changePassword(){
    	return "user/changePassword";
    }
    
    /**
     * 修改密码
     * */
    @GeneratePrivilege(name="修改密码",type="用户管理", uri="/user/changePasswordSubmit.do", desc="无")
	
    @RequestMapping("/user/changePasswordSubmit.do")
    public void changePasswordSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        String confirmPassword = req.getParameter("confirmPassword");
        
        User user = super.getLoginUser(req);
        if(user == null){
        	println(resp, JsonUtil.createJson("error", "请登录"));
        	return;
        }
        
        if(!MD5Util.strToMD5(oldPassword).equalsIgnoreCase(user.getPassword())){
        	println(resp, JsonUtil.createJson("error", "旧密码不正确"));
        	return;
        }
        
        if(!newPassword.equals(confirmPassword)){
        	println(resp, JsonUtil.createJson("error", "新密码与确认密码不一致"));
        	return;
        }
        user.setPassword(MD5Util.strToMD5(newPassword));
        userService.update(user);
        req.getSession().setAttribute("user", user);  //更新session的user
        println(resp, JsonUtil.createJson("status", "修改成功"));
    }
}
