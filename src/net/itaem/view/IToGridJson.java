package net.itaem.view;

import java.util.List;

import net.itaem.article.entity.Article;
import net.itaem.article.entity.ArticleType;
import net.itaem.menu.entity.Menu;
import net.itaem.privilege.entity.Privilege;
import net.itaem.role.entity.Role;
import net.itaem.user.entity.User;

/**
 * 将数据变成liger ui grid组件的json字符串
 * @author luohong
 * @email 846705189@qq.com
 * @date 2015-01-13
 * */
public interface IToGridJson {

	/**
	 * 将权限列表变成liger ui grid组件的json数据
	 * @param privilegeList 权限列表
	 * @param total 记录总数
	 * @return 返回liger ui grid json数据
	 * @see IToGridJson#privilegeToGrid(Privilege)
	 * */
	public String privilegeListToGrid(List<Privilege> privilegeList, int total);
	
	/**
	 * 将文章类别变成liger ui grid组件的json数据
	 * @param articleTypeList 文章类别列表
	 * @return 返回liger ui grid json数据
	 * */
	public String articleTypeListToGrid(List<ArticleType> articleTypeList);
	
	/**
	 * 将权限变成liger ui grid组件的json数据
	 * @param privilegeList
	 * @return 返回liger ui grid json数据
	 * */
	public String privilegeToGrid(Privilege privilege);

	/**
	 * 将用户列表变成liger ui grid组件的json数据
	 * @param userList
	 * @return 返回liger ui grid json数据
	 * @see IToGridJson#userToGrid(Privilege)
	 * */
	public String userListToGrid(List<User> userList);

	/**
	 * 将用户变成liger ui grid组件的json数据
	 * @param userList
	 * @return 返回liger ui grid json数据
	 * */
	public String userToGrid(User user);

	
	/**
	 * 将菜单列表变成liger ui grid组件的json数据
	 * @param menuList
	 * @return 返回liger ui grid json数据
	 * @see IToGridJson#menuToGrid(Privilege)
	 * */
	public String menuListToGrid(List<Menu> menuList);

	/**
	 * 将菜单变成liger ui grid组件的json数据
	 * @param menu
	 * @return 返回liger ui grid json数据
	 * */
	public String menuToGrid(Menu menu);

	/**
	 * 将资源变成liger ui grid组件的json数据
	 * @param resource
	 * @return 返回liger ui grid json数据
	 * */
	public String resourceToGrid(net.itaem.resource.entity.Resource resource);

	
	/**
	 * 将角色列表变成liger ui grid组件的json数据
	 * @param roleList
	 * @return 返回liger ui grid json数据
	 * @see IToGridJson#roleToGrid(Role)
	 * */
	public String roleListToGrid(List<Role> roleList);

	/**
	 * 将角色变成liger ui grid组件的json数据
	 * @param role
	 * @return 返回liger ui grid json数据
	 * */
	public String roleToGrid(Role role);

	public String articleListToGrid(List<Article> articleList);
	
}
