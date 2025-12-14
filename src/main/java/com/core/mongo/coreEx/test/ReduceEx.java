package com.core.mongo.coreEx.test;

import com.core.mongo.coreEx.util.DBUtil;
import com.core.mongo.entity.Emp;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class ReduceEx {

    public static void main(String[] args) throws IOException {

        String filePath = "src/main/resources/employee.emp.json";
        List<Emp> empList = DBUtil.readEmployeeJson(filePath);
        
        Integer reduceSum = List.of(2, 4, 7, 8, 9, 4, 6, 7).stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum: "+reduceSum);

        Optional<Integer> reduceSum1 = List.of(2, 4, 7, 8, 9, 4, 6, 7).stream().reduce( (a, b) -> a + b);
        System.out.println("Sum: "+reduceSum1.get());

        //Sum of Emp Sal
        Integer reduceSalSum = empList.stream().map(Emp::getSal).reduce(0, Integer::sum);
        Integer reduceCommSum = empList.stream().map(emp->Optional.ofNullable(emp.getComm()).orElse(0)).reduce(0, Integer::sum);

        System.out.println("Sum of Sal: "+reduceSalSum+" Sum of Comm: "+reduceCommSum);

        //Max Sal
        Optional<Emp> maxEmpSal = empList.stream().reduce(BinaryOperator.maxBy(Comparator.comparing(Emp::getSal)));
        System.out.println(maxEmpSal.get().getSal());
    }

}
