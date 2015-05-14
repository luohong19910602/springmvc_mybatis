package net.itaem.slide.dao;

import java.util.List;

import net.itaem.slide.entity.Slide;


public interface ISlideDao {

	public void add(Slide slide);
	
	public void delete(String id);

    public List<Slide> listAll();

	public void delete(String[] ids);
    
}
