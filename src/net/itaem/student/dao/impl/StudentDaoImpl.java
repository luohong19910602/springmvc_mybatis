package net.itaem.student.dao.impl;

import java.util.*;
import net.itaem.student.entity.Student;
import net.itaem.student.dao.IStudentDao;
import net.itaem.student.entity.StudentMapper;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;


@Repository
public class StudentDaoImpl implements IStudentDao{

    @Resource(name = "studentMapper")
    private StudentMapper studentMapper;

    public List<Student> listAll(){
        return studentMapper.listAll();
    }

    public Student listBy(String id){
        return studentMapper.listBy(id);
    }

    public void add(Student student){
        studentMapper.add(student);
    }

    public void delete(String id){
        studentMapper.delete(id);
    }

    public void update(Student student){
        studentMapper.update(student);
    }
}