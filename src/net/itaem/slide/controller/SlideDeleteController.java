package net.itaem.slide.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.itaem.base.controller.BaseController;
import net.itaem.slide.service.ISlideService;
import net.itaem.util.JsonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SlideDeleteController extends BaseController {

	@Autowired
	private ISlideService slideService;

	@RequestMapping("/slide/delete.do")
	public void delete(String ids, HttpServletResponse resp) throws IOException{
		if(ids != null)
			slideService.delete(ids.split(","));
		
		println(resp, JsonUtil.createJson("success", "删除成功"));
	}
}
