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
 * 在文章置顶中，如果某个文章类别下面只有一个文章，那么系统默认该文章为指定文章
 * 如果某个文章类别有多个文章，那么管理员可以选择其中一个文章作为置顶文章，
 * 置顶文章之间是互斥作用
 * @author luohong 15013336884 846705189@qq.com
 * 
 * */
@Controller
public class ArticleTopController extends BaseController {

	@Autowired
	private IArticleService articleService;
	
	/**
	 * 置顶
	 * */
	@RequestMapping("/article/top.do")
	public void top(String id, String articleTypeId, HttpServletResponse resp) throws IOException{	
		ArticleAndType aat = new ArticleAndType(null, id, articleTypeId);
		articleService.setTop(aat);
		println(resp, JsonUtil.createJson("success", "置顶成功"));
	}
	
	/**
	 * 取消置顶
	 * */
	@RequestMapping("/article/cancelTop.do")
	public void cancelTop(String id, String articleTypeId, HttpServletResponse resp) throws IOException{	
		ArticleAndType aat = new ArticleAndType(null, id, articleTypeId);
		articleService.cancelTop(aat);
		println(resp, JsonUtil.createJson("success", "取消置顶成功"));
	}
}
