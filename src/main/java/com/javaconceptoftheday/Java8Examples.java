package com.javaconceptoftheday;

import com.core.mongo.coreEx.util.DBUtil;
import com.core.mongo.entity.Emp;
import com.fasterxml.jackson.datatype.jdk8.OptionalSerializer;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Examples {

    public static boolean isPrime(int num) {
       return IntStream.rangeClosed(2, num/2).noneMatch(n->num%n == 0);
    }

    public static void main(String args[]) throws IOException {

        String filePath = "src/main/resources/employee.emp.json";

        List<Emp> empList = DBUtil.readEmployeeJson(filePath);

        //Second highest sal
        Emp secondHighestSal = empList.stream().sorted(Comparator.comparing(Emp::getSal).reversed()).skip(1).findFirst().get();
        System.out.println("Second Highest Sal: "+secondHighestSal.getEname()+" "+secondHighestSal.getSal());

        //Sort the emp sal
        System.out.println("Sort by sal");
        empList.stream().sorted(Comparator.comparing(Emp::getSal).thenComparing(Emp::getEname)).forEach(e->System.out.println("Sal: "+e.getSal()+" Ename: "+e.getEname()));

        //Avg sal, count, min and max sal:
        System.out.println("Summarizing Sal: ");
        IntSummaryStatistics summarizingSal = empList.stream().collect(Collectors.summarizingInt(Emp::getSal));
        System.out.println("Min Sal: "+summarizingSal.getMin());
        System.out.println("Max Sal: "+summarizingSal.getMax());
        System.out.println("Avg Sal: "+summarizingSal.getAverage());
        System.out.println("Sum Sal: "+summarizingSal.getSum());
        System.out.println("Count of Emp: "+summarizingSal.getCount());

        //Department wise Summarizing Sal
        System.out.println("\nDepartment wise Summarizing Sal: ");
        empList.stream().collect(Collectors.groupingBy(Emp::getDeptno, Collectors.summarizingInt(Emp::getSal)))
                .forEach((k, v) -> {
                    System.out.println("Dept No: "+k);
                    System.out.println("Max Sal: "+v.getMax());
                    System.out.println("Avg Sal: "+v.getAverage());
                    System.out.println("Sum Sal: "+v.getSum());
                    System.out.println("Count of Emp: "+v.getCount());
                });

        System.out.println("/Even And Odd Numbers");
        Map<Boolean, List<Integer>> evenAndOddNumList = IntStream.range(1, 10).boxed().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even Numbers: "+evenAndOddNumList.get(true));
        System.out.println("Odd Numbers: "+evenAndOddNumList.get(false));

        //Prime Numbers
        System.out.println("Print Prime Numbers: ");
        IntStream.rangeClosed(2,100).filter(n->isPrime(n)).forEach(System.out::println);
        int count = IntStream.rangeClosed(2,100).filter(n->isPrime(n)).reduce(5,(a,b)->a+b);
        System.out.println("Prime Numbers count: "+count);
        OptionalInt primeCount = IntStream.rangeClosed(2, 100).filter(n -> isPrime(n)).reduce((a, b) -> a + b);
        System.out.println("Prime Numbers count: "+primeCount);

        Optional<String> reduceString = Arrays.asList("Ganapathi", "Madu", "Thaneesh", "Madu").stream().reduce((str1, str2) -> str1 + "_" + str2);
        System.out.println("Reduce String: "+reduceString.get());

        System.out.println("Commession summerize Dept wise: ");
        empList.stream().collect(Collectors.groupingBy(Emp::getDeptno, Collectors.summarizingInt(e->Optional.ofNullable(e.getComm()).orElse(0))))
                .forEach((k,v)-> {
                    System.out.println("Dept No: "+k);
                    System.out.println("Max Comm: "+v.getMax());
                    System.out.println("Avg Comm: "+v.getAverage());
                    System.out.println("Sum Comm: "+v.getSum());
                    System.out.println("Count of Emp: "+v.getCount());
                });

        //9037040508

    }

}
