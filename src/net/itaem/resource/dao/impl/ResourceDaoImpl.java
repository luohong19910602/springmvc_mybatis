package net.itaem.resource.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.itaem.resource.dao.IResourceDao;
import net.itaem.resource.entity.ResourceMapper;

import org.springframework.stereotype.Repository;

/**
 * ResourceDao
 * @author luohong
 * @date 2014-12-19
 * @email 846705189@qq.com
 * */
@Repository
public class ResourceDaoImpl implements IResourceDao {
	@Resource(name = "resourceMapper")
    private ResourceMapper resourceMapper;

	@Override
	public List<net.itaem.resource.entity.Resource> listBy(String menuId) {
		
		return resourceMapper.listAll(menuId);
	}

	@Override
	public void add(net.itaem.resource.entity.Resource resource) {
		resourceMapper.add(resource);
	}

	@Override
	public void delete(String[] ids) {
		for(String id: ids){
			
			//do not delete the origin resource
			if(ids.equals("1") || ids.equals("2") || ids.equals("3") || ids.equals("4")){
				continue;
			}
			resourceMapper.delete(id);
		}
	}

	@Override
	public net.itaem.resource.entity.Resource findBy(String resourceId) {
		return resourceMapper.findBy(resourceId);
	}
	
	
}
