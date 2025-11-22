package com.core.mongo.coreEx.test.java8Ex;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Ex1 {

    public static boolean isPrime(int num) {
        return IntStream.rangeClosed(0, num/2).noneMatch(i->num%2==0);
    }

    public static void main(String args[]) {

        IntStream.rangeClosed(2, 100).filter(n->isPrime(n)).forEach(System.out::println);

        System.out.println("\n Print Even Odd Numbers: ");
        Map<Boolean, List<Integer>> evenOddNum = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        List<Integer> evneNumList = evenOddNum.get(true);
        List<Integer> oddNumList = evenOddNum.get(false);
        System.out.println("Even: "+evneNumList);
        System.out.println("Odd: "+evneNumList);

        //Common elements between two lists.IntStream.range(5, 10).boxed().collect(Collectors.toList()
        System.out.println("\n Common Elements between to lists" );
        List<Integer> intList1 = IntStream.range(1, 10).boxed().collect(Collectors.toList());
        IntStream.range(7,15).boxed().filter(intList1::contains).forEach(System.out::println);

        //Sort the based on string length
        Stream.of("Ganapathi","Stilatha", "Thannesh", "Rishith")
                .sorted(Comparator.comparing(String::length)).forEach(System.out::println);

        //Merge the two arrays
        int[] a = new int[] {4, 2, 7, 1};
        int[] b = new int[] {8, 3, 9, 5};
        System.out.println("\n Merge the two arrays: ");
        IntStream.concat(Arrays.stream(a), Arrays.stream(b)).forEach(System.out::println);

        // sum of all digits of a number in Java 8
        int num = 156732;
        Integer sumOfDigits = Stream.of(String.valueOf(num).split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println("\n Sum Of Digits: "+sumOfDigits);



    }

}
