package com.javaconceptoftheday.reduceEx;

import com.core.mongo.coreEx.util.DBUtil;
import com.core.mongo.entity.Emp;

import java.io.IOException;
import java.util.List;

public class ReduceExamples {

    public static void main(String args[]) throws IOException {

        String filePath = "src/main/resources/employee.emp.json";
        List<Emp> empList = DBUtil.readEmployeeJson(filePath);

        //Get Max Sal
        Double doubleSumOfSal = empList.stream().mapToDouble(Emp::getSal).reduce(0.0, Double::sum);
        System.out.println("Sum of Sal: "+doubleSumOfSal);

        Integer sumOfSal = empList.stream().map(Emp::getSal).reduce(0, Integer::sum);
        System.out.println("Sum of Sal: "+sumOfSal);

        Integer minSal = empList.stream().map(Emp::getSal).reduce(Integer::min).get();
        Integer maxSal = empList.stream().map(Emp::getSal).reduce(0, Integer::max);
        System.out.println("Min Sal: "+minSal);
        System.out.println("Max Sal: "+maxSal);


    }

}
