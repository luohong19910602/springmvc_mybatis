package net.itaem.menu.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import net.itaem.menu.dao.IMenuDao;
import net.itaem.menu.entity.Menu;
import net.itaem.menu.entity.MenuMapper;
import net.itaem.resource.entity.ResourceMapper;
import net.itaem.role.entity.RoleMapper;
import net.itaem.role.entity.RoleMenu;
import net.itaem.user.entity.User;
import net.itaem.user.entity.UserMenu;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * 这个是菜单的Dao
 * 由于角色需要获得菜单，用户需要获得菜单，所以这里提供了根据用户、角色去查找菜单的功能
 * 为了是上层的service更加干净，需要在这里维护好菜单的资源关系，以及菜单的合并关系
 * 
 * @author luohong
 * @date 2014-12-10
 * @email 846705189@qq.com
 * */
@Repository
public class MenuDaoImpl implements IMenuDao{

	@Resource(name = "menuMapper")
	private MenuMapper menuMapper;

	@Resource(name = "resourceMapper")
	private ResourceMapper resourceMapper;

	@Resource(name = "roleMapper")
	private RoleMapper roleMapper;
	
	

	/**
	 * 列出全部的菜单资源
	 * @param containsResource 需要包含菜单资源变量，如果为true，则需要
	 * @return 返回全部菜单，并且这次菜单的组织关系已经维护好
	 * */
	@Override
	public List<Menu> listAll(boolean containsResource) {
		String sql = "select * from sys_menu where menu_del_flag=0";

		List<Menu> menuList = menuMapper.listAll(sql);  //列出全部menu
		List<Menu> parentMenuList = new ArrayList<Menu>();  //取出没有父亲结点的菜单

		if(menuList != null && menuList.size() > 0){  //将这些菜单的层次关系维护好
			Iterator<Menu> menuIterator = menuList.iterator();

			List<Menu> removedMenu = new ArrayList<Menu>();  //1找出没有父亲结点的菜单，也就是最大结点菜单
			while(menuIterator.hasNext()){
				Menu menu = menuIterator.next();
				//设置menu的resource
				if(StringUtils.isEmpty(menu.getParentId())){
					if(containsResource)
						menu.setResourceList(resourceMapper.listAll(menu.getId()));
					
					parentMenuList.add(menu);
					removedMenu.add(menu);
				}

			}

			//2去除最大结点菜单
			menuList.removeAll(removedMenu);

			if(menuList.size() > 0){  //3将剩下的menu，递归遍历，组织好menu之间的层次关系
				menuIterator = parentMenuList.iterator();
				while(menuIterator.hasNext()){
					Menu menu = menuIterator.next();
					organizeMenu(menu, menuList, containsResource);
				}
			}
		}


		return parentMenuList;  //取出没有父亲结点的菜单;
	}

	/**
	 * 组织好菜单的层次关系
	 * @param parent 父亲菜单
	 * @param source 所有待组织的菜单
	 * */
	private void organizeMenu(Menu parent, List<Menu> source, boolean containsResource){
		if(source == null || source.size() == 0) return;  //break out

		List<Menu> removedMenu = new ArrayList<Menu>();

		for(Menu menu: source){

			if(menu.getParentId() != null && menu.getParentId().equals(parent.getId())){
				parent.addSubMenu(menu);
				if(containsResource)
					menu.setResourceList(resourceMapper.listAll(menu.getId()));
				//从原来的集合中删除，因为已经该menu的父亲menu了
				removedMenu.add(menu);
			}
		}

		source.removeAll(removedMenu);  //去除掉已经选中的元素

		if(source.size() == 0) return;

		/**
		 * 对上一层已经找到父亲menu的菜单进行递归调用
		 * source由原来的变成 source - 已经找到父亲menu的剩余菜单
		 * */
		for(Menu menu: removedMenu){
			organizeMenu(menu, source, containsResource);
		}
	}

	/**
	 * 添加一个新的菜单
	 * @param menu 新添加的菜单
	 * */
	@Override
	public void add(Menu menu) {
		if(menu.getParentId() == null)
			menuMapper.add(menu);
		else
			menuMapper.addChild(menu);
	}

	/**
	 * 删除一个菜单
	 * @param id 菜单id
	 * */
	@Override
	public void delete(String id) {
		menuMapper.delete(id);
	}

	/**
	 * 这个方法会直接查询数据库，先获得用户可以访问的菜单
	 * 如果某个菜单还有父亲菜单，那么就递归下去，直至得到最大的根节点菜单
	 * 然后将这些菜单对应的url资源也查询出来，放入到菜单的资源列表
	 * @param roleId角色id
	 * @return
	 * */
	@Override
	public List<Menu> listBy(String roleId) {
		List<Menu> menuList = menuMapper.listByRoleId(roleId);

		List<Menu> result = new ArrayList<Menu>();

		if(menuList != null && menuList.size() > 0){
			for(Menu menu: menuList){  //遍历每个menu，然后查询该menu的父亲menu，以及resource列表
				Menu tree = route(menu, roleId);  //形成一个menu树，并且返回最大的树根节点				

				if(!result.contains(tree)){
					result.add(tree);
				}else{
					int index = result.indexOf(tree);
					Menu child = result.get(index);  
					merge(child, tree);
				}
			}
		}
		return result;
	}
	
	
	public List<Menu> listByUserId(String userId){
		List<Menu> menuList = menuMapper.listByUserId(userId);
		
		List<Menu> result = new ArrayList<Menu>();
		if(menuList != null && menuList.size() > 0){
			for(Menu menu: menuList){  //遍历每个menu，然后查询该menu的父亲menu，以及resource列表
				Menu tree = routeByUserId(menu, userId);  //形成一个menu树，并且返回最大的树根节点				

				if(!result.contains(tree)){
					result.add(tree);
				}else{
					int index = result.indexOf(tree);
					Menu child = result.get(index);  

					//add child
					if(child != null){
						child.addSubMenu(tree.getChildren());
					}
					//add resource list
					child.addResourceList(tree.getResourceList());
				}
			}
		}
		return result;
	}
	
	
	/**
	 * 
	 * 形成一个用户的menu树，并且返回最大的树根节点
	 * 这里会同时设置该用户该menu的所属URL
	 * */
	private Menu routeByUserId(Menu menu, String userId){
		if(menu == null){
			return null;
		}
        
		List<Menu> route = new LinkedList<Menu>();
		
		if(menu.getParentId() != null && !"".equals(menu.getId())){
			//递归向上遍历menu树，直到根节点
			Menu parent = menuMapper.findBy(menu.getParentId());;
			while(parent != null){
				route.add(0, parent);
				if(parent.getParentId() == null || parent.getParentId().equals("")){
					break;
				}
				parent = menuMapper.findBy(parent.getParentId());
			}
			route.add(route.size(), menu);        
			
			//设置该menu的URL列表
			UserMenu userMenu = new UserMenu();
			userMenu.setUserId(userId);
			userMenu.setMenuId(menu.getId());
			menu.setResourceList(menuMapper.findByUserAndMenu(userMenu));
			
			//形成menu树
			if(route.size() > 1){
				for(int i=0; i<route.size()-1; i++){
					route.get(i).addSubMenu(route.get(i+1));
				}
			}

			//取出第一个menu，直接返回即可
			return route.get(0);
			
		}else{  //该节点无父亲结点，直接设置该menu的URL列表，并且返回
			
			//设置该menu的资源列表
			UserMenu userMenu = new UserMenu();
			userMenu.setUserId(userId);
			userMenu.setMenuId(menu.getId());
			menu.setResourceList(menuMapper.findByUserAndMenu(userMenu));
			return menu;
		}
	}

	/**
	 * 形成一个角色的menu树，并且返回最大的树根节点
	 * 这里会同时设置menu的所属URL
	 * 递归遍历的流程：判断给menu是否有父亲节点，如果有，一直遍历到最大的父亲结点，
	 * 然后将
	 * */
	private Menu route(Menu menu, String roleId){
		if(menu == null){
			return null;
		}

		List<Menu> route = new LinkedList<Menu>();
		if(menu.getParentId() != null && !"".equals(menu.getId())){
			Menu parent = menuMapper.findBy(menu.getParentId());;
			while(parent != null){
				route.add(0, parent);
				if(parent.getParentId() == null || parent.getParentId().equals("")){
					break;
				}
				parent = menuMapper.findBy(parent.getParentId());
			}
			route.add(route.size(), menu);
			
			//设置该menu的资源列表
			RoleMenu roleMenu = new RoleMenu();
			roleMenu.setMenuId(menu.getId());
			roleMenu.setRoleId(roleId);
			menu.setResourceList(menuMapper.findByRoleAndMenu(roleMenu));

			//形成menu树
			if(route.size() > 1){
				for(int i=0; i<route.size()-1; i++){
					route.get(i).addSubMenu(route.get(i+1));
				}
			}

			//取出第一个menu，直接返回即可
			return route.get(0);
		}else{
			//设置该menu的资源列表
			RoleMenu roleMenu = new RoleMenu();
			roleMenu.setMenuId(menu.getId());
			roleMenu.setRoleId(roleId);

			menu.setResourceList(menuMapper.findByRoleAndMenu(roleMenu));

			return menu;
		}
	}

	/**
	 * 1这个方法先获得用户的角色列表
	 * 2遍历角色列表，获取每个角色的菜单
	 * 3合并相同的菜单
	 * */
	@Override
	public List<Menu> listBy(User user) {
        return listByUserId(user.getId());
	}


	/**
	 * 合并两个menu
	 * 这时候这两个menu其实是同等的，通过id来判断，但是其他内容都可以不相同
	 * 所以需要将一个menu的子menu添加到另个一个menu对象中，同时资源列表也是
	 * 由于两个菜单的层次关系不一定一致，所以这里还需要递归的处理
	 * @param menu1
	 * @param menu2
	 * */
	private void merge(Menu menu1, Menu menu2){
		menu1.addSubMenu(menu2.getChildren());  //添加子菜单
		if(menu1.getChildren() != null && menu1.getChildren().size() > 0 
				&& menu2.getChildren() != null && menu2.getChildren().size() > 0){  //递归搞定其他的menu合并
			
			for(Menu m1: menu1.getChildren()){
				for(Menu m2: menu2.getChildren()){
					if(m1.equals(m2)){
						merge(m1, m2);
					}
				}
			}
		}
		menu1.addResourceList(menu2.getResourceList());  //添加资源
	}

}
