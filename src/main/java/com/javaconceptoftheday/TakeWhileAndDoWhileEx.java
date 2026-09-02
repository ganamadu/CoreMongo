package com.javaconceptoftheday;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TakeWhileAndDoWhileEx {

    public static void main(String[] args) {

        List<Integer> intStream = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        intStream.stream().takeWhile(n->n<=5)
                .forEach(System.out::println);
        System.out.println();
        intStream.stream().dropWhile(n->n<=5)
                .forEach(System.out::println);

        System.out.println("Fibonacci Sequence");
        Stream.iterate(new int[]{0,1}, f->new int[]{f[1],f[0]+f[1]})
                .limit(8)
                .map(f->f[0])
                .forEach(s->System.out.printf("% d%n", s));

        System.out.println("Iterate dates: ");
        Stream.iterate(LocalDate.now(), date->date.plusDays(1))
                .limit(5)
                .forEach(System.out::println);

        System.out.println("Generate Random UUID");
        Stream.generate(UUID::randomUUID)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("Generate random otp");
        Stream.generate(()->(int) (Math.random() * 9000) + 1000)
                .limit(5)
                .forEach(System.out::println);

        System.out.println();
        System.out.println((int)(Math.random() * 9000) + 1000);
        System.out.println("Generate secure random otp");
        SecureRandom secureRandom = new SecureRandom();
        Stream.generate(()->(int)(secureRandom.nextInt(9000)+1000))
                .limit(5)
                .forEach(System.out::println);

    }


}
