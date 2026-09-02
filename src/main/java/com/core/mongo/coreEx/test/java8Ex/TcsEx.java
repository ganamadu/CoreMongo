package com.core.mongo.coreEx.test.java8Ex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TcsEx {
    int i;

    public static void main(String[] args) {

        //In array find the jave keyword and replace with python using java8 streams.
        String[] list = {"Java","Streams","Java","Java8","Functional","7Java","Java"};

        List<String> strList = Arrays.asList(list);

        strList.stream().map(s -> s.contains("Java") ? s.replace("Java", "Python") : s)
                .forEach(System.out::println);

        //add two numbers using functional Interface

        Map<Integer, List<String>> collect = strList.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(collect);

        strList.stream()
                .map(s->s.replace("Java","Python"))
                .forEach(System.out::println);

        System.out.println("I value:"+new TcsEx().i);



    }

}
