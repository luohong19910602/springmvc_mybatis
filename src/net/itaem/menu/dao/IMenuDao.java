package net.itaem.menu.dao;

import java.util.List;

import net.itaem.menu.entity.Menu;
import net.itaem.user.entity.User;

/**
 * 
 * 菜单Dao接口类
 * @author luohong
 * @date 2014-12-10
 * @email 846705189@qq.com
 * */
public interface IMenuDao {
	/**
	 * 列出全部菜单
	 * 并且这些菜单的层次关系必须维护好
	 * 因为在管理menu时，不需要列出menu的资源，所以这里设置一个参数，该参数默认为false
	 * 
	 * @param containsResource 是否需要包含resource
	 * @return
	 * */
    public List<Menu> listAll(boolean containsResource);

    /**
     * 添加一个Menu
     * @param menu
     * */
	public void add(Menu menu);

	/**
	 * 删除一个菜单
	 * @param id 
	 * */
	public void delete(String id);
    
	/**
	 * 根据角色id来查找所属的menu
	 * 并且同时组织好这些menu以及resource之间的层次关系
	 * 所以这里的数据会比较麻烦一点
	 * 因为数据库保存了menu_id,resource_id,role_id
	 * 所以要获取某个角色可以访问菜单以及资源，就需要先拿到menu_id列表，
	 * 然后递归遍历这些menu，查看这个menu是不是还有父亲menu
	 * */
	public List<Menu> listBy(String roleId);
	
	/**
	 * 列出用户可以访问的菜单
	 * 这里需要先获取用户的角色，然后再将角色之间的菜单组合在一起，形成用户的菜单
	 * @param user
	 * @return 
	 * */
	public List<Menu> listBy(User user);

	public List<Menu> listByUserId(String userId);
}
