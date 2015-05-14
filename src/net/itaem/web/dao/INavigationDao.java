package net.itaem.web.dao;

import java.util.List;

import net.itaem.web.entity.Navigation;

public interface INavigationDao {
	public List<Navigation> listAll();

	public int maxSortFlag();

	public void add(Navigation nav);

	public void delete(String[] ids);

	public void update(Navigation nav);

	public Navigation findBydId(String id);
}
