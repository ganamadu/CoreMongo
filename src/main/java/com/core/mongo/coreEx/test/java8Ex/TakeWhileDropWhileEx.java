package com.core.mongo.coreEx.test.java8Ex;

import java.util.Arrays;
import java.util.List;

public class TakeWhileDropWhileEx {

    public static void main(String args[]) {

        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9);

        //TakeWhile
        System.out.println("TakeWhile: ");
        intList.stream()
                .takeWhile(n->n<=5)
                .forEach(System.out::println);

        //DropWhile
        System.out.println("DropWhile: ");
        intList.stream()
                .dropWhile(n->n<=5)
                .forEach(System.out::println);


    }

}
