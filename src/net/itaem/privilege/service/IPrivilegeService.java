package net.itaem.privilege.service;

import java.util.List;

import net.itaem.privilege.entity.Privilege;

public interface IPrivilegeService {
	/**
	 * 查询全部的权限
	 * 这里的权限层次关系已经维护好了
	 * */
	public List<Privilege> listAll();

	/**
	 * 列出全部权限
	 * 这里的权限没有维护好层次关系
	 * */
    public List<Privilege> listAllWithoutOrg();
	

	public void add(Privilege privilege);

	public void delete(String[] ids);

	public Privilege listBy(String privilegeId);
	
	public List<Privilege> listByRoleId(String roleId);
	
	/**
	 * 获取用户的权限
	 * 这个方法会先获得该用户的角色，再获得每个角色的权限，然后会去获得属于用户的权限
	 * 然后将权限合并，得到最后属于用户的权限
	 * @param userId
	 * */
	public List<Privilege> listByUserId(String userId);

	public void update(Privilege privilege);
	
}
