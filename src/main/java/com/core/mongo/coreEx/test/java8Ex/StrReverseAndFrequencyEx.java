package com.core.mongo.coreEx.test.java8Ex;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StrReverseAndFrequencyEx {

    public static void main(String args[]) {

        String str = "This is my first java program and this is new java program";
        Stream.of(str.split(" ")).forEach(System.out::println);
        //Frequency
        Map<String, Long> wordsCount = Stream.of(str.split(" ")).collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        System.out.println(wordsCount);

        //Reverse Word
        Stream.of(str.split(" ")).map(word->new StringBuilder(word).reverse()).forEach(System.out::println);

    }

}
