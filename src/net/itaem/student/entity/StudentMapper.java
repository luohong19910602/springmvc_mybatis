package net.itaem.student.entity;

import java.util.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Update;


@Repository(value = "studentMapper")
public interface StudentMapper{

    @Select(value = "请替换成您需要的sql")
    @Results(value = {})
    public List<Student> listAll();

    @Select(value = "请替换成您需要的sql")
    @Results(value = {})
    public Student listBy(String id);

    @Insert("")
    public void add(Student Student);

    @Update("")
    public void delete(String id);

    @Update("")
    public void update(Student Student);
}