package net.itaem.article.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.article.entity.Article;
import net.itaem.article.entity.ArticleType;
import net.itaem.article.service.IArticleService;
import net.itaem.article.service.IArticleTypeService;
import net.itaem.base.controller.BaseController;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleUpdateController extends BaseController {
	
	@Autowired
	IArticleService articleService;
	@Autowired
	IArticleTypeService articleTypeService;
	
	
	/**
	 * 跳转到更新界面
	 * @throws IOException 
	 * @throws ServletException 
	 * */
	@RequestMapping("/article/edit.do")
	public String edit(String id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Article article = articleService.findById(id);
		req.setAttribute("article", article);
		List<ArticleType> articleTypeList = articleTypeService.listAll();
		StringBuilder sb = new StringBuilder();
		int i=0;
		sb.append("<tr>");
		for(ArticleType type: articleTypeList){
			String str = "<td><input id='hk_tag_' name='typeId' type='radio' value='"+type.getId()+"'>"
					+ "<label for='chk_tag_'>"+type.getName()+"</label></td>";
			sb.append(str);
			i++;
			if(i % 6 == 0 && i != articleTypeList.size()){
				sb.append("</tr>");
				sb.append("<tr>");
			}
		}
		sb.append("</tr>");
		req.setAttribute("typeList", sb.toString());
		return "article/edit";
	}
	
	/**
	 * 更新
	 * @throws IOException 
	 * */
	@RequestMapping("/article/editSubmit.do")
	public void editSubmit(Article article, HttpServletResponse resp) throws IOException{
		articleService.update(article);
		super.alert("修改成功", resp);
	}
	
	/**
	 * 更新文章
	 * */
	@RequestMapping("/article/update.do")
	public void update(Article article, HttpServletResponse resp) throws IOException{
		articleService.update(article);
		JSONObject json = new JSONObject();
		json.put("title", article.getTitle());
		json.put("content", article.getClass());
		json.put("status", "success");
		println(resp, json.toString());
	}
}
