package net.itaem.student.controller;

import net.itaem.student.entity.Student;
import net.itaem.student.service.IStudentService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class StudentListController{

    @Autowired
    private IStudentService studentService;

    @RequestMapping("/student/list.do")
    public String list(HttpServletRequest req){
        return "student/list";
    }

    @RequestMapping("/student/listJson.do")
    public void listJson(HttpServletResponse resp){
    }


}