package net.itaem.article.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.article.entity.Article;
import net.itaem.article.service.IArticleService;
import net.itaem.base.controller.BaseController;
import net.itaem.util.JsonUtil;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 列出文章的详细信息
 * */
@Controller
public class ArticleDetailController extends BaseController{
    @Autowired
	IArticleService articleService;
    
    @RequestMapping("/article/detail.do")
    public String list(String id, HttpServletRequest req, HttpServletResponse resp){
    	Article article = articleService.findById(id);
    	if(article != null){
    		req.setAttribute("title", article.getTitle());
    		req.setAttribute("content", article.getContent());
    	}
    	return "article/article";
    }
    
    @RequestMapping("/article/listDetailByAndroid.do")
    public void listDetailByAndroid(String id, HttpServletRequest req, HttpServletResponse resp) throws IOException{
    	Article article = articleService.findById(id);
    	if(article != null){
    		req.setAttribute("title", article.getTitle());
    		req.setAttribute("content", article.getContent());
    		JSONObject json = new JSONObject();
    		json.put("title", article.getTitle());
    		json.put("content", article.getContent());
    		json.put("status", "success");
    		
    		println(resp, json.toString());
    	}else{
    		println(resp, JsonUtil.createJson("error", "文章不存在"));
    	}
    }
    
    
}
