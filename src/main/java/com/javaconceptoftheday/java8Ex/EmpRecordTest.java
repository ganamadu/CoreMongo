package com.javaconceptoftheday.java8Ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmpRecordTest {

    public static void main(String args[]) {

        List<Emp> empList = new ArrayList<>();
        empList.add(new Emp(101, "Ganapathi", 10000, "Male"));
        empList.add(new Emp(102, "Srilatha", 80000, "Female"));
        empList.add(new Emp(103, "Bujji", 40000, "Female"));
        empList.add(new Emp(104, "Thaneesh", 20000, "Male"));
        empList.add(new Emp(105, "Rishith", 10000, "Male"));

        Map<Boolean, List<Emp>> maleOrFemaleList = empList.stream().collect(Collectors.partitioningBy(e -> e.gender().equalsIgnoreCase("male")));
        System.out.println("Female List: ");
        maleOrFemaleList.get(false).stream().forEach(e->System.out.println("Name: "+e.ename()+", Gender: "+e.gender()));
        System.out.println("Male List: ");
        maleOrFemaleList.get(true).stream().forEach(e->System.out.println("Name: "+e.ename()+", Gender: "+e.gender()));

        System.out.println();
        empList.stream().collect(Collectors.groupingBy(Emp::gender, Collectors.counting()))
                .entrySet()
                .stream()
                .forEach(m->System.out.println("Gender: "+m.getKey()+" Count: "+m.getValue()));


        System.out.println("-----------------------------------------------");
        empList.stream().collect(Collectors.groupingBy(Emp::gender, Collectors.summarizingDouble(Emp::sal)))
                .entrySet()
                .stream()
                .forEach(m->{
                    System.out.println("Gender: "+m.getKey());
                    System.out.println("Avg Sal: "+m.getValue().getAverage());
                    System.out.println("Count Sal: "+m.getValue().getCount());
                    System.out.println("Max Sal: "+m.getValue().getMax());
                    System.out.println("Min Sal: "+m.getValue().getMax());
                    System.out.println("Sum Of Sal: "+m.getValue().getSum());
                    System.out.println("-----------------------------------------------");
                });


    }

}
