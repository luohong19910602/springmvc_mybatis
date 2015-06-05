package net.itaem.department.controller;

import net.itaem.department.entity.Department;
import net.itaem.department.service.IDepartmentService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DepartmentListController{

    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/department/list.do")
    public String list(HttpServletRequest req){
        return "department/list";
    }

    @RequestMapping("/department/listJson.do")
    public void listJson(HttpServletResponse resp){
    }


}