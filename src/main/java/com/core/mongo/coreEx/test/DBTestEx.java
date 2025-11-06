package com.core.mongo.coreEx.test;

import com.core.mongo.coreEx.util.DBUtil;
import com.core.mongo.entity.Emp;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class DBTestEx {

    public static void main(String args[]) throws IOException {

        //DBUtil.getConnection();

        String filePath = "/home/thanni/Documents/Intellij-workspace/CoreMongo/src/main/resources/employee.emp.json";

        List<Emp> empList = DBUtil.readEmployeeJson(filePath);

        System.out.println(empList.size());
        System.out.println();
        empList.stream().forEach(emp -> System.out.println(emp.getEmpno()+" "+emp.getEname()));
        System.out.println();
        empList.stream().sorted(Comparator.comparing(Emp::getSal).thenComparing(Emp::getEname)).forEach(emp -> System.out.println(emp.getSal()+" "+emp.getEname()));







    }

}
