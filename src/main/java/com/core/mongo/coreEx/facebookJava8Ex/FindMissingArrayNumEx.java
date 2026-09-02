package com.core.mongo.coreEx.facebookJava8Ex;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindMissingArrayNumEx {

    public static void main(String[] args) {

        int arr[] = {1,5,5,7,9};

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        System.out.println("Min: "+min+" Max: "+max);

        Set<Integer> intSet = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        IntStream.range(min, max)
                .filter(i->!intSet.contains(i))
                .forEach(System.out::println);

        Integer a = 128;
        Integer b = 128;
        int c = 128;
        int d = 128;
        System.out.println(128==128);
        System.out.println(a==b);
        System.out.println(c==d);

    }

}
