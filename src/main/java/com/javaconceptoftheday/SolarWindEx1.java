package com.javaconceptoftheday;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SolarWindEx1 {

    public static void main(String args[]) {

        String str = "ganapathi";
        str.chars()
                .mapToObj(c->((char)c))
                .forEach(System.out::println);

        Arrays.stream(str.split("")).forEach(System.out::println);

        System.out.println("/n");
        Arrays.asList(str.split(""))
                .stream().distinct().forEach(System.out::print);
        System.out.println("/n");
        Arrays.asList(str.split(""))
                .stream().collect(Collectors.groupingBy(c->c, Collectors.counting()))
                .forEach((k, v)-> System.out.println(k+" => "+v));

    }

}
