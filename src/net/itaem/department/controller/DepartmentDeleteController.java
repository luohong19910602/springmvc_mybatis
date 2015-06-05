package net.itaem.department.controller;

import net.itaem.department.entity.Department;
import net.itaem.department.service.IDepartmentService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DepartmentDeleteController{

    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/department/delete.do")
    public void delete(HttpServletResponse resp){
    }


}