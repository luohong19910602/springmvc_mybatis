package net.itaem.resource.service;

import java.util.List;

import net.itaem.resource.entity.Resource;

/**
 * @author luohong
 * @date 2014-12-19
 * @email 846705189@qq.com
 * */
public interface IResourceService {

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
	
	/**
	 * 添加多个resource
	 * @param resources
	 * @see IResourceService#add(Resource)
	 * */
	public void add(Resource[] resources);
	
	/**
	 * 批量删除resource
	 * @param ids 资源id数组
	 * */
	public void delete(String[] ids);
    
	/**
	 * 查找资源
	 * @param resourceId
	 * @return
	 * */
	public Resource findBy(String resourceId);
}
