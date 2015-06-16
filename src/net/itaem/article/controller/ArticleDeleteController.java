package net.itaem.article.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.itaem.article.service.IArticleService;
import net.itaem.base.controller.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 删除文章
 * @author luohong 846705189@qq.com 15013336884
 * */
@Controller
public class ArticleDeleteController extends BaseController{

	@Autowired
	private IArticleService articleService;
	
	@RequestMapping("/article/delete.do")
	public void delete(HttpServletResponse resp, String ids) throws IOException{
		if(ids == null || ids.equals("")){
			println(resp, "delete fail");
		}
		articleService.delete(ids.split(","));
		println(resp, "delete success");
	}
	
}
