package com.javaconceptoftheday.java8Ex;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumOfEvenOddNumEx {

    public static void main(String args[]) {

        IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.partitioningBy(i->i%2==0))
                .entrySet()
                .stream()
                .forEach(m -> {
                    System.out.println(!m.getKey()?"Odd: ":"Even: ");
                    System.out.println("Count Of Num: "+m.getValue().stream().count());
                    System.out.println("Sum Of Num: "+m.getValue().stream().reduce(Integer::sum).orElse(0));
                });

    }

}
