package com.javaconceptoftheday.java8Ex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringVowelsCountEx {

    public static void main(String args[]) {

        String str = "java concepts are awesome";

        Map<String, Long> vowelsCount = new HashMap<>();

        Arrays.asList(str.split(" "))
                .stream()
                .forEach(w -> {
                    long count = w.toLowerCase().chars()
                            .mapToObj(c->(char) c)
                            .filter(c->c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
                            .count();

                    vowelsCount.put(w, count);
                });
        System.out.println("vowelsCount: "+vowelsCount);


        Map<String, Long> vowelsCunts = Arrays.stream(str.split(" "))
                .collect(Collectors.toMap(
                        w -> w,
                        w -> w.toLowerCase()
                                .chars()
                                .filter(c -> "aeiou".indexOf(c) != -1)
                                .count()
                ));

        System.out.println("vowelsCunts: "+vowelsCunts);

        Map<String, Map<Character, Long>> stringVowelsCount = Arrays.stream(str.split(" "))
                .collect(Collectors.toMap(
                        w -> w,
                        w -> w.toLowerCase()
                                .chars()
                                .mapToObj(c -> (char) c)
                                .filter(c -> "aeio".indexOf(c) != -1)
                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                ));

        System.out.println("stringVowelsCount: "+stringVowelsCount);

         String str1 = "aeioua";
        System.out.println(str1.indexOf('a'));
        System.out.println(str1.lastIndexOf('a'));
        System.out.println(str1.indexOf('b'));
        System.out.println(str1.indexOf('c'));

    }

}
