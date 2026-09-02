package com.core.mongo.coreEx.test.java8Ex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class JavaInfinitiesEx {

    public static void main(String[] args) {

        System.out.println("Stream.Generate.....");

        Stream.generate(() -> new Random().nextInt(100))
                .limit(10)
                .forEach(System.out::println);

        System.out.println("Stream.Iterate.....");

        Stream.iterate(0, i->i+1).limit(100)
                .map(Object::toString)
                .filter(n->n.startsWith("5"))
                .forEach(System.out::println);

        System.out.println("Sort null fist ex....");

        Arrays.asList(6,2,7,4,9,3,null)
                .stream()
                .sorted(Comparator.nullsFirst(Integer::compareTo))
                .forEach(System.out::println);


        Integer secondHighest = Arrays.asList(6,2,7,4,9,3,1)
                .stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();
        System.out.println("Second Highest: "+secondHighest);

        Stream<String> strList = Stream.of("One","Two","Three","Four","Five");

        strList.filter(s->s.contains("o") || s.contains("O"))
                .forEach(System.out::println);

        strList.forEach(System.out::println);






    }

}
