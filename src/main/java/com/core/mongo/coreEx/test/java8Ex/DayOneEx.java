package com.core.mongo.coreEx.test.java8Ex;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class DayOneEx {

    public static void main(String[] args) {

        Integer sum = IntStream.rangeClosed(1, 7)
                .boxed()
                .reduce(Integer::sum).get();
        System.out.println("Sum: "+sum);

        IntStream.rangeClosed(1, 9)
                .boxed()
                .reduce(0, (n1, n2)->n1+n2);

        Integer reduce = IntStream.rangeClosed(1, 8)
                .boxed()
                .reduce(Integer::compareTo).get();

        System.out.println("Compare: "+reduce);

        int arr[] = {1,4,5,8,9};
        for (int i : getArr(9, arr)) {
            System.out.println(i);
        }

        System.out.println(3*3*3);

        List<Integer> list1 = Arrays.asList(1,2,6,7,8,3);
        List<Integer> list2 = Arrays.asList(3,4,5,6,7,8,9);

        List<Integer> list = list1.stream()
                .filter(list2::contains).toList();
        System.out.println("List: "+list);

        List<Integer> list11 = list1.stream()
                .filter(Predicate.not(list2::contains)).toList();
        System.out.println("List11: "+list11);


    }

    public static int[] getArr(int target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            int compare = target - arr[i];
            if(map.containsKey(compare)) {
                return new int[] {map.get(compare), i};
            }
            map.put(arr[i], i);
        }
        return new int[] {};
    }

}
