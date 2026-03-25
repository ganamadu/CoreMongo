package com.core.mongo.coreEx.test;

import com.core.mongo.coreEx.util.DBUtil;
import com.core.mongo.entity.Emp;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8TestEx {

    public static void main(String args[]) throws IOException {

        String filePath = "src/main/resources/employee.emp.json";

        List<Emp> empList = DBUtil.readEmployeeJson(filePath);

        Map<Integer, Double> groupByAvgSal = empList.stream().collect(Collectors.groupingBy(Emp::getDeptno, Collectors.averagingDouble(Emp::getSal)));
        System.out.println(groupByAvgSal);

        System.out.println();

        empList.stream().map(Emp::getEmpno);

        Map<Integer, List<Emp>> employeeListByDept = empList.stream().collect(Collectors.groupingBy(Emp::getDeptno));
        System.out.println(employeeListByDept);
        employeeListByDept.entrySet().stream().forEach(k->{
            k.getValue().stream().forEach(e->System.out.println(e.getEmpno()+" "+e.getEname()+" "+e.getDeptno()+" "+e.getJob()));
        });

        System.out.println();
        Map<Integer, Long> empCountByDeptno = empList.stream().collect(Collectors.groupingBy(Emp::getDeptno, Collectors.counting()));
        System.out.println(empCountByDeptno);

        System.out.println();

        empList.stream().map(Emp::getDeptno).distinct().forEach(System.out::println);
        System.out.println();
        Map<Integer, Double> avgSalByDeptno = empList.stream().collect(Collectors.groupingBy(Emp::getDeptno, Collectors.averagingDouble(Emp::getSal)));
        System.out.println("AvgSal"+avgSalByDeptno);
        System.out.println();
        Emp maxSalEmp = empList.stream().max(Comparator.comparing(Emp::getSal)).get();
        System.out.println("Max Sal: "+maxSalEmp.getEname()+" "+maxSalEmp.getSal());

        System.out.println();
        Emp minSalEmp = empList.stream().min(Comparator.comparing(Emp::getSal)).get();
        System.out.println("Min Sal: "+minSalEmp.getEname()+" "+minSalEmp.getSal());
        System.out.println("\nManager Names: ");
        empList.stream().filter(emp -> emp.getJob().equals("MANAGER")).map(Emp::getEname).forEach(System.out::println);

        String empNames = empList.stream().map(Emp::getEname).sorted().collect(Collectors.joining(","));
        System.out.println("\nEmp Names: "+empNames);

        Map<Integer, Emp> empMap = empList.stream().collect(Collectors.toMap(Emp::getEmpno, Function.identity()));
        System.out.println("\n EmpMap: "+empMap);
        empMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(m->System.out.println(m.getKey()+" "+m.getValue().getEname()));

        DoubleSummaryStatistics empStatics = empList.stream().collect(Collectors.summarizingDouble(Emp::getSal));
        System.out.println("\n Total Sal: "+empStatics.getSum()+" AvgSal: "+empStatics.getAverage());
        System.out.println("\n Min Sal: "+empStatics.getMin()+" Max Sal: "+empStatics.getMax());

        Map<String, Integer> sortedBerorMap = empList.stream().collect(Collectors.toMap(Emp::getEname, Emp::getSal));
        System.out.println("/n Before Sorting: "+sortedBerorMap);
        System.out.println("/n After Sorting:");
        sortedBerorMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(m-> System.out.println(m.getKey()+" "+m.getValue()));

        System.out.println("Get the second highest sal: ");

        Emp secondHighestSal = empList.stream().sorted(Comparator.comparing(Emp::getSal).reversed()).skip(1).findFirst().get();
        System.out.println(secondHighestSal.getSal());

        List<String> strList = new ArrayList<>(Arrays.asList("One","Two","Three","Four","Five"));
        System.out.println("Before list: "+strList);
        strList.removeIf(str -> str.equals("Three"));
        System.out.println("After list: "+strList);

        System.out.println("Statics of Sal:");
        empList.stream()
                .collect(Collectors.groupingBy(Emp::getDeptno, Collectors.summarizingInt(Emp::getSal)))
                .entrySet()
                .forEach(m->{
                    System.out.println("--------------------");
                    System.out.println("Dept No: "+m.getKey());
                    System.out.println("Emp Count: "+m.getValue().getCount());
                    System.out.println("Max Sal: "+m.getValue().getMax());
                    System.out.println("Min Sal: "+m.getValue().getMin());
                    System.out.println("Avg Sal: "+m.getValue().getAverage());
                    System.out.println("Sum Of Sal: "+m.getValue().getSum());
                    System.out.println("--------------------");
                });

        System.out.println("Statics of Comm:");
        empList.stream()
                .collect(Collectors.groupingBy(Emp::getDeptno, Collectors.summarizingInt(e->Optional.ofNullable(e.getComm()).orElse(0))))
                .entrySet()
                .forEach(m->{
                    System.out.println("--------------------");
                    System.out.println("Dept No: "+m.getKey());
                    System.out.println("Emp Count: "+m.getValue().getCount());
                    System.out.println("Max Comm: "+m.getValue().getMax());
                    System.out.println("Min Comm: "+m.getValue().getMin());
                    System.out.println("Avg Comm: "+m.getValue().getAverage());
                    System.out.println("Sum Of Comm: "+m.getValue().getSum());
                    System.out.println("--------------------");
                });

        System.out.println("Even or Odd Numbers: ");
        Map<Boolean, List<Integer>> evenOrOddNum = IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even Num: "+evenOrOddNum.get(true));
        System.out.println("Odd Num: "+evenOrOddNum.get(false));

        System.out.println("Reduce Numbers: ");
        Integer sumOfInt = IntStream.rangeClosed(1, 10)
                .boxed()
                .reduce(Integer::sum).get();
        System.out.println("Sum Of Int: "+sumOfInt);

        System.out.println("Random Num: ");
        Stream.generate(()->new Random().nextInt(100))
                .distinct()
                .limit(10)
                .forEach(System.out::println);

        System.out.println("Iterate Num: ");
        Stream.iterate(1,n->n+1)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("Print the InteList values:");
        List<Integer> intlist = Arrays.asList(7,5,9,2,6,1,3,null);
        intlist.stream().sorted(Comparator.nullsFirst(Integer::compareTo))
                .forEach(System.out::println);


    }


}
