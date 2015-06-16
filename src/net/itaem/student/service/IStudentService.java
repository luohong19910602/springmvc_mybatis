package net.itaem.student.service;

import java.util.*;
import net.itaem.student.entity.Student;


public interface IStudentService{

    public List<Student> listAll();

    public Student listBy(String id);

    public void add(Student Student);

    public void delete(String id);

    public void update(Student Student);
}