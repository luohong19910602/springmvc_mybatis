package net.itaem.department.service;

import java.util.*;
import net.itaem.department.entity.Department;


public interface IDepartmentService{

    public List<Department> listAll();

    public Department listBy(String id);

    public void add(Department Department);

    public void delete(String id);

    public void update(Department Department);
}