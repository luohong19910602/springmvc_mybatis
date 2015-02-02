package net.itaem.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.itaem.article.service.IArticleTypeService;

/**
 * 添加文章类别以及文章controller
 * 
 * */
@Controller
public class AddArticleController {
	@Autowired
    IArticleTypeService articleTypeService;
	
	@RequestMapping("/addType.do")
	public String addType(){
		return "article/addType";
	}
}
