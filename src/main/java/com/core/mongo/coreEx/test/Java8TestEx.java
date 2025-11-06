package com.core.mongo.coreEx.test;

import com.core.mongo.coreEx.util.DBUtil;
import com.core.mongo.entity.Emp;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Java8TestEx {

    public static void main(String args[]) throws IOException {

        String filePath = "/home/thanni/Documents/Intellij-workspace/CoreMongo/src/main/resources/employee.emp.json";

        List<Emp> empList = DBUtil.readEmployeeJson(filePath);

        Map<Integer, Double> groupByAvgSal = empList.stream().collect(Collectors.groupingBy(Emp::getDeptno, Collectors.averagingDouble(Emp::getSal)));
        System.out.println(groupByAvgSal);

        System.out.println();

        empList.stream().map(Emp::getEmpno);



    }

}
