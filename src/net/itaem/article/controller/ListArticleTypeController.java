package net.itaem.article.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.itaem.article.entity.ArticleType;
import net.itaem.article.service.IArticleTypeService;
import net.itaem.base.controller.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 列出全部的文章类别Controller
 * @author luohong 846705189@qq.com 2015-02-01
 * */
@Controller
public class ListArticleTypeController extends BaseController {
	@Autowired
    IArticleTypeService articleTypeService;
	
	/**
	 * 跳转到文章列表界面
	 * */
	@RequestMapping("/article/list.do")
	public String list(){
		return "article/articleTypeList";
	}
	
	@RequestMapping("/listJson.do")
	public void listJson(HttpServletResponse resp) throws IOException{
		List<ArticleType> articleTypeList = articleTypeService.listAll();
		println(resp, gridJson.articleTypeListToGrid(articleTypeList));
	}
}
