package net.itaem.user.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.itaem.base.entity.Page;
import net.itaem.user.dao.IUserDao;
import net.itaem.user.entity.User;
import net.itaem.user.entity.UserMapper;
import net.itaem.user.entity.UserMenu;
import net.itaem.user.entity.UserMenuMapper;
import net.itaem.user.entity.UserPrivilege;
import net.itaem.user.entity.UserPrivilegeMapper;

import org.springframework.stereotype.Repository;

/**
 * 用户user dao的实现类
 * @author luohong
 * @date 2014-12-24
 * @email 846705189@qq.com
 * */
@Repository
public class UserDaoImpl implements IUserDao {

	@Resource(name = "userMapper")
	private UserMapper userMapper;
	
	@Resource(name = "userPrivilegeMapper")
	private UserPrivilegeMapper userPrivilegeMapper;
    
	@Resource(name = "userMenuMapper")
	private UserMenuMapper userMenuMapper;
    
	@Override
	public User exists(User user) {
		return userMapper.exists(user);
	}

	@Override
	public List<User> listByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return userMapper.listByRoleId(roleId);
	}

	@Override
	public List<User> listAll(Page page) {
		return userMapper.listAll(page);
	}
	
	

	@Override
	public void add(User user) {
		userMapper.add(user);
	}

	@Override
	public User listBy(String userId) {
		return userMapper.listBy(userId);
	}

	@Override
	public void addUserPrivilege(UserPrivilege userPri) {
		userPrivilegeMapper.add(userPri);
	}

	@Override
	public void addUserMenu(UserMenu userMenu) {
		userMenuMapper.add(userMenu);
	}

	@Override
	public void deleteUserMenu(UserMenu userMenu) {
		userMenuMapper.delete(userMenu);
	}

	@Override
	public void deleteUserPrivilege(UserPrivilege userPri) {
		userPrivilegeMapper.delete(userPri);
	}

	@Override
	public int countAll() {
		return userMapper.countAll();
	}

	@Override
	public boolean hasRegisted(String loginName) {
		return userMapper.countLoginName(loginName) >= 1;
	}

	@Override
	public void delete(String id) {
		userMapper.delete(id);
	}

	@Override
	public void update(User user) {
		userMapper.update(user);
	}

}
