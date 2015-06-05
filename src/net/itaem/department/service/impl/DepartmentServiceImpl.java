package net.itaem.department.service.impl;

import java.util.*;
import net.itaem.department.entity.Department;
import net.itaem.department.service.IDepartmentService;
import net.itaem.department.dao.IDepartmentDao;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class DepartmentServiceImpl implements IDepartmentService{

    @Autowired
    private IDepartmentDao departmentDao;

    public List<Department> listAll(){
        return departmentDao.listAll();
    }

    public Department listBy(String id){
        return departmentDao.listBy(id);
    }

    public void add(Department department){
        departmentDao.add(department);
    }

    public void delete(String id){
       departmentDao.delete(id);
    }

    public void update(Department department){
        departmentDao.update(department);
    }
}