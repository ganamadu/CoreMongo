package com.core.mongo.service;

import com.core.mongo.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello...";
    }

    @GetMapping
    public List<Emp> getEmpList() {
        return employeeService.getEmpList();
    }

    @GetMapping("/{empno}")
    public Emp getEmpByEmpno(@PathVariable("empno") Integer empno) {
        return employeeService.getEmpByEmpno(empno);
    }


}
