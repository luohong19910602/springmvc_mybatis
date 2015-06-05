package net.itaem.department.controller;

import net.itaem.department.entity.Department;
import net.itaem.department.service.IDepartmentService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DepartmentAddController{

    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/department/add.do")
    public String add(HttpServletRequest req){
        return "department/add";
    }

    @RequestMapping("/department/addSubmit.do")
    public void addSubmit(Department department, HttpServletRequest req, HttpServletResponse resp){
    }

}