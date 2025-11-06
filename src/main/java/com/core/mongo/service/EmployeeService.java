package com.core.mongo.service;

import com.core.mongo.entity.Emp;
import com.core.mongo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Emp getEmpByEmpno(Integer empno) {
        return employeeRepo.findByEmpno(empno).get();
    }

    public List<Emp> getEmpList() {
        return employeeRepo.findAll();
    }

}
