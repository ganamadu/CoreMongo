package com.core.mongo.coreEx.test.java8Ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FbEx1 {

    public static void main(String[] args) {
        System.out.println(5 / 2 * 2);
        System.out.println(5 / 2 * 2.0);
        System.out.println(5 / 2.0 * 2.0);

        List list1 = Arrays.asList(1,4,3,6,8,9);
        List list2 = Arrays.asList(1,5,4,3,7,6,8,9);

        Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println('A'+1);





    }

}
