package net.itaem.web.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.itaem.web.dao.INavigationDao;
import net.itaem.web.entity.Navigation;
import net.itaem.web.entity.NavigationMapper;

import org.springframework.stereotype.Repository;

/**
 * 
 * 
 * */
@Repository
public class NavigationDaoImpl implements INavigationDao{

	@Resource(name = "navigationMapper")
	private NavigationMapper navMapper;

	@Override
	public List<Navigation> listAll() {
		return navMapper.listAll();
	}

	@Override
	public int maxSortFlag() {
		Integer max = navMapper.maxSortFlag();
		if(max == null)
			max = 0;
		return max;
	}

	@Override
	public void add(Navigation nav) {
		navMapper.add(nav);
	}

	@Override
	public void delete(String[] ids) {
		for(String id: ids){
			navMapper.delete(id);
		}	
	}

	@Override
	public void update(Navigation nav) {
		navMapper.update(nav);
	}

	@Override
	public Navigation findBydId(String id) {
		return navMapper.findById(id);
	}

}
