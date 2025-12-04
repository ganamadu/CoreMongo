package com.javaconceptoftheday.stringsEx;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringExample {

    public static void main(String[] args) {

        String name = "ganapathi";
        System.out.println(name.substring(0,name.length()/2)+name.substring(name.length()/2, name.length()).toUpperCase());

        String str1 = "GaNaPaThI";
        StringBuilder sb = new StringBuilder();
        for(Character c : str1.toCharArray()) {
            if(Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(Character.toUpperCase(c));
            }
        }
        System.out.println("Before: "+str1);
        System.out.println("After: "+sb.toString());

        IntStream.of(11, 18, 20, 24, 85, 66, 13).filter(n->String.valueOf(n).startsWith("1")).forEach(System.out::println);

        Map<Boolean, List<String>> startWith1List = IntStream.of(11, 18, 20, 24, 85, 66, 13).boxed().map(String::valueOf).collect(Collectors.partitioningBy(s -> s.startsWith("1")));
        System.out.println("Number Start with 1: "+startWith1List.get(true));
        System.out.println("Number Not Start with 1: "+startWith1List.get(false));

        List<Integer> startWith1integerList = IntStream.of(11, 18, 20, 24, 85, 66, 13).boxed().map(String::valueOf)
                .filter(s -> s.startsWith("1"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println("Start with one: "+startWith1integerList);

    }

}
