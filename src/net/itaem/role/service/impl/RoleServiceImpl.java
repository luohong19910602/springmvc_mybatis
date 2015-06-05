package net.itaem.role.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.itaem.role.dao.IRoleDao;
import net.itaem.role.entity.Role;
import net.itaem.role.entity.RoleMenu;
import net.itaem.role.entity.RolePrivilege;
import net.itaem.role.entity.RoleUser;
import net.itaem.role.service.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 角色Service
 * @author luohong 15013336884
 * */
@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleDao roleDao;
	
	@Transactional
	@Override
	public List<Role> listAll() {
		return roleDao.listAll();
	}
	
	@Transactional
	@Override
	public void delete(String id) {
		roleDao.delete(id);
	}
	@Transactional
	@Override
	public void add(Role role) {
		roleDao.add(role);
	}

	@Override
	public Role byId(String roleId) {
		return roleDao.byId(roleId);
	}
	@Transactional
	@Override
	public void addRoleMenu(RoleMenu roleMenu) {
		roleDao.addRoleMenu(roleMenu);
	}
	@Transactional
	@Override
	public void deleteRoleMenu(RoleMenu roleMenu) {
		roleDao.deleteRoleMenu(roleMenu);
	}
	@Transactional
	@Override
	public void addRolePrivilege(RolePrivilege rolePrivilege) {
		roleDao.addRolePrivilege(rolePrivilege);
	}
	@Transactional
	@Override
	public void deleteRolePrivilege(RolePrivilege rolePrivilege) {
		roleDao.deleteRolePrivilege(rolePrivilege);
	}
	@Transactional
	@Override
	public void addRoleUser(RoleUser roleUser) {
		roleDao.addRoleUser(roleUser);
	}
	@Transactional
	@Override
	public void deleteRoleUser(RoleUser roleUser) {
		roleDao.deleteRoleUser(roleUser);
	}
    
	/**
	 * 
	 * */
	@Override
	public List<Role> listAllWithoutOrg() {
		List<Role> roleList = roleDao.listAll();
		List<Role> result = new ArrayList<Role>();  //直接通过深度遍历来取出菜单的数据

		//使用广度遍历
		if(roleList != null){
			for(Role role: roleList){
				result.addAll(allRole(role));
			}
		}
		return roleList;
	}



	/**
	 * 列出该role全部子孙role，包括自己
	 * @param parent 父节点role
	 * @return 该role下面的全部子孙role
	 * */
	public List<Role> allRole(Role parent){
		if(parent == null) return null;
		
		List<Role> result = new ArrayList<Role>();  //直接通过深度遍历来取出菜单的数据
		result.add(parent);
		if(parent.getChildren() != null && parent.getChildren().size() > 0){  //取出子menu
			for(Role child: parent.getChildren()){
				result.addAll(allRole(child));
			}
		}
		return result;
	}
	
	@Transactional
	@Override
	public void addRoleMenus(RoleMenu[] roleMenus) {
	    if(roleMenus != null && roleMenus.length > 0)
	    	for(RoleMenu roleMenu: roleMenus){
	    		roleDao.addRoleMenu(roleMenu);
	    	}
	}
	
	@Override
	public List<Role> listByUserId(String userId) {
		return roleDao.listByUserId(userId);
	}
}
