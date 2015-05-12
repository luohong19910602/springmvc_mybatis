package net.itaem.role.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.itaem.role.dao.IRoleDao;
import net.itaem.role.entity.Role;
import net.itaem.role.entity.RoleMapper;
import net.itaem.role.entity.RoleMenu;
import net.itaem.role.entity.RoleMenuMapper;
import net.itaem.role.entity.RolePrivilege;
import net.itaem.role.entity.RolePrivilegeMapper;
import net.itaem.role.entity.RoleUser;
import net.itaem.role.entity.RoleUserMapper;
import net.itaem.user.entity.User;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * 角色Dao实现类
 * @author luohong
 * @date 2014-12-25
 * @email 846705189@qq.com
 * */
@Repository
public class RoleDaoImpl implements IRoleDao {

	@Resource(name = "roleMapper")
	private RoleMapper roleMapper;
	
	@Resource(name = "roleMenuMapper")
	private RoleMenuMapper roleMenuMapper;
	
	@Resource(name = "rolePrivilegeMapper")
	private RolePrivilegeMapper rolePrivilegeMapper;
	
	@Resource(name = "roleUserMapper")
	private RoleUserMapper roleUserMapper;
	
	@Override
	public List<Role> listAll() {
		
		List<Role> roleList = roleMapper.listAll();
		
		List<Role> parentRoleList = new ArrayList<Role>();  //取出没有父亲结点的菜单
		
		for(Role role: roleList){  //遍历全部的角色，找出没有parent的角色
	    	if(role.getParentId() == null || role.getParentId().equals("")){  //该role没有父亲角色，那么直接设置为第一层role
	            parentRoleList.add(role);    		
	    	}
	    }
		
		roleList.removeAll(parentRoleList);  //取出剩余的角色
		
		//递归遍历第一层role，为这些role添加子角色
		for(Role role: parentRoleList){
			setChildren(role, roleList);  //从剩余的子角色中，挑选出属于role的子角色
		}
		
		
		return parentRoleList;
	}

	/**
	 * 从集合中挑选出自己的子角色
	 * */
	private void setChildren(Role role, List<Role> roleList) {
        
		for(Role child: roleList){
        	if(child.getParentId().equals(role.getId())){
        		role.add(child);
        	}
        }
        
		//去掉已经找到的角色
        roleList.remove(role.getChildren());
        
        //如果剩余的角色还有，那么递归调用
        if(role.getChildren() != null && role.getChildren().size() > 0){
        	//递归
        	for(Role child: role.getChildren()){
        		setChildren(child, roleList);
        	}
        }
	}

	@Override
	public void delete(String id) {
		roleMapper.delete(id);
	}

	@Override
	public void add(Role role) {
		roleMapper.add(role);
	}

	@Override
	public Role byId(String roleId) {
		return roleMapper.byId(roleId);
	}

	@Override
	public void addRoleMenu(RoleMenu roleMenu) {
		roleMenuMapper.add(roleMenu);
	}

	@Override
	public void deleteRoleMenu(RoleMenu roleMenu) {
		if(StringUtils.isEmpty(roleMenu.getResourceId())){
		    roleMenuMapper.deleteMenu(roleMenu);
		}else{
			roleMenuMapper.deleteResource(roleMenu);
		}
	}

	@Override
	public void addRolePrivilege(RolePrivilege rolePrivilege) {
		rolePrivilegeMapper.add(rolePrivilege);
	}

	@Override
	public void deleteRolePrivilege(RolePrivilege rolePrivilege) {
		rolePrivilegeMapper.delete(rolePrivilege);
	}

	@Override
	public void addRoleUser(RoleUser roleUser) {
		roleUserMapper.add(roleUser);
	}

	@Override
	public void deleteRoleUser(RoleUser roleUser) {
		roleUserMapper.delete(roleUser);
	}

	@Override
	public List<Role> listBy(User user) {
		return roleMapper.listByUserId(user.getId());
	}
    
	@Override
	public List<Role> listByUserId(String userId) {
		return roleMapper.listByUserId(userId);
	}

}
