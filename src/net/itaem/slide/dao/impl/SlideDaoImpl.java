package net.itaem.slide.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.itaem.slide.dao.ISlideDao;
import net.itaem.slide.entity.Slide;
import net.itaem.slide.entity.SlideMapper;

import org.springframework.stereotype.Repository;


@Repository
public class SlideDaoImpl implements ISlideDao {
    
	@Resource(name = "slideMapper")
    private SlideMapper slideMapper;

	@Override
	public void add(Slide slide) {
		slideMapper.add(slide);
	}

	@Override
	public void delete(String id) {
		slideMapper.delete(id);
	}

	@Override
	public List<Slide> listAll() {
		return slideMapper.listAll();
	}

	@Override
	public void delete(String[] ids) {
		for(String id: ids){
			slideMapper.delete(id);
		}
	}

}
