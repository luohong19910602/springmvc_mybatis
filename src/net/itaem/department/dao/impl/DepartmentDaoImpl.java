package net.itaem.department.dao.impl;

import java.util.*;
import net.itaem.department.entity.Department;
import net.itaem.department.dao.IDepartmentDao;
import net.itaem.department.entity.DepartmentMapper;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;


@Repository
public class DepartmentDaoImpl implements IDepartmentDao{

    @Resource(name = "departmentMapper")
    private DepartmentMapper departmentMapper;

    public List<Department> listAll(){
        return departmentMapper.listAll();
    }

    public Department listBy(String id){
        return departmentMapper.listBy(id);
    }

    public void add(Department department){
        departmentMapper.add(department);
    }

    public void delete(String id){
        departmentMapper.delete(id);
    }

    public void update(Department department){
        departmentMapper.update(department);
    }
}