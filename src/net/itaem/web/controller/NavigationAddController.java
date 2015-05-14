package net.itaem.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.article.entity.ArticleType;
import net.itaem.article.service.IArticleTypeService;
import net.itaem.base.controller.BaseController;
import net.itaem.util.DateUtil;
import net.itaem.util.JsonUtil;
import net.itaem.util.UUIDUtil;
import net.itaem.web.entity.Navigation;
import net.itaem.web.service.INavigationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 添加文章类别Controller
 * 
 * */
@Controller
public class NavigationAddController extends BaseController {

	@Autowired
	private INavigationService navService;
	@Autowired
	private IArticleTypeService typeService;

	@RequestMapping("/navigation/add.do")
	public String add(HttpServletRequest req){
		//最大排序值
		int maxSortFlag = navService.maxSortFlag();
		req.setAttribute("maxSortFlag", maxSortFlag + 1);

		//文章类别
		List<ArticleType> typeList = typeService.listAll();
		StringBuilder typeBuilder = new StringBuilder();
		typeBuilder.append("<p style='vertical-align:middle'>");

		if(typeList != null){
			for(ArticleType type: typeList){
				typeBuilder.append("<label style='vertical-align:middle'>" + type.getName() + "</label>");
				typeBuilder.append("<input name='articleTypeList' style='vertical-align:middle' value='" + type.getId() + "' type='checkbox' id='articleTypeList'/>");
				typeBuilder.append("&nbsp;");
				typeBuilder.append("&nbsp;");
				typeBuilder.append("&nbsp;");
			}
		}

		typeBuilder.append("</p>");
		req.setAttribute("type", typeBuilder.toString());
		return "navigation/add";
	}

	@RequestMapping("/navigation/addSubmit.do")
	public void addArticleByAndroid(Navigation nav,HttpServletRequest req, HttpServletResponse resp) throws IOException{
		nav.setId(UUIDUtil.uuid());
		nav.setCreatedTime(DateUtil.getNowDate(null));

		//获取关联的文章类别，然后存入数据库中
		String[] types = req.getParameterValues("articleTypeList");
		StringBuilder sb = new StringBuilder();
		if(types != null)
			for(int i=0; i<types.length; i++){
				if(i != types.length-1)
					sb.append(types[i] + Navigation.ARTICLE_TYPE_SEPORATOR);
				else
					sb.append(types[i]);
			}
		nav.setArticleTypeListStr(sb.toString());
		navService.add(nav);

		println(resp, JsonUtil.createJson("success", "添加导航成功"));
	}
}
