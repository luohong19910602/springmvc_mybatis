package net.itaem.resource.dao;

import java.util.List;

import net.itaem.resource.entity.Resource;

/**
 * url资源DAO接口
 * @author luohong
 * @date 2014-12-19
 * @email 846705189@qq.com
 * */
public interface IResourceDao {

	/**
	 * 获取指定菜单下面的全部url资源
	 * @param menuId
	 * */
	public List<Resource> listBy(String menuId);
	
	/**
	 * 添加一个resource
	 * @param resource
	 * @return
	 * */
	public void add(Resource resource);

	public void delete(String[] ids);

	public Resource findBy(String resourceId);
}
