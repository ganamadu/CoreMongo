package com.core.mongo.service;

import com.core.mongo.entity.Dept;
import com.core.mongo.entity.Emp;
import com.core.mongo.repo.DepartmentRepo;
import com.core.mongo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CompletableFutureEmpService {
    //CompletableFuture ModernEmpService

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    public CompletableFuture<List<Emp>> getEmpList() {
        return CompletableFuture.supplyAsync(() -> {
            return employeeRepo.findAll();
        });
    }

    public CompletableFuture<Emp> getEmpno(Integer empNo) {
        return CompletableFuture.supplyAsync(()->{
            return employeeRepo.findByEmpno(empNo).get();
        });
    }

    /*public CompletableFuture<Dept> getDeptByEmpno(Integer empNo) {
        return getEmpno(empNo)
                .thenCompose(emp ->{
                    return departmentRepo.findByDeptNo(emp.getEmpno()).get();
                });
    }*/





}
