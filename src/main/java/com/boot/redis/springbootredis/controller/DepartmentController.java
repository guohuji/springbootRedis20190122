package com.boot.redis.springbootredis.controller;

import com.boot.redis.springbootredis.bean.Department;
import com.boot.redis.springbootredis.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        Department deptById = departmentMapper.getDeptById(id);
        return deptById;
    }

    @GetMapping("/dept")
    public Department insetDept(Department department){
        departmentMapper.insertDeptById(department);
        return department;
    }
}
