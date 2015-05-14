package net.itaem.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.itaem.web.entity.Navigation;
import net.itaem.web.service.INavigationService;

import org.springframework.beans.factory.annotation.Autowired;
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
