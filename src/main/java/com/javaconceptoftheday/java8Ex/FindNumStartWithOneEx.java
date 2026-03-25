package com.javaconceptoftheday.java8Ex;

import java.util.stream.IntStream;

public class FindNumStartWithOneEx {

    public static void main(String args[]) {

        //Print number start with 1
        IntStream.of(11, 18, 20, 24, 85, 66, 13)
                .mapToObj(Integer::toString)
                .filter(n->n.startsWith("1"))
                .forEach(System.out::println);

        System.out.println();
        //Only Qube the even numbers
        IntStream.rangeClosed(1,10)
                .boxed()
                .filter(i->i%2==0)
                .map(i->i*i*i)
                .forEach(System.out::println);


    }

}
