package com.core.mongo.coreEx.test.java8Ex;

import java.util.Map;
import java.util.stream.Collectors;

public class NonRepeatedStringEx {

    public static void main(String[] args) {

        String str = "ganapathi";
        str.chars().mapToObj(c->(char)c).forEach(System.out::println);

        str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, Collectors.counting()))
                .forEach((k,v)->{
                    System.out.println("Character: "+k+" Value: "+v);
                });

        //Print the All Non-Repeated character
        str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue() == 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

        System.out.println();
        //Print the All Repeated character
        str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue() > 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);


    }

}
