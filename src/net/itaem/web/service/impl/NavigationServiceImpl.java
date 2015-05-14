package net.itaem.web.service.impl;

import java.util.List;

import net.itaem.web.dao.INavigationDao;
import net.itaem.web.entity.Navigation;
import net.itaem.web.service.INavigationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 
 * */
@Service
public class NavigationServiceImpl implements INavigationService{

	@Autowired
	private INavigationDao navDao;
	
	@Override
	public List<Navigation> listAll() {
		return navDao.listAll();
	}

	@Override
	public int maxSortFlag() {
		return navDao.maxSortFlag();
	}

	@Override
	public void add(Navigation nav) {
		navDao.add(nav);
	}

	@Override
	public void delete(String[] ids) {
		navDao.delete(ids);
	}

	@Override
	public void update(Navigation nav) {
		navDao.update(nav);
	}

	@Override
	public Navigation findById(String id) {
		return navDao.findBydId(id);
	}

}
