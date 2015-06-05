package net.itaem.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 网站入口
 * */
@Controller
public class IndexController {

	@RequestMapping("/index.do")
	public String index(HttpServletRequest req){
		
		return "index";
	}
}
