package net.itaem.user.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    
    @RequestMapping("/user/changePassword.do")
    public String changePassword(){
    	return "user/changePassword";
    }
    
    @RequestMapping("/user/changePasswordSubmit.do")
    public void changePasswordSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("oldPassword");
        String confirmPassword = req.getParameter("oldPassword");
        
        User user = super.getLoginUser(req);
        if(user == null){
        	println(resp, JsonUtil.createJson("error", "请登录"));
        	return;
        }
        if(!MD5Util.strToMD5(oldPassword).equals(user.getPassword())){
        	println(resp, JsonUtil.createJson("error", "旧密码不正确"));
        	return;
        }
        
        if(!newPassword.equals(confirmPassword)){
        	println(resp, JsonUtil.createJson("error", "新密码与确认密码不一致"));
        	return;
        }
        
        user.setPassword(MD5Util.strToMD5(newPassword));
        userService.update(user);
        println(resp, JsonUtil.createJson("status", "修改成功"));
    }
}
