package net.itaem.role.dao;

import java.util.List;

import net.itaem.role.entity.Role;
import net.itaem.role.entity.RoleMenu;
import net.itaem.role.entity.RolePrivilege;
import net.itaem.role.entity.RoleUser;
import net.itaem.user.entity.User;

/**
 * 角色Dao接口
 * @author luohong
 * @date 2014-12-25
 * @email 846705189@qq.com
 * */
public interface IRoleDao {
	
	/**
	 * 列出全部的角色
	 * 并且角色之间必须维护好层次管理
	 * 并且这里的角色必须把可以访问的菜单也查询出来
	 * 
	 * @return
	 * */
    public List<Role> listAll();
    
    /**
     * 删除一个角色
     * @param id
     * 
     * */
    public void delete(String id);

	public void add(Role role);

	public Role byId(String roleId);
	
	/**
	 * 获取用户的角色列表
	 * @param user
	 * @return 
	 * */
	public List<Role> listBy(User user);

	public List<Role> listByUserId(String userId);
	
	public void addRoleMenu(RoleMenu roleMenu);
	
	/**
	 * 根据id删除role menu
	 * */
	public void deleteRoleMenu(RoleMenu roleMenu);

	public void addRolePrivilege(RolePrivilege rolePrivilege);

	public void deleteRolePrivilege(RolePrivilege rolePrivilege);
	
	public void addRoleUser(RoleUser roleUser);
	
	public void deleteRoleUser(RoleUser roleUser);
	
	/**
	 * 删除user的role-user中间表数据
	 * */
	public void deleteRoleUserByUserId(String userId);
}
