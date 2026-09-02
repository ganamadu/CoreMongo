package com.core.mongo.coreEx.test.java8Ex;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CharacterEx {

    public static boolean isPrime(int num) {
        return IntStream.rangeClosed(2, num / 2)
                .boxed()
                .noneMatch(n -> num % n == 0);
    }

    public static void main(String args[]) {
        IntStream.rangeClosed('a','z')
                .mapToObj(c->(char) c)
                .forEach(System.out::println);

        System.out.println();
        IntStream.rangeClosed('A','Z')
                //.mapToObj(c->(char) c)
                .forEach(System.out::println);

        Stream.iterate('a', c->(char) (c+1))
                .limit(26)
                .forEach(System.out::println);

        System.out.println();

        Stream.generate(() -> new Random('a').nextInt())
                .limit(26)
                .forEach(System.out::println);

        List<Integer> list = Stream.iterate(0, i -> i + 1)
                .limit(50).collect(Collectors.toList());

        splitList(list, 3);

        System.out.println();

        IntStream.rangeClosed(2,100)
                .boxed()
                .filter(CharacterEx::isPrime)
                .forEach(System.out::println);
    }

    public static void splitList(List<Integer> list, int factor){
        int total = list.size();
        int chunkSize = (int) Math.ceil((double) total/factor);
        for(int i=0; i<factor; i++) {
            int from = (i*chunkSize)+1;
            int to = Math.min((i+1) * chunkSize, total);
            System.out.println("From: "+from +" To: "+to);
        }
    }

}
