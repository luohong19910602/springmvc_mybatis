package net.itaem.slide.service;

import java.util.List;

import net.itaem.slide.entity.Slide;

public interface ISlideService {

	public void add(Slide slide);
	
	public void delete(String id);
	
	public void delete(String[] ids);

    public List<Slide> listAll();
    
}