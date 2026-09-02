package com.core.mongo.coreEx.facebookJava8Ex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class StringPlaindromeEx {
    public static boolean isPalindrom(String str) {
        return  IntStream.range(0,  str.length()/2)
                .allMatch(i->str.charAt(i) == str.charAt(str.length()-1-i));

    }
    public static void main(String args[]) {
        System.out.println(isPalindrom("liril"));
        System.out.println(isPalindrom("madam"));

        String[] strArr = {"Java","Java8","Java11","Java16","Java21","Java2Java"};

        String[] array = Arrays.asList(strArr)
                .stream()
                .map(str -> str.replace("Java", "Python"))
                .toArray(String[]::new);

        System.out.println();
        Arrays.asList(array)
                .stream()
                .forEach(System.out::println);

        System.out.println();

        List<Integer> intList = Arrays.asList(3,7,2,8,1,8,3,7,5,null);
        intList.stream()
                .sorted(Comparator.nullsFirst(Integer::compareTo))
                .distinct()
                .forEach(System.out::println);




    }
}
