package net.itaem.article.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.itaem.article.service.IArticleTypeService;
import net.itaem.base.controller.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleTypeDeleteController extends BaseController {

	@Autowired
	IArticleTypeService articleTypeService;
	
	@RequestMapping("/articleType/delete.do")
	public void delete(HttpServletResponse resp, String ids) throws IOException{
		System.out.println(ids);
		articleTypeService.delete(ids.split(","));
		println(resp, "delete successful");
	}
	
}