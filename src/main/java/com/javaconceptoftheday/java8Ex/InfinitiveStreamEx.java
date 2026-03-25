package com.javaconceptoftheday.java8Ex;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfinitiveStreamEx {

    public static void main(String[] args) {

        System.out.println("Infinitive Stream Iterate: ");
        Stream.iterate(0, i->i+2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("Infinitive Stream Generate: ");

        Stream.generate(()->new Random().nextInt(100))
                .limit(5)
                .forEach(System.out::println);

        System.out.println("Print the 2,4,6,16 ....");

        IntStream.rangeClosed(1, 5)
                .map(i->(int)Math.pow(2, i))
                .forEach(System.out::println);


        System.out.println("sentances: ");
        String[] sentances = {
                "Here is a #sample sentences in #java.",
                "This is another #example of a #scentance.",
                "#Java streams #are powerful.",
                "Find words that start with #." } ;

        Arrays.stream(sentances)
                .flatMap(s->Arrays.stream(s.split("\\s+")))
                .filter(w->w.startsWith("#"))
                .map(w->w.replaceAll("[^#a-zA-z0-9]",""))
                .map(String::toLowerCase)
                .forEach(System.out::println);

        Arrays.stream(sentances)
                .flatMap(s->Arrays.stream(s.split("\\s+")))
                .filter(w->w.startsWith("#"))
                .map(w->w.replaceAll("^#a-zA-Z0-9", ""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .forEach(m->System.out.println(m.getKey()+" : "+m.getValue()));

    }


}
