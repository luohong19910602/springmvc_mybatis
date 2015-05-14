package net.itaem.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.itaem.base.controller.BaseController;
import net.itaem.util.JsonUtil;
import net.itaem.web.service.INavigationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 删除navigation
 * */
@Controller
public class NavigationDeleteController extends BaseController {

	@Autowired
	private INavigationService navService;
	
	@RequestMapping("/navigation/delete.do")
	public void delete(String ids, HttpServletResponse resp) throws IOException{
		navService.delete(ids.split(","));
		println(resp, JsonUtil.createJson("success", "删除成功"));
	}
}
