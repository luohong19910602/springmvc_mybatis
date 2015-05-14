package net.itaem.web.service;

import java.util.List;

import net.itaem.web.entity.Navigation;

public interface INavigationService {
	public List<Navigation> listAll();
	
	/**
	 * 最大排序值
	 * */
	public int maxSortFlag();
	
	public void add(Navigation nav);
	
	public void delete(String[] ids);
	
	public void update(Navigation nav);

	public Navigation findById(String id);
}
