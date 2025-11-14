package com.core.mongo.coreEx.test.java8Ex;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SeparateEvenAndOddNumEx {

    public static void main(String args[]) {

        List<Integer> intList = IntStream.range(1,100).boxed().collect(Collectors.toList());

        Map<Boolean, List<Integer>> partitionNumbers = intList.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("partitionNumbers: "+partitionNumbers);

        List<Integer> evenNumbers = partitionNumbers.get(true);
        List<Integer> oddNumbers = partitionNumbers.get(false);

        System.out.println("\n Even Numbers: "+evenNumbers);
        System.out.println("\n Odd Numbers: "+oddNumbers);

    }

}
