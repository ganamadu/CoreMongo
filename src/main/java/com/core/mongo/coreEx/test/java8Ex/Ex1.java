package com.core.mongo.coreEx.test.java8Ex;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex1 {

    public static void main(String args[]) {

        String str = "java concepts are awesome";

        Arrays.asList(str.split(""));

        //IntStream.of(9,4,5,2,7,6,1,3,null);

        Arrays.asList(9,4,5,2,7,6,1,3,null)
                .stream()
                .sorted(Comparator.nullsFirst(Integer::compareTo))
                .forEach(System.out::println);


        LinkedHashMap<Character, Long> collect = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        Map.Entry<Character, Long> characterLongEntry = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(m -> m.getValue() == 1)
                .skip(1)
                .findFirst()
                .get();

        Character c1 = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey)
                .skip(1)
                .findFirst()
                .get();


    }

}
