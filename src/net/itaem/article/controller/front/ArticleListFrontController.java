package net.itaem.article.controller.front;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 前台文章首页
 * 这里会列出所有的文章类别以及文章详细信息
 * 
 * @author luohong 846705189@qq.com 15013336884
 * @Date 2015-05-12
 * */
@Controller
public class ArticleListFrontController extends BaseController {

	@Autowired
	IArticleTypeService artilceTypeService;
	
	@Autowired
	IArticleService artilceService;

	/**
	 * 输出文章列表数据
	 * @throws IOException 
	 * @throws ServletException 
	 * */
	@RequestMapping("/article/front/index.do")
	public void index(Integer index, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//文章类别数据
		StringBuilder sb = new StringBuilder();
		List<ArticleType> articleTypeList = artilceTypeService.listAll();
		if(articleTypeList != null && articleTypeList.size() > 0){
			for(int i=0; i<articleTypeList.size(); i++){
				if(index == null){
					index = 0;
				}

				if(index == i)
					sb.append("<li class='active'><a href='" + super.getBaseURL(req) + "/article/front/index.do?index=" + i + "'>" + articleTypeList.get(i).getName() + "</a></li>");
				else
					sb.append("<li><a href='" + super.getBaseURL(req) + "/article/front/index.do?index=" + i + "'>" + articleTypeList.get(i).getName() + "</a></li>");
			}

			//选中当前的type，然后获取全部的文章列表
			List<Article> articleList = artilceService.listBy(articleTypeList.get(index).getId());
			if(articleList != null && articleList.size() > 0){
				StringBuilder articleBuilder = new StringBuilder();
				articleBuilder.append("<div class='row-fluid'>");
				int flag = 0;
				for(Article article: articleList){
					articleBuilder.append("<div class='span4 bs-docs-example'>");
					articleBuilder.append("<h2>" + article.getTitle() + "</h2>");
					String summary = article.getSummary();

					articleBuilder.append("<p>" + summary + "</p>");
					articleBuilder.append("<p><a class='btn' target='_blank' href='" + super.getBaseURL(req) + "/article/detail.do?id=" + article.getId() +  "'>查看详情</a></p>");
					articleBuilder.append("</div>");
					
					flag++;
					if(flag % 3 == 0 && flag - 1 != articleList.size()){	
						 articleBuilder.append("</div>");
						 articleBuilder.append("<div class='row-fluid'>");
					}
					
				}
				
				articleBuilder.append("</div>");
				
				req.setAttribute("article", articleBuilder.toString());
			}
			req.setAttribute("type", sb.toString());
			req.getRequestDispatcher("/front/article/index.jsp").forward(req, resp);
		}   
	}
}
