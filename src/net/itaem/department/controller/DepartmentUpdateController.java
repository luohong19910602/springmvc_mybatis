package net.itaem.department.controller;

import net.itaem.department.entity.Department;
import net.itaem.department.service.IDepartmentService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DepartmentUpdateController{

    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/department/update.do")
    public String update(HttpServletRequest req){
        return "department/update";
    }

    @RequestMapping("/department/updateSubmit.do")
    public void updateSubmit(Department department, HttpServletRequest req, HttpServletResponse resp){
    }

}