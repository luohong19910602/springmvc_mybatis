package net.itaem.user.dao;

import java.util.List;

import net.itaem.base.entity.Page;
import net.itaem.user.entity.User;
import net.itaem.user.entity.UserMenu;
import net.itaem.user.entity.UserPrivilege;

/**
 * 用户user的dao接口
 * @author luohong
 * @date 2014-12-24
 * @email 846705189@qq.com
 * */
public interface IUserDao {

	/**
	 * 判断一个用户是否存在
	 * @param user
	 * @return
	 * */
	public User exists(User user);
	
	public int countAll();

	public List<User> listByRoleId(String roleId);
    
	public List<User> listAll(Page page);

	public void add(User user);

	public User listBy(String userId);

	public void addUserPrivilege(UserPrivilege userPri);
	
	public void deleteUserPrivilege(UserPrivilege userPri);
	
	public void addUserMenu(UserMenu userMenu);

	public void deleteUserMenu(UserMenu userMenu);

	public boolean hasRegisted(String loginName);

	public void delete(String id);

	public void update(User user);
	
}
