package net.itaem.department.dao;

import java.util.*;
import net.itaem.department.entity.Department;


public interface IDepartmentDao{

    public List<Department> listAll();

    public Department listBy(String id);

    public void add(Department Department);

    public void delete(String id);

    public void update(Department Department);
}