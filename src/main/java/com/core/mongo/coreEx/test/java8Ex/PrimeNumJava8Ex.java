package com.core.mongo.coreEx.test.java8Ex;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumJava8Ex {

    public static boolean isPrime(Integer num) {
       return IntStream.rangeClosed(2, num/2).noneMatch(n->num%n==0);
    }
    
    public static void main(String args[]) {

        List<Integer> intList = IntStream.range(0, 10).boxed().collect(Collectors.toList());

        //intList.stream().forEach(System.out::println);

        IntStream.range(2, 100).boxed().filter(n->isPrime(n)).forEach(System.out::println);


    }
    
}
