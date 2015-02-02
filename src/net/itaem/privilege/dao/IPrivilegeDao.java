package net.itaem.privilege.dao;

import java.util.List;

import net.itaem.privilege.entity.Privilege;

public interface IPrivilegeDao {

	/**
	 * 查询全部的权限
	 * */
	public List<Privilege> listAll();

	public void add(Privilege privilege);

	public void delete(String[] ids);

	public Privilege listBy(String privilegeId);
	
	
	public List<Privilege> listByUserId(String userId);
	
	public List<Privilege> listByRoleId(String roleId);

	public void update(Privilege privilege);
}
