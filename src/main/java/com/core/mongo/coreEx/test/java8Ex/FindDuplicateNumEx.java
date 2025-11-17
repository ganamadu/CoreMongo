package com.core.mongo.coreEx.test.java8Ex;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindDuplicateNumEx {

    public static void main(String args[]) {

        Set<Integer> numSet = new HashSet<>();

        List<Integer> intList = Stream.of(2, 2, 4, 5, 5, 6, 4, 7, 2, 1, 8, 6, 9, 3, 1, 4, 3).collect(Collectors.toList());

        //print distinct number
        intList.stream().distinct().sorted().forEach(System.out::print);
        System.out.println("\n Duplicates:  ");
        //Find duplicates
        intList.stream().filter(n->!numSet.add(n)).forEach(System.out::println);
        System.out.print("\n"+numSet);

        //Reduce
        System.out.println("\n Reduce: "+intList.stream().reduce(0, (a,b)->a+b).intValue());

        //Frequency
        Map<Integer, Long> numFreqMap = intList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.print("\n "+numFreqMap);

        Map.Entry<Integer, Long> maxFrequencyEntry = numFreqMap.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get();
        System.out.println("\nMax Frequency: "+maxFrequencyEntry);

        System.out.print("\n Prime Numbers: ");
        IntStream.range(2,100).filter(n->isPrime(n)).forEach(System.out::println);

        //Print Even and Odd Numbers
        Map<Boolean, List<Integer>> evenOddNumbers = IntStream.range(1, 10).boxed().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        List<Integer> evenNumbers = evenOddNumbers.get(true);
        System.out.println("\n Even Numbers: "+evenNumbers);
        List<Integer> oddNumbers = evenOddNumbers.get(false);
        System.out.println("\n Odd Numbers: "+oddNumbers);

        //Reduce
        Integer reduceNumCount = IntStream.range(1,9).boxed().reduce(0, (a,b)->a+b).intValue();
        System.out.println("\n Reduc: "+reduceNumCount);
    }


    public static boolean isPrime(int num) {
       return IntStream.rangeClosed(2, num/2).noneMatch(i->num%i==0);
    }

}
