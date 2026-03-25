package com.javaconceptoftheday.threads;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewEx1 {

    public static void main(String[] args) {

        String str = "java concepts are awesome";

        Arrays.asList(str.toCharArray()).stream().forEach(System.out::println);



        Stream.of(str.toCharArray()).forEach(System.out::println);

        String key = Stream.of(str.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(m -> m.getValue() == 1)
                .skip(1)
                .findFirst()
                .get().getKey();
        System.out.println("Key: "+key);

    }

}
