package net.itaem.slide.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.base.controller.BaseController;
import net.itaem.slide.entity.Slide;
import net.itaem.slide.service.ISlideService;
import net.itaem.util.DateUtil;
import net.itaem.util.JsonUtil;
import net.itaem.util.UUIDUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 添加首页slide
 * */
@Controller
public class SlideAddController extends BaseController {

	@Autowired
	ISlideService slideService;
	
	@RequestMapping("/slide/add.do")
	public String add(){
		return "slide/add";
	}
	
	@RequestMapping("/slide/addSubmit.do")
	public void addSubmit(Slide slide, HttpServletRequest req, HttpServletResponse resp) throws IOException{
	    slide.setId(UUIDUtil.uuid());
	    slide.setCreator(super.getLoginUserName(req, "luohong"));
	    slide.setCreatedTime(DateUtil.getNowDate(null));
	    
		slideService.add(slide);
	    println(resp, JsonUtil.createJson("success", "添加成功"));
	}
}
