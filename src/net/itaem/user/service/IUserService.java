package net.itaem.user.service;

import java.util.List;

import net.itaem.base.entity.Page;
import net.itaem.user.entity.User;
import net.itaem.user.entity.UserMenu;
import net.itaem.user.entity.UserPrivilege;

/**
 * User Service 接口
 * @author luohong
 * @date 2014-12-24
 * @email 846705189@qq.com
 * */
public interface IUserService {

	/**
	 * 判断一个用户是否存在
	 * @param user
	 * @return
	 * */
	public User exists(User user);
	
	/**
	 * 删除用户
	 * 在这里面，不允许删除超级用户
	 * @param ids 用户id列表
	 * 
	 * */
	public void delete(String[] ids);
	
	/**
	 * 用户名是否以及被注册
	 * @param loginName 登录名
	 * */
	public boolean hasRegisted(String loginName);
	
	/**
	 * 列出全部的用户
	 * @return
	 * */
	public List<User> listAll(Page page);
	
	public List<User> listByRoleId(String roleId);

	public void add(User user);

	public User listBy(String userId);
	
	public void addUserPrivilege(UserPrivilege userPri);
	
	public void addUserPrivileges(UserPrivilege[] userPris);
	
	public void deleteUserPrivilege(UserPrivilege userPri);
	
	public void deleteUserPrivileges(UserPrivilege[] userPris);
	
	public void addUserMenu(UserMenu userMenu);
	
	public void deleteUserMenu(UserMenu userMenu);
	
	public int countAll();
	
	public void update(User user);
}
