package com.core.mongo.coreEx.test.java8Ex;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaMathExpressionEx {

    public static void main(String args[]) {

        int x =2, y=4;

        //x qube 3 + y qube 3 + xy/3.
        double value = Math.pow(x, 3) + Math.pow(y, 3) + x * y % 3;
        System.out.println(value);

        int a=2, b=2;
        //a+b square + b
        double result = Math.pow(a+b, 2) + b;
        System.out.println(result);

        //a square + b square
        result = a*a + b*b;
        System.out.println(result);

        result = Math.sqrt(a) + Math.sqrt(b);
        System.out.println(result);

        result = (double) (a * a + b * b) / (a*a - b*b);
        System.out.println(result);

        result = Math.pow(a,3) + Math.pow(b,3) + (double) (x * y) / 3;
        System.out.println(result);

        int intArr[] = {1,2,3,4,5};
        int count = 0;
        for (int j : intArr) {
            count += j;
        }

        int expected = 6*7/2;
        System.out.println(expected+" "+count);
        System.out.println(expected - count);


        int dupArr[] = {3,2,5,3,5,7,8,4,5,6,8,9};

        List<Integer> list = Arrays.asList(3, 2, 5, 3, 5, 7, 8, 4, 5, 6, 8, 9);


        list.stream()
                .distinct()
                .sorted()
                .forEach(System.out::print);

       list.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(m->m.getValue() > 1)
                .forEach(m->System.out.println(m.getKey()));

        Map<Integer, Long> collect = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Map: "+collect);

        collect.entrySet()
                .stream()
                .filter(m->m.getValue() > 1)
                .forEach(m->System.out.println(m.getKey()));

        System.out.println();

        list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(m->m.getValue() > 1)
                .forEach(m->System.out.println(m.getKey()));

        System.out.println();

        Stream.iterate(1,i -> i+1)
                .limit(10)
                .forEach(System.out::println);

        System.out.println();

        Stream.generate(()-> new Random().nextInt(1,10))
                .limit(10)
                .distinct()
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Fibonacci Sequence");
        Stream.iterate(new int[]{0,1}, f->new int[]{f[1], f[0]+f[1]})
                .limit(8)
                .map(f->f[1])
                .forEach(System.out::println);


        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println("Take While....");
        intList.stream().takeWhile(l->l<=5)
                .forEach(System.out::println);

        System.out.println("Dorp While....");
        intList.stream().dropWhile(i->i<=5)
                .forEach(System.out::println);

        Stream.iterate(LocalDate.now(), date->date.plusDays(1))
                .limit(5)
                .forEach(System.out::println);







    }

}
