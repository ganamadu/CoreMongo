package com.core.mongo.coreEx.test;

import java.util.List;
import java.util.Optional;

public class ReduceEx {

    public static void main(String[] args) {

        Integer reduceSum = List.of(2, 4, 7, 8, 9, 4, 6, 7).stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum: "+reduceSum);

        Optional<Integer> reduceSum1 = List.of(2, 4, 7, 8, 9, 4, 6, 7).stream().reduce( (a, b) -> a + b);
        System.out.println("Sum: "+reduceSum1.get());


    }

}
