package net.itaem.user.controller;

import net.itaem.user.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 忘记密码
 * 
 * */
@Controller
public class UserForgotPassword {

	@Autowired
	private IUserService userService;
	
}
