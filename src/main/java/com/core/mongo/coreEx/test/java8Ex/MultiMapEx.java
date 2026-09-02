package com.core.mongo.coreEx.test.java8Ex;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MultiMapEx {

    public static void main(String[] args) {

        List<Integer> result = Stream.of(1,2,3,4)
                .<Integer>mapMulti((num, consumer) -> {
                    consumer.accept(num);
                    consumer.accept(num * 10);
                })
                .toList();

        System.out.println("Result: "+result);

        IntStream.range(0, result.size())
                .filter(i->i%2==0)
                .mapToObj(result::get)
                .forEach(System.out::println);




    }

}
