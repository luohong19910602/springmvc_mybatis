package net.itaem.resource.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.itaem.resource.dao.IResourceDao;
import net.itaem.resource.entity.Resource;
import net.itaem.resource.service.IResourceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author luohong
 * @date 2014-12-10
 * @email 846705189@qq.com
 * */
@Service
public class ResourceServiceImpl implements IResourceService {

	@Autowired
	private IResourceDao resourceDao;
	
	@Override
	public List<Resource> listBy(String menuId) {
		if(menuId == null || menuId.equals("")){
			return new ArrayList<Resource>();
		}
		return resourceDao.listBy(menuId);
	}

	@Transactional
	@Override
	public void add(Resource resource) {
		resourceDao.add(resource);
	}

	@Transactional
	@Override
	public void delete(String[] ids) {
		resourceDao.delete(ids);
	}

	@Transactional
	@Override
	public Resource findBy(String resourceId) {
		return resourceDao.findBy(resourceId);
	}

	@Transactional
	@Override
	public void add(Resource[] resources) {
		if(resources != null && resources.length > 0){
			for(Resource res: resources){
				resourceDao.add(res);
			}
		}
	}

}
