package net.itaem.article.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.article.entity.ArticleType;
import net.itaem.article.service.IArticleTypeService;
import net.itaem.base.controller.BaseController;
import net.itaem.user.entity.User;
import net.itaem.util.DateUtil;
import net.itaem.util.JsonUtil;
import net.itaem.util.UUIDUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 添加文章类别Controller
 * 
 * */
@Controller
public class AddArticleTypeController extends BaseController {

	@Autowired
	private IArticleTypeService articleTypeService;
	
	@RequestMapping("/articleType/add.do")
	public String addArticleType(){
		return "article/addArticleType";
	}
	
	@RequestMapping("/articleType/addSubmit.do")
	public void addSubmit(HttpServletRequest req, HttpServletResponse resp, ArticleType articleType) throws IOException{
		
		articleType.setId(UUIDUtil.uuid());
		articleType.setCreatedTime(DateUtil.getNowDate(null));
		User u = (User) req.getSession().getAttribute("user");
		if(u != null){
		    articleType.setCreator(u.getName());
		}
		articleTypeService.add(articleType);
		
		println(resp, JsonUtil.createJson("success", "add article type successful"));
	}
}
