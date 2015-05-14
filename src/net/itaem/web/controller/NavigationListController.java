package net.itaem.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.itaem.base.controller.BaseController;
import net.itaem.web.entity.Navigation;
import net.itaem.web.service.INavigationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 获取全部的Navigation
 * 
 * */
@Controller
public class NavigationListController extends BaseController {
    
	@Autowired
    private INavigationService navService;
    
    /**
     * 跳转到导航列表界面
     * */
    @RequestMapping("/navigation/list.do")
    public String list(){
    	return "navigation/list";
    }
    
    @RequestMapping("/navigation/listJson.do")
    public void listJson(HttpServletResponse resp) throws IOException{
    	List<Navigation> navList = navService.listAll();
    	println(resp, gridJson.navigationListToGrid(navList));
    }
}
