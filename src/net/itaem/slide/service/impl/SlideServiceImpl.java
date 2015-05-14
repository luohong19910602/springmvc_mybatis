package net.itaem.slide.service.impl;

import java.util.List;

import net.itaem.slide.dao.ISlideDao;
import net.itaem.slide.entity.Slide;
import net.itaem.slide.service.ISlideService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SlideServiceImpl implements ISlideService {
    
	@Autowired
    private ISlideDao slideDao;

	@Override
	public void add(Slide slide) {
		slideDao.add(slide);
	}

	@Override
	public void delete(String id) {
		slideDao.delete(id);
	}

	@Override
	public List<Slide> listAll() {
		return slideDao.listAll();
	}

	@Override
	public void delete(String[] ids) {
		slideDao.delete(ids);
	}

}
