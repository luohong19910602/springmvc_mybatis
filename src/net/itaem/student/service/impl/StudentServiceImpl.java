package net.itaem.student.service.impl;

import java.util.*;
import net.itaem.student.entity.Student;
import net.itaem.student.service.IStudentService;
import net.itaem.student.dao.IStudentDao;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private IStudentDao studentDao;

    public List<Student> listAll(){
        return studentDao.listAll();
    }

    public Student listBy(String id){
        return studentDao.listBy(id);
    }

    public void add(Student student){
        studentDao.add(student);
    }

    public void delete(String id){
       studentDao.delete(id);
    }

    public void update(Student student){
        studentDao.update(student);
    }
}