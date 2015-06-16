package net.itaem.student.controller;

import net.itaem.student.entity.Student;
import net.itaem.student.service.IStudentService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class StudentDeleteController{

    @Autowired
    private IStudentService studentService;

    @RequestMapping("/student/delete.do")
    public void delete(HttpServletResponse resp){
    }


}