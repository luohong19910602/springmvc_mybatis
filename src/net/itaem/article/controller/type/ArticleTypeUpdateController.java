package net.itaem.article.controller.type;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.article.entity.ArticleType;
import net.itaem.article.service.IArticleTypeService;
import net.itaem.base.controller.BaseController;
import net.itaem.user.entity.User;
import net.itaem.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleTypeUpdateController extends BaseController {

	@Autowired
	IArticleTypeService articleTypeService;
	
	@RequestMapping("/articleType/edit.do")
	public String edit(HttpServletRequest req, String id){
		req.setAttribute("id", id);
		return "article/type/editArticleType";
	}
	
	
	@RequestMapping("/articleType/editSubmit.do")
	public void editSubmit(HttpServletRequest req, HttpServletResponse resp, ArticleType articleType) throws IOException{
		articleType.setUpdatedTime(DateUtil.getNowDate(null));
		User u = (User) req.getSession().getAttribute("user");
		articleType.setUpdator(u.getName());
		
		articleTypeService.update(articleType);
		
		System.out.println(articleType);
		println(resp, "update article type success");
	}
	
	
}
