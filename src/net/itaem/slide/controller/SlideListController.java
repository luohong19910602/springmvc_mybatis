package net.itaem.slide.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.itaem.base.controller.BaseController;
import net.itaem.slide.entity.Slide;
import net.itaem.slide.service.ISlideService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SlideListController extends BaseController {

	@Autowired
	private ISlideService slideService;
	
	@RequestMapping("/slide/list.do")
	public String list(){
		return "slide/list";
	}
	
	@RequestMapping("/slide/listJson.do")
	public void listJson(HttpServletResponse resp) throws IOException{
		List<Slide> slideList = slideService.listAll();
		println(resp, gridJson.slideListToGrid(slideList));
	}
}
