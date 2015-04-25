package net.itaem.article.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.itaem.article.entity.ArticleType;
import net.itaem.article.service.IArticleTypeService;
import net.itaem.base.controller.BaseController;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文章类别管理Controller
 * */
@Controller
public class ArticleTypeController extends BaseController {
    
	@Autowired
	private IArticleTypeService articleTypeService;
	/**
	 * 获取全部的文章类别列表
	 * */
	@RequestMapping("/articleType/list.do")
	public String list(){
		return "article/articleTypeList";
	}
	
	@RequestMapping("/articleType/listJson.do")
	public void listJson(HttpServletResponse resp) throws IOException{
		List<ArticleType> articleTypeList = articleTypeService.listAll();
		println(resp, gridJson.articleTypeListToGrid(articleTypeList));
	}
}
