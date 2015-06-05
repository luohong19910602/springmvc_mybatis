package net.itaem.department.entity;

import java.util.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Update;


@Repository(value = "departmentMapper")
public interface DepartmentMapper{

    @Select(value = "请替换成您需要的sql")
    @Results(value = {})
    public List<Department> listAll();

    @Select(value = "请替换成您需要的sql")
    @Results(value = {})
    public Department listBy(String id);

    @Insert("")
    public void add(Department Department);

    @Update("")
    public void delete(String id);

    @Update("")
    public void update(Department Department);
}