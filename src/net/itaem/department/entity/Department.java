package net.itaem.department.entity;

import java.util.List;

import net.itaem.base.entity.BaseEntity;
import net.itaem.user.entity.User;

/**
 * 部门实体
 * @author luohong
 * @date 2014-12-16
 * @email 846705189@qq.com
 * */
public class Department extends BaseEntity {
    private String name;  //名字
    private String desc;  //介绍
    private String code;  //编码
    private String attribute;  //部门属性
    private List<User> users;  //部门全部员工
    private Department parent;  //上级部门
    private List<Department> subDepartment;  //子部门
    private User leader;  //部门直属领导
    
    
}
