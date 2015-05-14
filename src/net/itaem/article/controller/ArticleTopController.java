package net.itaem.article.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.itaem.article.entity.ArticleAndType;
import net.itaem.article.service.IArticleService;
import net.itaem.base.controller.BaseController;
import net.itaem.util.JsonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 将某个文章变成置顶文章
 * */
@Controller
public class ArticleTopController extends BaseController {

	@Autowired
	private IArticleService articleService;
	
	@RequestMapping("/article/top.do")
	public void top(String id, String articleTypeId, HttpServletResponse resp) throws IOException{	
		ArticleAndType aat = new ArticleAndType(null, id, articleTypeId);
		articleService.setTop(aat);
		println(resp, JsonUtil.createJson("success", "置顶成功"));
	}
}
