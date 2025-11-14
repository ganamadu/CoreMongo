package com.core.mongo.coreEx.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindListDuplicates {

    public static void main(String args[]) {

        List<Integer> intList = List.of(1,2,2,3,4,5,5,5,6,7,7,8,8,8,8,9);

        Set<Integer> intSet = new HashSet<>();

        Set<Integer> collect = intList.stream().filter(i -> !intSet.add(i)).collect(Collectors.toSet());
        System.out.println(collect);

        intList.stream().distinct().forEach(System.out::println);

    }

}
