package net.itaem.article.controller.front;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.article.entity.Article;
import net.itaem.article.entity.ArticleType;
import net.itaem.article.service.IArticleService;
import net.itaem.article.service.IArticleTypeService;
import net.itaem.base.controller.BaseController;
import net.itaem.web.entity.Navigation;
import net.itaem.web.service.INavigationService;

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

	@Autowired
	private INavigationService navService;


	/**
	 * 输出文章列表数据
	 * @index 选中的文章类别
	 * @navIndex 选中的导航
	 * 
	 * @throws IOException 
	 * @throws ServletException 
	 * */
	@RequestMapping("/article/front/index.do")
	public void index(Integer index, Integer navIndex, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		List<Navigation> navList = setNavigation(navIndex, req);

		if(index == null) index = 0;
		if(navIndex == null) navIndex = 0;

		String typeListStr = navList.get(navIndex).getArticleTypeListStr();

		setArticleType(index, navIndex, typeListStr, req);
		req.getRequestDispatcher("/front/article/index.jsp").forward(req, resp);   
	}

	@RequestMapping("/navigation.do")
	public void navigation(Integer navIndex, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		List<Navigation> navList = setNavigation(navIndex, req);
		if(navIndex == null)
			navIndex = 0;
		String typeListStr = navList.get(navIndex).getArticleTypeListStr();
		setArticleType(0, navIndex, typeListStr, req);
		req.getRequestDispatcher("/front/article/index.jsp").forward(req, resp);
	}

	/**
	 * 设置navigation
	 * @param navIndex 选中第几个导航
	 * */
	private List<Navigation> setNavigation(Integer navIndex, HttpServletRequest req) {
		//导航数据
		List<Navigation> navList = navService.listAll();
		if(navList != null && navList.size() > 0){
			StringBuilder navBuilder = new StringBuilder();
			for(int i=0;i<navList.size(); i++){
				if(navIndex == null){
					navIndex = 0;
				}

				if(navIndex == i){
					navBuilder.append("<li class='active'><a href='" + super.getBaseURL(req) + "/navigation.do?navIndex=" + i + "'>" + navList.get(i).getName() + "</a></li>");
				}else{
					navBuilder.append("<li><a href='" + super.getBaseURL(req) + "/navigation.do?navIndex=" + i + "'>" + navList.get(i).getName() + "</a></li>");
				}
			}
			req.setAttribute("nav", navBuilder.toString());
		}

		return navList;
	}

	/**
	 * 设置选中的文章类别
	 * @param index 选中的文章类别
	 * @paran navIndex 选中的导航
	 * */
	private void setArticleType(Integer index, Integer navIndex, String typeListStr, HttpServletRequest req){
		System.out.println("the index is " + index);
		if(typeListStr != null && !"".equals(typeListStr)){
			String[] types = typeListStr.split(Navigation.ARTICLE_TYPE_SEPORATOR);  //分割文章类别
			if(types != null && types.length > 0){
				StringBuilder sb = new StringBuilder();

				List<ArticleType> typeList = new ArrayList<ArticleType>();
				for(String type: types){
					ArticleType articleType = artilceTypeService.findById(type);
					if(articleType != null)
						typeList.add(articleType);
				}

				if(typeList != null && typeList.size() > 0){
					for(int i=0; i<typeList.size(); i++){
						if(index == i)
							sb.append("<li class='active'><a href='" + super.getBaseURL(req) + "/article/front/index.do?navIndex=" + navIndex + "&index=" +i + "'>" + typeList.get(i).getName() + "</a></li>");
						else
							sb.append("<li><a href='" + super.getBaseURL(req) + "/article/front/index.do?navIndex=" +navIndex + "&index=" + i + "'>" + typeList.get(i).getName() + "</a></li>");
					}
					req.setAttribute("type", sb.toString());

					setArtcile(types[index], req);
				}
			}
		}
	}

	/**
	 * @param top置顶的文章
	 * @param articleList 该类别下面的文章
	 * */
	private void setArtcile(String articleTypeId, HttpServletRequest req){
		List<Article> articleList = artilceService.listBy(articleTypeId);
		if(articleList != null && articleList.size() > 0){
			StringBuilder articleBuilder = new StringBuilder();
			articleBuilder.append("<div class='row-fluid'>");
			int flag = 0;

			//找到top置顶文章
			Article top = artilceService.top(articleTypeId);
            
			for(Article article: articleList){
				if(top != null && !article.getId().equals(top.getId())){
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
			}
			articleBuilder.append("</div>");

			if(top != null){
				StringBuilder topBuilder = new StringBuilder();
				topBuilder.append("<div class='row-fluid'>");
				topBuilder.append("<h3>"+top.getTitle()+"</h3>");
				topBuilder.append(top.getContent());
				topBuilder.append("</div>");
				articleBuilder.insert(0, topBuilder.toString());
			}
			req.setAttribute("article", articleBuilder.toString());
		}
	}

}
