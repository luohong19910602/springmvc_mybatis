package net.itaem.menu.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.itaem.menu.dao.IMenuDao;
import net.itaem.menu.entity.Menu;
import net.itaem.menu.service.IMenuService;
import net.itaem.resource.dao.IResourceDao;
import net.itaem.role.dao.IRoleDao;
import net.itaem.role.entity.Role;
import net.itaem.user.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 菜单的service类
 * @author luohong
 * @date 2014-12-10
 * @email 846705189@qq.com
 * */
@Service
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private IMenuDao menuDao;
	@Autowired
	private IResourceDao resourceDao;
	@Autowired
	private IRoleDao roleDao;

	@Transactional
	@Override
	public List<Menu> listAll(boolean containsResource) {
		return menuDao.listAll(containsResource);
	}

	@Transactional
	@Override
	public void add(Menu menu) {
		menuDao.add(menu);
	}

	@Transactional
	@Override
	public void delete(String id) {
		menuDao.delete(id);
	}


	@Override
	public List<Menu> listBy(String roleId) {
		return menuDao.listBy(roleId);
	}

	@Override
	public List<Menu> listAllWithoutOrg(boolean containsResource) {
		List<Menu> menuList = menuDao.listAll(containsResource);
		List<Menu> result = new ArrayList<Menu>();  //直接通过深度遍历来取出菜单的数据

		//使用广度遍历
		if(menuList != null){
			for(Menu menu: menuList){
				result.addAll(allMenu(menu, containsResource));
			}
		}
		return menuList;
	}

	/**
	 * 列出menu中的全部menu，包括自己和所有子menu
	 * @param parent 需要进行递归调用的menu
	 * @param containsResource 是否需要添加菜单对应的资源
	 * @return
	 * */
	public List<Menu> allMenu(Menu parent, boolean containsResource){
		List<Menu> result = new ArrayList<Menu>();  //直接通过深度遍历来取出菜单的数据
		result.add(parent);

		//添加资源的resource
		if(containsResource)
			parent.setResourceList(resourceDao.listBy(parent.getId()));

		if(parent.getChildren() != null && parent.getChildren().size() > 0){  //取出子menu
			for(Menu child: parent.getChildren()){
				result.addAll(allMenu(child, containsResource));
			}
		}

		return result;
	}

	@Override
	public List<Menu> listBy(User user) {
		return menuDao.listBy(user);
	}

	@Override
	public List<Menu> listByUserId(String userId) {
		if(userId == null || "".equals(userId)) return null;
		
		List<Role> roleList = roleDao.listByUserId(userId);
		List<Menu> result = new ArrayList<Menu>();
		
		//user menu
		List<Menu> userMenuList = menuDao.listByUserId(userId);
		if(userMenuList != null && userMenuList.size() > 0){
			result.addAll(userMenuList);
		}

		//role menu
		if(roleList != null && roleList.size() > 0){
			for(Role role: roleList){
				List<Menu> roleMenuList = menuDao.listBy(role.getId());
				if(roleMenuList != null && roleMenuList.size() > 0){
					for(Menu menu: roleMenuList){
						if(result.contains(menu)){
							Menu that = result.get(result.indexOf(menu));
							merge(that, menu);
						}else{
							result.add(menu);
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * 递归合并两个menu
	 * @param menu1 待合并的menu1
	 * @param menu2 待合并的menu2
	 * */
	private void merge(Menu menu1, Menu menu2){
		if(!menu1.equals(menu2)) return;

		menu1.addSubMenu(menu2.getChildren());  //添加子菜单
		menu1.addResourceList(menu2.getResourceList());  //添加资源
        
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
	}

}
