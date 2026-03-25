package com.core.mongo.coreEx.test.java8Ex;

import com.core.mongo.coreEx.util.DBUtil;
import com.core.mongo.entity.Emp;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8StreamEx {

    public static boolean isPrime(Integer num) {
        return IntStream.rangeClosed(2, num/2).noneMatch(n->num%n==0);
    }

    public static void main(String args[]) throws IOException {

        String filePath = "src/main/resources/employee.emp.json";
        List<Emp> empList = DBUtil.readEmployeeJson(filePath);

        Map<Integer, Emp> empMap = empList.stream().collect(Collectors.toMap(Emp::getEmpno, Function.identity()));
        empList.stream().sorted(Comparator.comparing(Emp::getSal).thenComparing(Emp::getEname))
                .forEach(e->System.out.println(e.getSal()+" "+e.getEname()));

        Emp thirdHighestSal = empList.stream().sorted(Comparator.comparing(Emp::getSal).reversed()).skip(2).findFirst().get();
        System.out.println("Third Highest Sal: "+thirdHighestSal.getSal());

        //Summerizing by sal
        empList.stream().collect(Collectors.groupingBy(Emp::getDeptno, Collectors.summarizingInt(Emp::getSal)))
                .forEach((k,v)->{
                    System.out.println("\n Deptno: "+k);
                    System.out.println("Emp Max Sal: "+v.getMax());

                    System.out.println("Emp Min Sal: "+v.getMin());
                    System.out.println("Emp Sum Of Sal: "+v.getSum());
                    System.out.println("Emp Count Of Sal: "+v.getCount());
                    System.out.println("Emp Avg Of Sal: "+v.getAverage());
                });

        //Summerizing by Comm
        System.out.println("\n Summerizing by Commession: ");
        empList.stream().collect(Collectors.groupingBy(Emp::getDeptno, Collectors.summarizingInt(e-> Optional.ofNullable(e.getComm()).orElse(0))))
                .forEach((k, v) -> {
                    System.out.println("\n Deptno: "+k);
                    System.out.println("Emp Max Comm: "+v.getMax());
                    System.out.println("Emp Min Comm: "+v.getMin());
                    System.out.println("Emp Sum Of Comm: "+v.getSum());
                    System.out.println("Emp Count Of Comm: "+v.getCount());
                    System.out.println("Emp Avg Of Comm: "+v.getAverage());
                });

        System.out.println("Print Prime Numbers: ");
        IntStream.range(2,100).boxed().filter(n->isPrime(n)).forEach(System.out::println);

        System.out.println("Reduce Comm: ");

        Integer reduceSalSum = empList.stream().map(Emp::getSal).reduce(0, Integer::sum);
        Integer reduceCommSum = empList.stream().map(emp->Optional.ofNullable(emp.getComm()).orElse(0)).reduce(0, Integer::sum);

        System.out.println("Sum of Sal: "+reduceSalSum+" Sum of Comm: "+reduceCommSum);

        String str = "java concepts are awesome";
        str.chars();
        System.out.println("Chars:  ");
        str.chars().mapToObj(c->(char) c).forEach(System.out::println);
        Character secondNonRepeatedChar = str.chars().mapToObj(c->(char) c)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(m->m.getValue()==1)
                .skip(1)
                .findFirst()
                .get()
                .getKey();
        System.out.println("SecondNonRepeatedChar: "+secondNonRepeatedChar);

        System.out.println("With Null: ");
        List<Integer> list = Arrays.asList(5,3,8,2,9,1,null);
        list.stream().sorted(Comparator.nullsFirst(Integer::compareTo))
                .forEach(System.out::println);

        System.out.println("Non Null:");
        list.stream().filter(Objects::nonNull)
                .sorted().forEach(System.out::println);


        System.out.println("Map Sorting: :");
        System.out.println("Map Sorting: :");
        empMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Emp::getSal)
                        .thenComparing(Emp::getEname)))
                .forEach(m->System.out.println(m.getValue().getSal()+" "+m.getValue().getEname()));




    }


}
